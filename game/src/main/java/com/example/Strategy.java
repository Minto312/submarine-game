// package com.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Strategy {

    private Submarine[] submarines = new Submarine[4];
    private static final int TEAM_ID = 0;

    // 移動可能な最初の潜水艦を変えす
    public static Submarine canPlace(Map map, int y, int x) {
        MapCell cell = map.getCell(y, x);
        // 配置するセルがブロックされていないか、すでに潜水艦が配置されていないかをチェック
        if (cell.isBlocked() || cell.existSubmarine(TEAM_ID)) {
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
            if (neighborCell.existSubmarine(TEAM_ID)) {
                return neighborCell.getSubmarine(TEAM_ID);
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
            if (neighborCell.existSubmarine(TEAM_ID)) {
                return neighborCell.getSubmarine(TEAM_ID);
            }
            return null;
        }

        return null;
    }

    Submarine[] initializeSubmarines(Map map) {
        Submarine[] submarines_ = new Submarine[4];
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
                    submarines_[i] = new Submarine(cell, submarineCode, TEAM_ID); // 0番チームの潜水艦 cell.setSubmarine(submarine, 0);  // セルに潜水艦を配置
                    System.out.println(
                            "潜水艦 " + submarineCode + " が位置 (" + y + ", " + x + ") に配置されました。");
                    isPlaced = true; // 配置完了
                }
            }
        }
        return submarines_;
    }

    public static void move(Map map) {
        Random random = new Random();
        while (true) {
            MapCell toCell = map.getCell(random.nextInt(5) + 1, random.nextInt(5) + 1);
            Submarine canMoveSubmarine = canPlace(map, toCell.getY(), toCell.getX());
            if (canMoveSubmarine != null) {
                canMoveSubmarine.move(toCell);
                break;
            }
        }
    }

    public static void performTurn(Map map) {
        Random random = new Random();
        if (random.nextInt(10) > -1) {
            move(map);
        } else {
            move(map);
            // attack(map);
        }
    }

    public static void respondAttack(Map map, String cellCode) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

        MapCell cell = map.getCell(y, x);
        if (cell.existSubmarine(TEAM_ID)) {
            System.out.println("命中！");
            System.out.println("[debug] 潜水艦 " + cell.getSubmarine(TEAM_ID).getCode() + " が攻撃されました");
            Submarine attackedSubmarine = cell.getSubmarine(TEAM_ID);
            attackedSubmarine.takeDamage();
            return;
        }

        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dy == 0 && dx == 0) {
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

                if (neighborCell.existSubmarine(TEAM_ID)) {
                    System.out.println("波高し！");
                    System.out.println("潜水艦 " + neighborCell.getSubmarine(TEAM_ID).getCode() + " 近くにあります");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 初期配置を決定
        Map map = new Map();

        Strategy strategy = new Strategy();
        strategy.submarines = strategy.initializeSubmarines(map);

        while (true) {
            map.showMap(TEAM_ID, strategy.submarines);
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");

            if (inputArray[0].equals("a")) {
                String cellCode = inputArray[1];
                respondAttack(map, cellCode);
            } else {
                performTurn(map);
            }
            // 相手の行動
            // if(/*相手が攻撃してきたら*/){break;}
        }
    }
}
