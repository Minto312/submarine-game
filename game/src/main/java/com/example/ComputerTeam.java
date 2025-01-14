// package com.example;

import java.util.ArrayList;

public class ComputerTeam extends Team {

    public ComputerTeam(Map map, int teamId) {
        super(map, teamId);
        this.submarineList = Strategy.initializeSubmarines(map, teamId);
    }

    @Override
    public Log takeTurn(Game game) {
        Log log = Strategy.takeTurn(game, this);
        return log;
    }
}
