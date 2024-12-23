package com.example;

public class Util {
    public static int[] parseCellCode(String cellCode) {
        int y = cellCode.charAt(1) - 'A' + 1;
        int x = Integer.parseInt(String.valueOf(cellCode.charAt(3)));
        return new int[]{y, x};
    }
}