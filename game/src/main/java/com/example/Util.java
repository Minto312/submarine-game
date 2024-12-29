package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    /**
     * Utility class for parsing cell codes. [A-1] or a1 -> [1, 1]
     *
     * @param cellCode the cell code to parse
     * @return an array containing the row and column of the cell
     * @throws IllegalArgumentException if the cell code is not in the expected
     * 
     */
    public static int[] parseCellCode(String cellCode) {
        if (cellCode == null || cellCode.isEmpty()) {
            throw new IllegalArgumentException("Invalid cell code format");
        }
        Pattern regularPattern = Pattern.compile("\\[[A-E]-[1-5]\\]");
        Pattern shortPattern = Pattern.compile("[a-e][1-5]");
        Matcher regularMatcher = regularPattern.matcher(cellCode);
        Matcher shortMatcher = shortPattern.matcher(cellCode);

        if (!regularMatcher.matches() && !shortMatcher.matches()) {
            throw new IllegalArgumentException("Invalid cell code format");
        }

        try {
            int y, x;
            if (regularMatcher.matches()) {
                y = cellCode.charAt(1) - 'A' + 1;
                x = Integer.parseInt(String.valueOf(cellCode.charAt(3)));
            } else {
                y = cellCode.charAt(0) - 'a' + 1;
                x = Integer.parseInt(String.valueOf(cellCode.charAt(1)));
            }
            return new int[]{y, x};
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("failed to parse cell code" + cellCode, e);
        }
    }
}
