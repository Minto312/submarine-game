// package com.example;

import java.util.Scanner;

public class PlayableTeam extends Team {

    private Strategy strategy;

    public PlayableTeam(Map map, int teamId) {
        super(map, teamId);
        this.strategy = new Strategy(this);
        this.submarineList = strategy.initializeSubmarines(map);
    }

    @Override
    public Log takeTurn(Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("チーム" + this.getTeamId() + "のターンです。");
        System.out.print("-- ex -----\nm a1 c\na a1\n-----------\nPlease input your action: ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        String performType = inputArray[0];

        String cellCode = inputArray[1];
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];
        MapCell toCell = game.getMap().getCell(y, x);

        String reaction = "";

        if (performType.equals("m")) {
            for (Submarine sub : this.getSubmarineList()) {
                if (sub.getCode() == inputArray[2].charAt(0)) {
                    reaction = sub.move(toCell);
                }
            }
        }

        if (performType.equals("a")) {
        }

        return new Log(game.getTurn(), this.getTeamId(), inputArray[0], toCell, reaction);
    }
}
