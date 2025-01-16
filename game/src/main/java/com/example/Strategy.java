// package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Strategy {

    private final Team team;

    public Strategy(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    // 移動可能な最初の潜水艦を変えす
    public Submarine canPlace(Map map, int y, int x) {
        MapCell cell = map.getCell(y, x);
        // 配置するセルがブロックされていないか、すでに潜水艦が配置されていないかをチェック
        if (cell.isBlocked() || cell.existSubmarine(team.getTeamId())) {
            return null;
        }

        int dx = 0;
        for (int dy = -2; dy <= 2; dy++) {
            if (dy == 0) {
                continue;
            }

            int neighborY = y + dy;
            int neighborX = x + dx;

            // 目的セルの2マス以内に潜水艦がいるかを確認
            MapCell neighborCell;
            try {
                neighborCell = map.getCell(neighborY, neighborX);
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
            if (neighborCell.isBlocked()) {
                if (dy < 0) {
                    dy = 0;
                    continue;
                } else {
                    return null;
                }
            }
            if (neighborCell.existSubmarine(team.getTeamId())) {
                return neighborCell.getSubmarine(team.getTeamId());
            }
            return null;
        }

        int dy = 0;
        for (dx = -2; dx <= 2; dx++) {
            if (dx == 0) {
                continue;
            }

            int neighborY = y + dy;
            int neighborX = x + dx;

            // 目的セルの2マス以内に潜水艦がいるかを確認
            MapCell neighborCell;
            try {
                neighborCell = map.getCell(neighborY, neighborX);
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
            if (neighborCell.isBlocked()) {
                if (dx < 0) {
                    dx = 0;
                    continue;
                } else {
                    return null;
                }
            }
            if (neighborCell.existSubmarine(team.getTeamId())) {
                return neighborCell.getSubmarine(team.getTeamId());
            }
            return null;
        }

        return null;
    }

    public ArrayList<Submarine> initializeSubmarines(Map map) {
        ArrayList<Submarine> submarines_ = new ArrayList<>();
        Random random = new Random();
        HashSet<String> cells = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            boolean isPlaced = false;
            while (!isPlaced) {
                // ランダムで1から5の間の行と列を選ぶ
                int y = random.nextInt(5) + 1; // 1〜5の間
                int x = random.nextInt(5) + 1; // 1〜5の間
                // 配置するセルを取得
                // 隣接セルも含めて問題がなければ配置
                if (!cells.contains(y + "," + x)) {
                    cells.add(y + "," + x);
                    // 潜水艦を配置
                    MapCell cell = map.getCell(y, x); // セルを取得
                    char submarineCode = (char) ('a' + i); // 潜水艦のコード（a, b, c, d）
                    try {
                        submarines_.add(new Submarine(cell, submarineCode, team.getTeamId()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("潜水艦の配置に失敗しました。");
                        System.out.println(cells);
                        continue;
                    }
                    System.out.println(
                            "潜水艦 " + submarineCode + " が位置 (" + y + ", " + x + ") に配置されました。");
                    isPlaced = true; // 配置完了
                }
            }
        }
        return submarines_;
    }

    public Log move(Game game) {
        Map map = game.getMap();
        Random random = new Random();
        MapCell toCell;
        while (true) {
            toCell = map.getCell(random.nextInt(5) + 1, random.nextInt(5) + 1);
            Submarine canMoveSubmarine = canPlace(map, toCell.getY(), toCell.getX());
            if (canMoveSubmarine != null) {
                canMoveSubmarine.move(toCell);
                break;
            }
        }
        return new Log(game.getTurn(), team.getTeamId(), "m", toCell, "");
    }

    public Log performTurn(Game game) {
        Random random = new Random();
        Log log = move(game);
        return log;
    }
}
