// package com.example;

import java.util.ArrayList;

public abstract class Team {

    private static final int SUBMARINE_COUNT = 4;
    public int TEAM_ID;
    protected ArrayList<Submarine> submarineList;

    public Team(Map map, int teamId) {
        this.TEAM_ID = teamId;
    }

    public ArrayList<Submarine> getSubmarineList() {
        return submarineList;
    }

    public String respondAttack(Map map, MapCell cell) {
        String reaction = "nothing";

        if (cell.existSubmarine(this.getTeamId())) {
            System.out.println("[debug] 潜水艦 " + cell.getSubmarine(this.getTeamId()).getCode() + " が攻撃されました");
            reaction = "命中！";
            System.out.println(reaction);
            Submarine attackedSubmarine = cell.getSubmarine(this.getTeamId());
            attackedSubmarine.takeDamage();
            return reaction;
        }

        int y = cell.getY();
        int x = cell.getX();
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

                if (neighborCell.existSubmarine(this.getTeamId())) {
                    reaction = "波高し！";
                    System.out.println(reaction);
                    System.out.println("潜水艦 " + neighborCell.getSubmarine(TEAM_ID).getCode() + " 近くにあります");
                    return reaction;
                }
            }
        }
        return reaction;
    }

    public void move(char submarineCode, String cellCode, Map map) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

        MapCell toCell = map.getCell(y, x);
        for (Submarine submarine : submarineList) {
            if (submarine.getCode() == submarineCode) {
                submarine.move(toCell);
            }
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

    public void tellResponse(Log log, Game game) {
        String reaction = "";
        try {
            if ("a".equals(log.performType)) {
                reaction = this.respondAttack(game.getMap(), log.toCell);
            }
        } catch (NullPointerException e) {
            System.err.println("log.performType is null");
            throw e;
        }
        log.setReaction(reaction);
    }

   public abstract Log takeTurn(Game game);
}