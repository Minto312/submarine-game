
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

    static void strategyyy (double move, MapCell toCell) {
        double idou;

        // 7x7のArrayListを定義
        ArrayList<ArrayList<Integer>> stage = new ArrayList<>();
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
            stage.add(row);
        }

        if (戦艦残り３，４) {
            idou = move(1.1);         //  TODO:移動、攻撃などそれぞれの重し付けの再検討
            if (log.doTeamId == 0) {                // 相手のターン
                if (history.getlog(currentTurn) instanceof MoveLog) {         // 移動の場合
                    if (moveLog.direction.equals("n")) {       // 北に移動の場合
                        if (moveLog.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 5; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                                }
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 1; i < 4; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equlas("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 2; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 3; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 2; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 3; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 5; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 4; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
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
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                            } else {
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 10.0);
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
                                        stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.0);
                                    } else {
                                        stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                                    }
                                }
                            }
                        } else {
                            stage.get(y).set(x, stage.get(y).get(x) * 50.0);
                        }
                    } else if (attackLog.reaction.equals("波高し!")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) {
                                    stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                                } else {
                                    stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 10.0);
                                }
                            }
                        }
                    } else if (attackLog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
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
                                        stage.get(i).set(j, stage.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                                    }
                                }
                            } else if (moveLog.distance == 2) {  // ２マス移動の場合
                                for (int i = 1; i < 4; i++) {
                                    for (int j = 1; j < 6; j++) {
                                        stage.get(i).set(j, stage.get(i).get(j) * idou);
                                    }
                                }
                            }
                        } else if (moveLog.direction.equals("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 2; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 3; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 2; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 3; j < 6; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 5; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
                                }
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 4; j++) {
                                    stage.get(i).set(j, stage.get(i).get(j) * idou);
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
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                            } else {
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 10.0);
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
                                        stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.0);
                                    } else {
                                        stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                                    }
                                }
                            }
                        } else {
                            stage.get(y).set(x, stage.get(y).get(x) * 50.0);
                        }
                    } else if (attackLog.reaction.equals("波高し!")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) {
                                    stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                                } else {
                                    stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 10.0);
                                }
                            }
                        }
                    } else if (attackLlog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
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
                                stage.get(5).set(i, 1.0);
                            }
                        } else if (moveLog.distance == 2) {  // ２マス移動の場合
                            for (int i = 4; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("s")) {     //  南に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stage.get(1).set(i, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 3; i++) {
                                for (int j = 1; j < 6; j++) {
                                    stage.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.direction.equals("e")) {     //  東に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stage.get(i).set(1, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 3; j++) {
                                    stage.get(i).set(j, 1.0);
                                }
                            }
                        }
                    } else if (moveLog.directi.equals("w")) {     //  西に移動の場合
                        if (moveLog.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                stage.get(i).set(5, 1.0);
                            }
                        } else if (moveLog.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 4; j < 6; j++) {
                                    stage.get(i).set(j, 1.0);
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
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                            } else {
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 10.0);
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
                    } else if (attackLog.reaction.equals("波高し！")) {  // TODO:その9マスは本当に１より小さいの？（重み付けの検討）                            double masu1 = stage.get(y).get(x);
                        double masu2 = stage.get(y+1).get(x+1);
                        double masu3 = stage.get(y+1).get(x);
                        double masu4 = stage.get(y+1).get(x-1);
                        double masu5 = stage.get(y).get(x+1);
                        double masu6 = stage.get(y).get(x-1);
                        double masu7 = stage.get(y-1).get(x+1);
                        double masu8 = stage.get(y-1).get(x);
                        double masu9 = stage.get(y-1).get(x-1);
                        for (int i = 1; i < 6; i++) {
                            for (int j = 0; j < 6; j++) {
                                stage.get(i).set(j, 1.0);
                            }
                        }
                        stage.get(y).set(x, masu1);
                        stage.get(y+1).set(x+1, masu2);
                        stage.get(y+1).set(x, masu3);
                        stage.get(y+1).set(x-1, masu4);
                        stage.get(y).set(x+1, masu5);
                        stage.get(y).set(x-1, masu6);
                        stage.get(y-1).set(x+1, masu7);
                        stage.get(y-1).set(x, masu8);
                        stage.get(y-1).set(x-1, masu9);
                    } else if (attackLog.reaction.equals("ハズレ！")) {
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                stage.get(y+i).set(x+j, stage.get(y+i).get(x+j) * 0.5);
                            }
                        }
                    }
                }
            }
        }
    }
}
