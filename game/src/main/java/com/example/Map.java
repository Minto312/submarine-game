// package com.example;
import java.util.ArrayList;


public class Map {
    private static final int SIZE = 7;
    private final MapCell[][] grid;

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
        ArrayList<MapCell> attackableCells = new ArrayList<>();
        ArrayList<Submarine> submarines = team.getSubmarineList();
        ArrayList<MapCell> submarineCells = new ArrayList<>();
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

    public void showMap(int teamId, Submarine[] submarines) {
        System.out.println("  0 1 2 3 4 5 6");
        for (int i = 0; i < SIZE; i++) {
            if (i == 0 || i == SIZE - 1) {
                System.out.print(i + " ");
            } else {
                System.out.print((char)('A'+i-1) + " ");
            }
            for (int j = 0; j < SIZE; j++) {
                MapCell cell = grid[i][j];
                if (cell.existSubmarine(teamId)) {
                    System.out.print(cell.getSubmarine(teamId).getCode() + " ");
                } else if (cell.isBlocked()) {
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int k=0; k<4; k++) {
            System.out.println((char)('a'+k) + ": " + submarines[k].getHp() + " ");
        }
    }

}