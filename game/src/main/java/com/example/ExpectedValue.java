// package com.example;
import java.util.ArrayList;
import java.util.Scanner;

// i行j列の想定

public class ExpectedValue {
    static double move(double n) {
        double idou = n;
        return idou;
    }
    // double attackmasu = 0.5;
    // double attackaround = 10;
    // double meichu = 50;
    // double namitakashi = 0.5;
    // double namitakashiaround = 10;
    // double hazure = 0.5;

    static void strategyyy (double move) {
        double idou = move;

        // double[][] stage = {{0, 0, 0, 0, 0, 0, 0},
        //                     {0, 1, 1, 1, 1, 1, 0},
        //                     {0, 1, 1, 1, 1, 1, 0},
        //                     {0, 1, 1, 1, 1, 1, 0},
        //                     {0, 1, 1, 1, 1, 1, 0},
        //                     {0, 1, 1, 1, 1, 1, 0},
        //                     {0, 0, 0, 0, 0, 0, 0}};

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

        // // 初期化結果を出力
        // for (ArrayList<Integer> row : stage) {
        //     System.out.println(row);
        // }

        if (Log.doTeamId == 0) {                // 相手のターン
            if (Log.performType == m) {         // 移動の場合
                if (Log.direction == n) {       // 北に移動の場合
                    if (Log.distance == 1) {    // 1マス移動の場合
                        for (int i = 1; i < 5; i++) {
                            for (int j = 1; j < 6; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);   // (i, j) の値に idou を掛ける
                            }
                        }
                    } else if (Log.distance == 2) {  // ２マス移動の場合
                        for (int i = 1; i < 4; i++) {
                            for (int j = 1; j < 6; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    }
                } else if (Log.direction == s) {     //  南に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 2; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    }
                } else if (Log.direction == e) {     //  東に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 2; j < 6; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 3; j < 6; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    }
                } else if (Log.direction == w) {     //  西に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 5; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 4; j++) {
                                // stage[i][j] *= idou;
                                stage.get(i).set(j, stage.get(i).get(j) * idou);
                            }
                        }
                    }
                }
            } else if (Log.performType == a) { // (被)攻撃の場合
                y = getY();
                x = getX();
                stage.get(y).set(x, stage.get(y).get(x) * 0.5);
                stage.get(y+1).set(x+1, stage.get(y+1).get(x+1) * 10.0);
                stage.get(y+1).set(x, stage.get(y+1).get(x) * 10.0);
                stage.get(y+1).set(x-1, stage.get(y+1).get(x-1) * 10.0);
                stage.get(y).set(x+1, stage.get(y).get(x+1) * 10.0);
                stage.get(y).set(x-1, stage.get(y).get(x-1) * 10.0);
                stage.get(y-1).set(x+1, stage.get(y-1).get(x+1) * 10.0);
                stage.get(y-1).set(x, stage.get(y-1).get(x) * 10.0);
                stage.get(y-1).set(x-1, stage.get(y-1).get(x-1) * 10.0);
                // stage[y][x] *= 0.5;
                // stage[y+1][x+1] *= 10;
                // stage[y+1][x] *= 10;
                // stage[y+1][x-1] *= 10;
                // stage[y][x+1] *= 10;
                // stage[y][x-1] *= 10;
                // stage[y-1][x+1] *= 10;
                // stage[y-1][x] *= 10;
                // stage[y-1][x-1] *= 10;
            }
        } else if (Log.doTeamId == 1) {      // 自分のターン
            if (Log.performType == a) {      // 攻撃の場合
                y = getY();
                x = getX();
                if (respondAttack == "命中！") {
                    if (沈没させた) {
                        stage.get(y).set(x, stage.get(y).get(x) * 0.0);
                        stage.get(y+1).set(x+1, stage.get(y+1).get(x+1) * 0.5);
                        stage.get(y+1).set(x, stage.get(y+1).get(x) * 0.5);
                        stage.get(y+1).set(x-1, stage.get(y+1).get(x-1) * 0.5);
                        stage.get(y).set(x+1, stage.get(y).get(x+1) * 0.5);
                        stage.get(y).set(x-1, stage.get(y).get(x-1) * 0.5);
                        stage.get(y-1).set(x+1, stage.get(y-1).get(x+1) * 0.5);
                        stage.get(y-1).set(x, stage.get(y-1).get(x) * 0.5);
                        stage.get(y-1).set(x-1, stage.get(y-1).get(x-1) * 0.5);
                        // stage[y][y] *= 0;
                        // stage[y+1][x+1] *= 0.5;
                        // stage[y+1][x] *= 0.5;
                        // stage[y+1][x-1] *= 0.5;
                        // stage[y][x+1] *= 0.5;
                        // stage[y][x-1] *= 0.5;
                        // stage[y-1][x+1] *= 0.5;
                        // stage[y-1][x] *= 0.5;
                        // stage[y-1][x-1] *= 0.5;
                    } else {
                        stage.get(y).set(x, stage.get(y).get(x) * 50.0);
                        // stage[y][x] *= 50;
                    }
                } else if (respondAttack == "波高し!") {
                    stage.get(y).set(x, stage.get(y).get(x) * 0.5);
                    stage.get(y+1).set(x+1, stage.get(y+1).get(x+1) * 10.0);
                    stage.get(y+1).set(x, stage.get(y+1).get(x) * 10.0);
                    stage.get(y+1).set(x-1, stage.get(y+1).get(x-1) * 10.0);
                    stage.get(y).set(x+1, stage.get(y).get(x+1) * 10.0);
                    stage.get(y).set(x-1, stage.get(y).get(x-1) * 10.0);
                    stage.get(y-1).set(x+1, stage.get(y-1).get(x+1) * 10.0);
                    stage.get(y-1).set(x, stage.get(y-1).get(x) * 10.0);
                    stage.get(y-1).set(x-1, stage.get(y-1).get(x-1) * 10.0);
                    // stage[y][y] *= 0.5;
                    // stage[y+1][x+1] *= 10;
                    // stage[y+1][x] *= 10;
                    // stage[y+1][x-1] *= 10;
                    // stage[y][x+1] *= 10;
                    // stage[y][x-1] *= 10;
                    // stage[y-1][x+1] *= 10;
                    // stage[y-1][x] *= 10;
                    // stage[y-1][x-1] *= 10;
                } else if (respondAttack == "はずれ") {
                    stage.get(y).set(x, stage.get(y).get(x) * 0.5);
                    stage.get(y+1).set(x+1, stage.get(y+1).get(x+1) * 0.5);
                    stage.get(y+1).set(x, stage.get(y+1).get(x) * 0.5);
                    stage.get(y+1).set(x-1, stage.get(y+1).get(x-1) * 0.5);
                    stage.get(y).set(x+1, stage.get(y).get(x+1) * 0.5);
                    stage.get(y).set(x-1, stage.get(y).get(x-1) * 0.5);
                    stage.get(y-1).set(x+1, stage.get(y-1).get(x+1) * 0.5);
                    stage.get(y-1).set(x, stage.get(y-1).get(x) * 0.5);
                    stage.get(y-1).set(x-1, stage.get(y-1).get(x-1) * 0.5);
                    // stage[y][y] *= 0.5;
                    // stage[y+1][x+1] *= 0.5;
                    // stage[y+1][x] *= 0.5;
                    // stage[y+1][x-1] *= 0.5;
                    // stage[y][x+1] *= 0.5;
                    // stage[y][x-1] *= 0.5;
                    // stage[y-1][x+1] *= 0.5;
                    // stage[y-1][x] *= 0.5;
                    // stage[y-1][x-1] *= 0.5;
                }
            }
        }
    }
}

