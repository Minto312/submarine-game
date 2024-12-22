public class Util {
    public static int[] parseCellCode(String cellCode) {
        int y = cellCode.charAt(0) - 'A' + 1;
        int x = Integer.parseInt(cellCode.substring(2));
        return new int[]{y, x};
    }
}