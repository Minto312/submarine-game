package com.example;
import java.util.ArrayList;


public class SubmarineGame {
    private int turn;
    private Map map;
    private Team[] teams;
    private History history;

    public SubmarineGame(int startTeam) {
        this.turn = startTeam;
        this.map = new Map();
        
        this.teams = new Team[2];
        for (int i = 0; i < 2; i++) {
            this.teams[i] = new PlayableTeam(map, i);
        }
        this.history = new History();
    }

    public ArrayList<String> nextTurn() {
        ArrayList<String> logs = new ArrayList<String>();
        Team team = teams[turn % 2];
        logs = team.takeTurn(map);

        return logs;
    }
} 