public static void main(String[] args) {
    if (相手残り４艦or３艦) {
        double n = move(1.1);
        strategyyy(n);
    } else if (相手残り２艦艦) {
        double n = move(2.0);
        strategyyy(n);
    } else if (相手残り１艦) {
        if (Log.doTeamId == 0) {                // 相手のターン
            if (Log.performType == m) {         // 移動の場合
                if (Log.direction == n) {       // 北に移動の場合
                    if (Log.distance == 1) {    // 1マス移動の場合
                        for (int i = 1; i < 6; i++) {
                            // stage[5][i] = 1;
                            stage.get(5).set(i, 1.0);
                        }
                    } else if (Log.distance == 2) {  // ２マス移動の場合
                        for (int i = 4; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                // stage[i][j] = 1;
                                stage.get(i).set(j, 1.0);
                            }
                        }
                    }
                } else if (Log.direction == s) {     //  南に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            // stage[1][i] = 1;
                            stage.get(1).set(i, 1.0);
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 3; i++) {
                            for (int j = 1; j < 6; j++) {
                                // stage[i][j] = 1;
                                stage.get(i).set(j, 1.0);
                            }
                        }
                    }
                } else if (Log.direction == e) {     //  東に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            // stage[i][1] = 1;
                            stage.get(i).set(1, 1.0);
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 3; j++) {
                                // stage[i][j] = 1;
                                stage.get(i).set(j, 1.0);
                            }
                        }
                    }
                } else if (Log.direction == w) {     //  西に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            // stage[i][5] = 1;
                            stage.get(i).set(5, 1.0);
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 4; j < 6; j++) {
                                // stage[i][j] = 1;
                                stage.get(i).set(j, 1.0);
                            }
                        }
                    }
                }
            } else if (Log.performType == a) { // (被)攻撃の場合
                y = getY();
                x = getX();
                // stage[y][x] *= 0.5;
                // stage[y+1][x+1] *= 10;
                // stage[y+1][x] *= 10;
                // stage[y+1][x-1] *= 10;
                // stage[y][x+1] *= 10;
                // stage[y][x-1] *= 10;
                // stage[y-1][x+1] *= 10;
                // stage[y-1][x] *= 10;
                // stage[y-1][x-1] *= 10;
                stage.get(y).set(x, stage.get(y).get(x) * 0.5);
                stage.get(y+1).set(x+1, stage.get(y+1).get(x+1) * 10.0);
                stage.get(y+1).set(x, stage.get(y+1).get(x) * 10.0);
                stage.get(y+1).set(x-1, stage.get(y+1).get(x-1) * 10.0);
                stage.get(y).set(x+1, stage.get(y).get(x+1) * 10.0);
                stage.get(y).set(x-1, stage.get(y).get(x-1) * 10.0);
                stage.get(y-1).set(x+1, stage.get(y-1).get(x+1) * 10.0);
                stage.get(y-1).set(x, stage.get(y-1).get(x) * 10.0);
                stage.get(y-1).set(x-1, stage.get(y-1).get(x-1) * 10.0);
            }
        } else if (Log.doTeamId == 1) {      // 自分のターン
            if (Log.performType == a) {      // 攻撃の場合
                y = getY();
                x = getX();
                if (respondAttack == "命中") {
                    break;
                } else if (respondAttack == "波高し") {
                    // double masu1 = stage[y][x];
                    // double masu2 = stage[y+1][x+1];
                    // double masu3 = stage[y+1][x];
                    // double masu4 = stage[y+1][x-1];
                    // double masu5 = stage[y][x+1];
                    // double masu6 = stage[y][x-1];
                    // double masu7 = stage[y-1][x+1];
                    // double masu8 = stage[y-1][x];
                    // double masu9 = stage[y-1][x-1];
                    double masu1 = stage.get(y).get(x);
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
                            // stage[i][j] = 1;
                            stage.get(i).set(j, 1.0);
                        }
                    }
                    // stage[y][x] = masu1;
                    // stage[y+1][x+1] = masu2;
                    // stage[y+1][x] = masu3;
                    // stage[y+1][x-1] = masu4;
                    // stage[y][x+1] = masu5;
                    // stage[y][x-1] = masu6;
                    // stage[y-1][x+1] = masu7;
                    // stage[y-1][x] = masu8;
                    // stage[y-1][x-1] = masu9;
                    stage.get(y).set(x, masu1);
                    stage.get(y+1).set(x+1, masu2);
                    stage.get(y+1).set(x, masu3);
                    stage.get(y+1).set(x-1, masu4);
                    stage.get(y).set(x+1, masu5);
                    stage.get(y).set(x-1, masu6);
                    stage.get(y-1).set(x+1, masu7);
                    stage.get(y-1).set(x, masu8);
                    stage.get(y-1).set(x-1, masu9);
                } else if (respondAttack == "はずれ") {
                    // stage[y][x] *= 0.5;
                    // stage[y+1][x+1] *= 0.5;
                    // stage[y+1][x] *= 0.5;
                    // stage[y+1][x-1] *= 0.5;
                    // stage[y][x+1] *= 0.5;
                    // stage[y][x-1] *= 0.5;
                    // stage[y-1][x+1] *= 0.5;
                    // stage[y-1][x] *= 0.5;
                    // stage[y-1][x-1] *= 0.5;
                    stage.get(y).set(x, stage.get(y).get(x) * 0.5);
                    stage.get(y+1).set(x+1, stage.get(y+1).get(x+1) * 0.5);
                    stage.get(y+1).set(x, stage.get(y+1).get(x) * 0.5);
                    stage.get(y+1).set(x-1, stage.get(y+1).get(x-1) * 0.5);
                    stage.get(y).set(x+1, stage.get(y).get(x+1) * 0.5);
                    stage.get(y).set(x-1, stage.get(y).get(x-1) * 0.5);
                    stage.get(y-1).set(x+1, stage.get(y-1).get(x+1) * 0.5);
                    stage.get(y-1).set(x, stage.get(y-1).get(x) * 0.5);
                    stage.get(y-1).set(x-1, stage.get(y-1).get(x-1) * 0.5);
                }
            }
        }
    }
}