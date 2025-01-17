
// package com.example;
import java.util.ArrayList;
import java.util.Scanner;



// i行j列の想定

public class ExpectedValue {
    private static final int ATEAMID = 0;
    private static final int BTEAMID = 1;

    static double move(double n) {
        double idou = n;
        return idou;
    }

    // 相手の期待値
    static void strategyA (double move, MapCell toCell) {
        double idou;

        // 7x7のArrayListを定義
        ArrayList<ArrayList<Integer>> stageA = new ArrayList<>();
        // グリッドを初期化
        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                // 周囲は0、内側は1で初期化
                if (i == 0 || i == 6 || j == 0 || j == 6) {
                    row.add(0.0); // 周囲を0で初期化
                } else {
                    row.add(1.0); // 内側を1で初期化
                }
            }
            stageA.add(row);
        }

        if (戦艦残り３，４) {
            idou = move(1.1);         //  TODO:移動、攻撃などそれぞれの重し付けの再検討
            if (log.doTeamId == 0) {                // 相手のターン
                if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                    if (moveLog.direction.equals("n")) {       // 北に移動の場合
                        if (moveLog.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 5; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                                }
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 1; i < 4; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equlas("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 2; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 3; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 2; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 3; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 5; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 4; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    }
                } else if (history.getlog(currentTurn) instanceof AttackLog) {   // (被)攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                            } else {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 10.0);
                            }
                        }
                    }
                }
            } else if (log.doTeamId == 1) {      // 自分のターン
                if (history.getlog(currentTurn) instanceof AttackLog) {      // 攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    if (attackLog.reaction.equals("命中！")) {
                        if (沈没させた) {
                            for (int i = -1; i <= 1; i++) {
                                for (int j = -1; j <= 1; j++) {
                                    if (i == 0 && j == 0) {
                                        stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.0);
                                    } else {
                                        stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                                    }
                                }
                            }
                        } else {
                            stageA.get(y).set(x, stageA.get(y).get(x) * 50.0);
                        }
                    } else if (attackLog.reaction.equals("波高し!")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) {
                                    stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                                } else {
                                    stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 10.0);
                                }
                            }
                        }
                    } else if (attackLog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        } else if (あいてのこり２) {
                idou = move(2.0);
                if (log.doTeamId == 0) {                // 相手のターン
                    if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                        if (moveLog.direction.equals("n")) {       // 北に移動の場合
                            if (moveLog.distance == 1) {    // 1マス移動の場合
                                for (int i = 1; i < 5; i++) {
                                    for (int j = 1; j < 6; j++) {
                                        stageA.get(i).set(j, stageA.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                                    }
                                }
                            } else if (moveLog.distance == 2) {  // ２マス移動の場合
                                for (int i = 1; i < 4; i++) {
                                    for (int j = 1; j < 6; j++) {
                                        stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                    }
                                }
                            }
                        } else if (moveLog.direction.equals("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 2; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 3; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 2; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 3; j < 6; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 5; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 4; j++) {
                                    stageA.get(i).set(j, stageA.get(i).get(j) * idou);
                                }
                            }
                        }
                    }
                } else if (history.getlog(currentTurn) instanceof AttackLog) { // (被)攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                            } else {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 10.0);
                            }
                        }
                    }
                }
            } else if (log.doTeamId == 1) {      // 自分のターン
                if (history.getlog(currentTurn) instanceof AttackLog) {      // 攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    if (attackLog.reaction.equals("命中！")) {
                        if (沈没させた) {
                            for (int i = -1; i <= 1; i++) {
                                for (int j = -1; j <= 1; j++) {
                                    if (i == 0 && j == 0) {
                                        stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.0);
                                    } else {
                                        stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                                    }
                                }
                            }
                        } else {
                            stageA.get(y).set(x, stageA.get(y).get(x) * 50.0);
                        }
                    } else if (attackLog.reaction.equals("波高し!")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) {
                                    stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                                } else {
                                    stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 10.0);
                                }
                            }
                        }
                    } else if (attackLlog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        } else if (あいてのこり１) {
            if (log.doTeamId == 0) {                // 相手のターン
                if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                    if (moveLog.direction.equals("n")) {       // 北に移動の場合
                        if (moveLog.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 6; i++) {
                                stageA.get(5).set(i, 1.0);
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 4; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stageA.get(1).set(i, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 3; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageA.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stageA.get(i).set(1, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 3; j++) {
                                    stageA.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.directi.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stageA.get(i).set(5, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 4; j < 6; j++) {
                                    stageA.get(i).set(j, 1.0);
                                }
                            }
                        }
                    }
                } else if (history.getlog(currentTurn) instanceof AttackLog) { // (被)攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                            } else {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 10.0);
                            }
                        }
                    }
                }
            } else if (log.doTeamId == 1) {      // 自分のターン
                if (history.getlog(currentTurn) instanceof AttackLog) {      // 攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    if (attackLog.reaction.equals("命中！")) {
                        break;
                    } else if (attackLog.reaction.equals("波高し！")) {  // TODO:その9マスは本当に１より小さいの？（重み付けの検討）
                        double masu[][] = {{0, 0, 0}, {0, 0, 0}};
                        for (int i = -1; i <= 1; i++) {   // 攻撃箇所とその周りの期待値を別配列に格納
                            for (int j = -1; j <= 1; j++) {
                                masu[i+1][j+1] = stageA.get(y+i).get(x+j);
                            }
                        }
                        for (int i = 1; i < 6; i++) {   // 5*5を全部1.0に初期化
                            for (int j = 0; j < 6; j++) {
                                stageA.get(i).set(j, 1.0);
                            }
                        }
                        for (int i = -1; i <= 1; i++) {   // 別配列に格納していた期待値を元に戻す
                            for (int j = -1; j <= 1; j++) {
                                stageA.get(y+i).set(x+j, masu[i+1][j+1]);
                            }
                        }
                    } else if (attackLog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stageA.get(y+i).set(x+j, stageA.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        }
    }

    // 自分たちの期待値
    static void strategyB (double move, MapCell toCell) {
        double idou;

        // 7x7のArrayListを定義
        ArrayList<ArrayList<Integer>> stageB = new ArrayList<>();
        // グリッドを初期化
        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                // 周囲は0、内側は1で初期化
                if (i == 0 || i == 6 || j == 0 || j == 6) {
                    row.add(0.0); // 周囲を0で初期化
                } else {
                    row.add(1.0); // 内側を1で初期化
                }
            }
            stageB.add(row);
        }

        if (戦艦残り３，４) {
            idou = move(1.1);         //  TODO:移動、攻撃などそれぞれの重し付けの再検討
            if (log.doTeamId == 1) {                // 自分のターン
                if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                    if (moveLog.direction.equals("n")) {       // 北に移動の場合
                        if (moveLog.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 5; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                                }
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 1; i < 4; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equlas("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 2; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 3; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 2; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 3; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 5; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 4; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    }
                } else if (history.getlog(currentTurn) instanceof AttackLog) {   // (被)攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                            } else {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 10.0);
                            }
                        }
                    }
                }
            } else if (log.doTeamId == 0) {      // 相手のターン
                if (history.getlog(currentTurn) instanceof AttackLog) {      // 攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    if (attackLog.reaction.equals("命中！")) {
                        if (沈没させた) {
                            for (int i = -1; i <= 1; i++) {
                                for (int j = -1; j <= 1; j++) {
                                    if (i == 0 && j == 0) {
                                        stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.0);
                                    } else {
                                        stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                                    }
                                }
                            }
                        } else {
                            stageB.get(y).set(x, stageB.get(y).get(x) * 50.0);
                        }
                    } else if (attackLog.reaction.equals("波高し!")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) {
                                    stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                                } else {
                                    stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 10.0);
                                }
                            }
                        }
                    } else if (attackLog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        } else if (あいてのこり２) {
            idou = move(2.0);
            if (log.doTeamId == 1) {                // 自分のターン
                if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                    if (moveLog.direction.equals("n")) {       // 北に移動の場合
                        if (moveLog.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 5; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                                }
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 1; i < 4; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 2; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 3; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 2; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 3; j < 6; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 5; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 4; j++) {
                                    stageB.get(i).set(j, stageB.get(i).get(j) * idou);
                                }
                            }
                        }
                    }
                } else if (history.getlog(currentTurn) instanceof AttackLog) { // (被)攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                            } else {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 10.0);
                            }
                        }
                    }
                }
            } else if (log.doTeamId == 0) {      // 相手のターン
                if (history.getlog(currentTurn) instanceof AttackLog) {      // 攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    if (attackLog.reaction.equals("命中！")) {
                        if (沈没させた) {
                            for (int i = -1; i <= 1; i++) {
                                for (int j = -1; j <= 1; j++) {
                                    if (i == 0 && j == 0) {
                                        stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.0);
                                    } else {
                                        stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                                    }
                                }
                            }
                        } else {
                            stageB.get(y).set(x, stageB.get(y).get(x) * 50.0);
                        }
                    } else if (attackLog.reaction.equals("波高し!")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) {
                                    stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                                } else {
                                    stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 10.0);
                                }
                            }
                        }
                    } else if (attackLlog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        } else if (あいてのこり１) {
            if (log.doTeamId == 1) {                // 自分のターン
                if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                    if (moveLog.direction.equals("n")) {       // 北に移動の場合
                        if (moveLog.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 6; i++) {
                                stageB.get(5).set(i, 1.0);
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 4; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stageB.get(1).set(i, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 3; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stageB.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stageB.get(i).set(1, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 3; j++) {
                                    stageB.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.directi.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stageB.get(i).set(5, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 4; j < 6; j++) {
                                    stageB.get(i).set(j, 1.0);
                                }
                            }
                        }
                    }
                } else if (history.getlog(currentTurn) instanceof AttackLog) { // (被)攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                            } else {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 10.0);
                            }
                        }
                    }
                }
            } else if (log.doTeamId == 0) {      // 相手のターン
                if (history.getlog(currentTurn) instanceof AttackLog) {      // 攻撃の場合
                    y = toCell.getY();
                    x = toCell.getX();
                    if (attackLog.reaction.equals("命中！")) {
                        break;
                    } else if (attackLog.reaction.equals("波高し！")) {  // TODO:その9マスは本当に１より小さいの？（重み付けの検討）
                        double masu[][] = {{0, 0, 0}, {0, 0, 0}};
                        for (int i = -1; i <= 1; i++) {   // 攻撃箇所とその周りの期待値を別配列に格納
                            for (int j = -1; j <= 1; j++) {
                                masu[i+1][j+1] = stageB.get(y+i).get(x+j);
                            }
                        }
                        for (int i = 1; i < 6; i++) {   // 5*5を全部1.0に初期化
                            for (int j = 0; j < 6; j++) {
                                stageB.get(i).set(j, 1.0);
                            }
                        }
                        for (int i = -1; i <= 1; i++) {   // 別配列に格納していた期待値を元に戻す
                            for (int j = -1; j <= 1; j++) {
                                stageB.get(y+i).set(x+j, masu[i+1][j+1]);
                            }
                        }
                    } else if (attackLog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stageB.get(y+i).set(x+j, stageB.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        }
    }

    // //  期待値の出力
    // static void valuewrite() {
    //     System.out.println("");
    //     for (int i = 0; i < SIZE; i++) {
    //         if (i == 0 || i == SIZE - 1) {
    //             System.out.print(i + " ");
    //         } else {
    //             System.out.print((char) ('A' + i - 1) + " ");
    //         }
    //         for (int j = 0; j < SIZE; j++) {
    //             stageA[i][j];
    //             if (cell.existSubmarine(TEAM_A)) {
    //                 System.out.print(cell.getSubmarine(TEAM_A).getCode() + " ");
    //             } else if (cell.isBlocked()) {
    //                 System.out.print("X ");
    //             } else {
    //                 System.out.print("  ");
    //             }
    //         }
    //     }
    // }
}
