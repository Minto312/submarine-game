// package com.example;
import java.util.ArrayList;

public abstract class Team {
    private static final int SUBMARINE_COUNT = 4;
    private int TEAM_ID;
    private ArrayList<Submarine> submarineList;

    public Team(Map map, int teamId) {
        this.TEAM_ID = teamId;
        submarineList = new ArrayList<>(SUBMARINE_COUNT);
        for (int i = 0; i < SUBMARINE_COUNT; i++) {
            MapCell startCell = map.getCell(2, i+1); // strategyで決める
            
            char code = (char)('a' + i);

            submarineList.add(new Submarine(startCell, code, TEAM_ID));
        }
    }

    public ArrayList<Submarine> getSubmarineList() {
        return submarineList;
    }

    public void respondAttack(Map map, String cellCode) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

        MapCell cell = map.getCell(y, x);
        if (cell.existSubmarine(this.TEAM_ID)) {
            System.out.println("[debug] 潜水艦 " + cell.getSubmarine(this.TEAM_ID).getCode() + " が攻撃されました");
            System.out.println("命中！");
            Submarine attackedSubmarine = cell.getSubmarine(this.TEAM_ID);
            attackedSubmarine.takeDamage();
            return;
        }

        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dy == 0 && dx == 0) {
                    continue;
                }

                int neighborY = y + dy;
                int neighborX = x + dx;

                MapCell neighborCell;
                try {
                    neighborCell = map.getCell(neighborY, neighborX);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }

                if (neighborCell.existSubmarine(this.TEAM_ID)) {
                    System.out.println("波高し！");
                    System.out.println("潜水艦 " + neighborCell.getSubmarine(TEAM_ID).getCode() + " 近くにあります");
                    return;
                }
            }
        }
    }

    public void move(char submarineCode, String cellCode, Map map) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

        MapCell toCell = map.getCell(y, x);
        for (Submarine submarine : submarineList) {
            if (submarine.getCode() == submarineCode) submarine.move(toCell);
        }
    }

    public void attack(String cellCode, Map map) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

    }

    public int getTeamId() {
        return this.TEAM_ID;
    }

    public abstract void tellAction(Map map);

    public abstract ArrayList<String> takeTurn(Game game);
}