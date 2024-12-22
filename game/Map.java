
import java.util.Vector;


public class Map {
    private static final int SIZE = 7;
    private MapCell[][] grid;

    public Map() {
        grid = new MapCell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1) {
                    grid[i][j] = new MapCell(i, j, true);
                } else {
                    grid[i][j] = new MapCell(i, j, false);
                }
            }
        }
    }

    public MapCell getCell(int y, int x) {
        return this.grid[y][x];
    }

    public int[][] calculateAttackArea(Team team) {
        Vector<MapCell> attackableCells = new Vector<MapCell>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                    MapCell cell = grid[x + i][y + j];
                    if (!cell.isBlocked() && cell.getSubmarine() == null) {
                        attackableCells.add(cell);
                    }
                    range[x + i][y + j] = 1;
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