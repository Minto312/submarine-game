// package com.example;

public class ComputerTeam extends Team {

    private Strategy strategy;

    public ComputerTeam(Map map, int teamId) {
        super(map, teamId);
        this.strategy = new Strategy(this);
        this.submarineList = strategy.initializeSubmarines(map);
    }

    @Override
    public Log takeTurn(Game game) {
        Log log = strategy.performTurn(game);
        return log;
    }
}
