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

    private Submarine canMove(Map map, MapCell toCell) {
        if (toCell.isBlocked() || toCell.existSubmarine(team.getTeamId())) {
            return null;
        }

        int y = toCell.getY();
        int x = toCell.getX();

        for (int dy = -2; dy <= 2; dy++) {
            for (int dx = -2; dx <= 2; dx++) {
                if (dy == 0 && dx == 0) {
                    continue;
                }
                if (!(dy == 0 || dx == 0)) {
                    continue;
                }

                int neighborY = y + dy;
                int neighborX = x + dx;

                MapCell neighborCell;
                try {
                    neighborCell = map.getCell(neighborY, neighborX);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }

                if (neighborCell.existSubmarine(team.getTeamId())) {
                    return neighborCell.getSubmarine(team.getTeamId());
                }
            }
        }
        return null;
    }

    private boolean canAttack(Map map, MapCell toCell) {
        if (toCell.isBlocked()) {
            return false;
        }
        if (toCell.existSubmarine(team.getTeamId())) {
            return false;
        }

        boolean canAttack = false;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                MapCell cell = map.getCell(toCell.getY() + i, toCell.getX() + j);
                if (cell.existSubmarine(team.getTeamId())) {
                    canAttack = true;
                }
            }
        }
        return canAttack;
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

    public MoveLog randomWalk(Game game) {
        Map map = game.getMap();
        Random random = new Random();
        while (true) {
            MapCell toCell = map.getCell(random.nextInt(5) + 1, random.nextInt(5) + 1);
            Submarine canMoveSubmarine = canMove(map, toCell);
            if (canMoveSubmarine != null) {
                return move(game, toCell);
            }
        }
    }

    public MoveLog move(Game game, MapCell toCell) {
        Map map = game.getMap();
        java.util.Map<String, Object> result;

        Submarine moveSubmarine = canMove(map, toCell);
        if (moveSubmarine != null) {
            result = moveSubmarine.move(toCell);
            return new MoveLog(game.getTurn(), team.getTeamId(), (String) result.get("direction"),
                    (int) result.get("distance"));
        } else {
            return null;
        }
    }

    public AttackLog attack(Game game, MapCell toCell) {
        Map map = game.getMap();
        if (canAttack(map, toCell)) {
            return new AttackLog(game.getTurn(), team.getTeamId(), toCell);
        }
        return null;
    }

    public Log performTurn(Game game) {
        History history = game.getHistory();
        int currentTurn = game.getTurn();

        // -2ターンの時に自軍が攻撃
        if (history.getLog(currentTurn - 2) instanceof AttackLog) {
            AttackLog prevOurLog = (AttackLog) history.getLog(currentTurn - 2);

            Log prevEnemyLog = history.getLog(currentTurn - 1);
            if (prevEnemyLog instanceof AttackLog) {
                // return underAttack(game);
            }

            switch (prevOurLog.reaction) {
                case "ハズレ！":
                    Log ret = attack(game, prevOurLog.targetCell);
                    if (ret != null) {
                        return ret;
                    }
                    throw new RuntimeException("攻撃できるセルがありません");
                case "波高し！":
                    // 攻撃した潜水艦の情報をLogに追加．　実装
                    return randomWalk(game);
                case "命中！":
                    return attack(game, prevOurLog.targetCell);
                default:
                    break;
            }
            
        }


        // とりあえずランダムウォーク
        return randomWalk(game);
    }
}
