// package com.example;
import java.util.Scanner;

// i行j列の想定

public class ExpectedValue {
    double idou = 1.1;
    // double attackmasu = 0.5;
    // double attackaround = 10;
    // double meichu = 50;
    // double namitakashi = 0.5;
    // double namitakashiaround = 10;
    // double hazure = 0.5;
    public void namae () {
        if (Log.doTeamId == 0) {                // 相手のターン
            if (Log.performType == m) {         // 移動の場合
                if (Log.direction == n) {       // 北に移動の場合
                    if (Log.distance == 1) {    // 1マス移動の場合
                        for (int i = 1; i < 5; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    } else if (Log.distance == 2) {  // ２マス移動の場合
                        for (int i = 1; i < 4; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    }
                } else if (Log.direction == s) {     //  南に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 2; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    }
                } else if (Log.direction == e) {     //  東に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 2; j < 6; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 3; j < 6; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    }
                } else if (Log.direction == w) {     //  西に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 5; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 4; j++) {
                                masume[i][j] * idou;
                            }
                        }
                    }
                }
            } else if (Log.performType == a) { // (被)攻撃の場合
                y = this.toCell.getY();
                x = this.toCell.getX();
                masume[x][y] *= 0.5;
                masume[x+1][y+1] *= 10;
                masume[x+1][y] *= 10;
                masume[x+1][y-1] *= 10;
                masume[x][y+1] *= 10;
                masume[x][y-1] *= 10;
                masume[x-1][y+1] *= 10;
                masume[x-1][y] *= 10;
                masume[x-1][y-1] *= 10;
            }
        } else if (Log.doTeamId == 1) {      // 自分のターン
            if (Log.performType == a) {      // 攻撃の場合
                y = this.toCell.getY();
                x = this.toCell.getX();
                if (命中) {
                    if (沈没させた) {
                        masume[x][y] *= 0;
                        masume[x+1][y+1] *= 0.5;
                        masume[x+1][y] *= 0.5;
                        masume[x+1][y-1] *= 0.5;
                        masume[x][y+1] *= 0.5;
                        masume[x][y-1] *= 0.5;
                        masume[x-1][y+1] *= 0.5;
                        masume[x-1][y] *= 0.5;
                        masume[x-1][y-1] *= 0.5;
                    } else if {
                        masume[x][y] *= 50;
                    }
                } else if (波高し) {
                    masume[x][y] *= 0.5;
                    masume[x+1][y+1] *= 10;
                    masume[x+1][y] *= 10;
                    masume[x+1][y-1] *= 10;
                    masume[x][y+1] *= 10;
                    masume[x][y-1] *= 10;
                    masume[x-1][y+1] *= 10;
                    masume[x-1][y] *= 10;
                    masume[x-1][y-1] *= 10;
                } else if (はずれ) {
                    masume[x][y] *= 0.5;
                    masume[x+1][y+1] *= 0.5;
                    masume[x+1][y] *= 0.5;
                    masume[x+1][y-1] *= 0.5;
                    masume[x][y+1] *= 0.5;
                    masume[x][y-1] *= 0.5;
                    masume[x-1][y+1] *= 0.5;
                    masume[x-1][y] *= 0.5;
                    masume[x-1][y-1] *= 0.5;
                }
            }
        }
    }

    if (相手残り２艦艦) {
        @Override
        public namae nokori2 {
            idou = 2;
        }
    } else if (相手残り１艦) {
        `Override
        public namae nokori1 {
            if (Log.doTeamId == 0) {                // 相手のターン
                if (Log.performType == m) {         // 移動の場合
                    if (Log.direction == n) {       // 北に移動の場合
                        if (Log.distance == 1) {    // 1マス移動の場合
                            for (int i = 1; i < 6; i++) {
                                masume[5][i] = 1;
                            }
                        } else if (Log.distance == 2) {  // ２マス移動の場合
                            for (int i = 4; i < 6; i++) {
                                for (int j = 1; j < 6; j++) {
                                    masume[i][j] = 1;
                                }
                            }
                        }
                    } else if (Log.direction == s) {     //  南に移動の場合
                        if (Log.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                masume[1][j] = 1;
                            }
                        } else if (Log.distance == 2) {
                            for (int i = 1; i < 3; i++) {
                                for (int j = 1; j < 6; j++) {
                                    masume[i][j] = 1;
                                }
                            }
                        }
                    } else if (Log.direction == e) {     //  東に移動の場合
                        if (Log.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                masume[i][1] = 1;
                            }
                        } else if (Log.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 1; j < 3; j++) {
                                    masume[i][j] = 1;
                                }
                            }
                        }
                    } else if (Log.direction == w) {     //  西に移動の場合
                        if (Log.distance == 1) {
                            for (int i = 1; i < 6; i++) {
                                masume[i][5] = 1;
                            }
                        } else if (Log.distance == 2) {
                            for (int i = 1; i < 6; i++) {
                                for (int j = 4; j < 6; j++) {
                                    masume[i][j] = 1;
                                }
                            }
                        }
                    }
                } else if (Log.performType == a) { // (被)攻撃の場合
                    y = this.toCell.getY();
                    x = this.toCell.getX();
                    masume[x][y] *= 0.5;
                    masume[x+1][y+1] *= 10;
                    masume[x+1][y] *= 10;
                    masume[x+1][y-1] *= 10;
                    masume[x][y+1] *= 10;
                    masume[x][y-1] *= 10;
                    masume[x-1][y+1] *= 10;
                    masume[x-1][y] *= 10;
                    masume[x-1][y-1] *= 10;
                }
            } else if (Log.doTeamId == 1) {      // 自分のターン
                if (Log.performType == a) {      // 攻撃の場合
                    y = this.toCell.getY();
                    x = this.toCell.getX();
                    if (命中) {
                        break;
                    } else if (波高し) {
                        double masu1 = masuma[x][y];
                        double masu2 = masume[x+1][y+1];
                        double masu3 = masume[x+1][y];
                        double masu4 = masume[x+1][y-1];
                        double masu5 = masume[x][y+1];
                        double masu6 = masume[x][y-1];
                        double masu7 = masume[x-1][y+1];
                        double masu8 = masume[x-1][y];
                        double masu9 = masume[x-1][y-1];
                        for (int i = 1; i < 6; i++) {
                            for (int j = 0; j < 6; j++) {
                                masume[i][j] = 1;
                            }
                        }
                        masume[x][y] = masu1;
                        masume[x+1][y+1] = masu2;
                        masume[x+1][y] = masu3;
                        masume[x+1][y-1] = masu4;
                        masume[x][y+1] = masu5;
                        masume[x][y-1] = masu6;
                        masume[x-1][y+1] = masu7;
                        masume[x-1][y] = masu8;
                        masume[x-1][y-1] = masu9;
                        }
                    } else if (はずれ) {
                        masume[x][y] *= 0.5;
                        masume[x+1][y+1] *= 0.5;
                        masume[x+1][y] *= 0.5;
                        masume[x+1][y-1] *= 0.5;
                        masume[x][y+1] *= 0.5;
                        masume[x][y-1] *= 0.5;
                        masume[x-1][y+1] *= 0.5;
                        masume[x-1][y] *= 0.5;
                        masume[x-1][y-1] *= 0.5;
                    }
                }
            }
        }
    }
}