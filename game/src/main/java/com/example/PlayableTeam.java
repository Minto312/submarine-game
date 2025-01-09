// package com.example;

import java.util.Scanner;
import java.util.ArrayList;

public class PlayableTeam extends Team {

    public PlayableTeam(Map map, int teamId) {
        super(map, teamId);
    }

    @Override
    public Log takeTurn(Map map) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        if (inputArray[0].equals("m")) {
            String cellCode = inputArray[1];
            this.respondAttack(map, cellCode);
        } 

        if (inputArray[0].equals("a")) {
            String cellCode = inputArray[1];
            respondAttack(map, cellCode);
        } 

        ArrayList<Log> logs = new ArrayList<>();

        return logs;
    }

}
