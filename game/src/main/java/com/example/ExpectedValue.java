// package com.example;
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

        double[][] stage = {{0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0}};

        if (Log.doTeamId == 0) {                // 相手のターン
            if (Log.performType == m) {         // 移動の場合
                if (Log.direction == n) {       // 北に移動の場合
                    if (Log.distance == 1) {    // 1マス移動の場合
                        for (int i = 1; i < 5; i++) {
                            for (int j = 1; j < 6; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    } else if (Log.distance == 2) {  // ２マス移動の場合
                        for (int i = 1; i < 4; i++) {
                            for (int j = 1; j < 6; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    }
                } else if (Log.direction == s) {     //  南に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 2; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    }
                } else if (Log.direction == e) {     //  東に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 2; j < 6; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 3; j < 6; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    }
                } else if (Log.direction == w) {     //  西に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 5; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 4; j++) {
                                stage[i][j] *= idou;
                            }
                        }
                    }
                }
            } else if (Log.performType == a) { // (被)攻撃の場合
                y = getY();
                x = getX();
                stage[x][y] *= 0.5;
                stage[x+1][y+1] *= 10;
                stage[x+1][y] *= 10;
                stage[x+1][y-1] *= 10;
                stage[x][y+1] *= 10;
                stage[x][y-1] *= 10;
                stage[x-1][y+1] *= 10;
                stage[x-1][y] *= 10;
                stage[x-1][y-1] *= 10;
            }
        } else if (Log.doTeamId == 1) {      // 自分のターン
            if (Log.performType == a) {      // 攻撃の場合
                y = getY();
                x = getX();
                if (respondAttack == "命中！") {
                    if (沈没させた) {
                        stage[x][y] *= 0;
                        stage[x+1][y+1] *= 0.5;
                        stage[x+1][y] *= 0.5;
                        stage[x+1][y-1] *= 0.5;
                        stage[x][y+1] *= 0.5;
                        stage[x][y-1] *= 0.5;
                        stage[x-1][y+1] *= 0.5;
                        stage[x-1][y] *= 0.5;
                        stage[x-1][y-1] *= 0.5;
                    } else {
                        stage[x][y] *= 50;
                    }
                } else if (respondAttack == "波高し!") {
                    stage[x][y] *= 0.5;
                    stage[x+1][y+1] *= 10;
                    stage[x+1][y] *= 10;
                    stage[x+1][y-1] *= 10;
                    stage[x][y+1] *= 10;
                    stage[x][y-1] *= 10;
                    stage[x-1][y+1] *= 10;
                    stage[x-1][y] *= 10;
                    stage[x-1][y-1] *= 10;
                } else if (respondAttack == "はずれ") {
                    stage[x][y] *= 0.5;
                    stage[x+1][y+1] *= 0.5;
                    stage[x+1][y] *= 0.5;
                    stage[x+1][y-1] *= 0.5;
                    stage[x][y+1] *= 0.5;
                    stage[x][y-1] *= 0.5;
                    stage[x-1][y+1] *= 0.5;
                    stage[x-1][y] *= 0.5;
                    stage[x-1][y-1] *= 0.5;
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
        double n = move(2);
        strategyyy(n);
    } else if (相手残り１艦) {
        if (Log.doTeamId == 0) {                // 相手のターン
            if (Log.performType == m) {         // 移動の場合
                if (Log.direction == n) {       // 北に移動の場合
                    if (Log.distance == 1) {    // 1マス移動の場合
                        for (int i = 1; i < 6; i++) {
                            stage[5][i] = 1;
                        }
                    } else if (Log.distance == 2) {  // ２マス移動の場合
                        for (int i = 4; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                stage[i][j] = 1;
                            }
                        }
                    }
                } else if (Log.direction == s) {     //  南に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            stage[1][j] = 1;
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 3; i++) {
                            for (int j = 1; j < 6; j++) {
                                stage[i][j] = 1;
                            }
                        }
                    }
                } else if (Log.direction == e) {     //  東に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            stage[i][1] = 1;
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 3; j++) {
                                stage[i][j] = 1;
                            }
                        }
                    }
                } else if (Log.direction == w) {     //  西に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            stage[i][5] = 1;
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 4; j < 6; j++) {
                                stage[i][j] = 1;
                            }
                        }
                    }
                }
            } else if (Log.performType == a) { // (被)攻撃の場合
                y = getY();
                x = getX();
                stage[x][y] *= 0.5;
                stage[x+1][y+1] *= 10;
                stage[x+1][y] *= 10;
                stage[x+1][y-1] *= 10;
                stage[x][y+1] *= 10;
                stage[x][y-1] *= 10;
                stage[x-1][y+1] *= 10;
                stage[x-1][y] *= 10;
                stage[x-1][y-1] *= 10;
            }
        } else if (Log.doTeamId == 1) {      // 自分のターン
            if (Log.performType == a) {      // 攻撃の場合
                y = getY();
                x = getX();
                if (respondAttack == "命中") {
                    break;
                } else if (respondAttack == "波高し") {
                    double masu1 = masuma[x][y];
                    double masu2 = stage[x+1][y+1];
                    double masu3 = stage[x+1][y];
                    double masu4 = stage[x+1][y-1];
                    double masu5 = stage[x][y+1];
                    double masu6 = stage[x][y-1];
                    double masu7 = stage[x-1][y+1];
                    double masu8 = stage[x-1][y];
                    double masu9 = stage[x-1][y-1];
                    for (int i = 1; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            stage[i][j] = 1;
                        }
                    }
                    stage[x][y] = masu1;
                    stage[x+1][y+1] = masu2;
                    stage[x+1][y] = masu3;
                    stage[x+1][y-1] = masu4;
                    stage[x][y+1] = masu5;
                    stage[x][y-1] = masu6;
                    stage[x-1][y+1] = masu7;
                    stage[x-1][y] = masu8;
                    stage[x-1][y-1] = masu9;
                } else if (respondAttack == "はずれ") {
                    stage[x][y] *= 0.5;
                    stage[x+1][y+1] *= 0.5;
                    stage[x+1][y] *= 0.5;
                    stage[x+1][y-1] *= 0.5;
                    stage[x][y+1] *= 0.5;
                    stage[x][y-1] *= 0.5;
                    stage[x-1][y+1] *= 0.5;
                    stage[x-1][y] *= 0.5;
                    stage[x-1][y-1] *= 0.5;
                }
            }
        }
    }
}