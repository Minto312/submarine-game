package com.example;
import java.util.ArrayList;


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

    public ArrayList<MapCell> calculateAttackArea(Team team) {
        ArrayList<MapCell> attackableCells = new ArrayList<MapCell>();
        ArrayList<Submarine> submarines = team.getSubmarineList();
        ArrayList<MapCell> submarineCells = new ArrayList<MapCell>();
        for (Submarine submarine : submarines) {
            submarineCells.add(submarine.getCurrentCell());
        }

        for (MapCell submarineCell : submarineCells) {
            int x = submarineCell.getX();
            int y = submarineCell.getY();
            
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                        MapCell cell = grid[x + i][y + j];
                        if (!cell.isBlocked() && cell.getSubmarine(team.getTeamId()) == null) {
                            attackableCells.add(cell);
                        }
                }
            }
        }
        return attackableCells;
    }

}