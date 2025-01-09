// package com.example;
import java.util.ArrayList;


public class SubmarineGame {
    private int turn;
    private Map map;
    private Team[] teams;
    private History history;

    public SubmarineGame(int startTeam) {
    }

    public ArrayList<String> nextTurn() {
        ArrayList<String> logs = new ArrayList<String>();
        Team team = teams[turn % 2];
        logs = team.takeTurn(map);

        return logs;
    }
} 