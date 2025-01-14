// package com.example;

import java.util.Scanner;

public class PlayableTeam extends Team {

    public PlayableTeam(Map map, int teamId) {
        super(map, teamId);
        this.submarineList = Strategy.initializeSubmarines(map, teamId);
    }

    @Override
    public Log takeTurn(Game game) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        String performType = inputArray[0];

        String cellCode = inputArray[1];
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];
        MapCell toCell = game.getMap().getCell(y, x);

        String reaction = null;

        if (performType.equals("m")) {
            for (Submarine sub : this.getSubmarineList()) {
                if (sub.getCode() == inputArray[2].charAt(0)) {
                    reaction = sub.move(toCell);
                }
            }
        }

        if (performType.equals("a")) {
        }

        Log log = new Log(game.getTurn(), this.getTeamId(), inputArray[0], toCell, reaction);

        return log;
    }
}
