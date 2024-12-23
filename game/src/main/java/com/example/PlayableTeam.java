package com.example;
import java.util.Scanner;
import java.util.ArrayList;

public class PlayableTeam extends Team {
    public PlayableTeam(Map map, int teamId) {
        super(map, teamId);
    }

    @Override
    public ArrayList<String> takeTurn(Map map) {
        ArrayList<String> logs = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the submarine code and the cell code: ");
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        char submarineCode = inputs[0].charAt(0);
        String cellCode = inputs[1];

        move(submarineCode, cellCode, map);

        return logs;
    }
    
}