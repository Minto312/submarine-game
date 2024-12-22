
public class Map {
    private static final int SIZE = 5;
    private int[][] grid;

    public Map() {
        grid = new int[SIZE][SIZE];
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    public int[][] calculateAttackRange(int x, int y) {
        int[][] range = new int[SIZE][SIZE];
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isWithinBounds(x + i, y + j)) {
                    range[x + i][y + j] = 1;
                }
            }
        }
        return range;
    }

    public int[][] calculateMovementRange(int x, int y) {
        int[][] range = new int[SIZE][SIZE];
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (isWithinBounds(x + i, y + j)) {
                    range[x + i][y + j] = 1;
                }
            }
        }
        return range;
    }
}