// package com.example;
import java.util.Scanner;

// i行j列の想定

public class ExpectedValue {
    public void namae () {
        if (Log.doTeamId == 0) {                // 相手のターン
            if (Log.performType == m) {         // 移動の場合
                if (Log.direction == n) {       // 北に移動の場合
                    if (Log.distance == 1) {    // 1マス移動の場合
                        for (int i = 1; i < 5; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    } else if (Log.distance == 2) {  // ２マス移動の場合
                        for (int i = 1; i < 4; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    }
                } else if (Log.direction == s) {     //  南に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 2; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 1; j < 6; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    }
                } else if (Log.direction == e) {     //  東に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 2; j < 6; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 3; j < 6; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    }
                } else if (Log.direction == w) {     //  西に移動の場合
                    if (Log.distance == 1) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 5; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    } else if (Log.distance == 2) {
                        for (int i = 1; i < 6; i++) {
                            for (int j = 1; j < 4; j++) {
                                masume[i][j] * 1.1;
                            }
                        }
                    }
                }
            } else if (Log.performType == a) {
                this.toCell.getY();
                this.toCell.getX();
            }
        }
    }
}