// package com.example;

import java.util.ArrayList;

public class ComputerTeam extends Team {

    private Strategy strategy = new Strategy(this);

    public ComputerTeam(Map map, int teamId) {
        super(map, teamId);
        this.submarineList = strategy.initializeSubmarines(map);
    }

    @Override
    public Log takeTurn(Game game) {
        Log log = strategy.takeTurn(game);
        return log;
    }
}
