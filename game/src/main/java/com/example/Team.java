package com.example;
import java.util.ArrayList;

public abstract class Team {
    private static final int SUBMARINE_COUNT = 4;
    private int teamId;
    private ArrayList<Submarine> submarineList;

    public Team(Map map, int teamId) {
        this.teamId = teamId;
        submarineList = new ArrayList<Submarine>(SUBMARINE_COUNT);
        for (int i = 0; i < SUBMARINE_COUNT; i++) {
            MapCell startCell = map.getCell(2, i+1); // strategyで決める
            
            char code = (char)('a' + i);

            submarineList.add(new Submarine(startCell, code, teamId));
        }
    }

    public ArrayList<Submarine> getSubmarineList() {
        return submarineList;
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
        return this.teamId;
    }

    public abstract ArrayList<String> takeTurn(Map map);
}