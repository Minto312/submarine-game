// package com.example;
import java.util.Scanner;

public class Game {
    private final Map map;
    private int currentTeam;
    private final Team[] teams;
    private final History history;

    public Game(int firstTeamId) {
        this.currentTeam = firstTeamId;
        this.map = new Map();
        
        this.teams = new Team[2];
        for (int i = 0; i < 2; i++) {
            this.teams[i] = new PlayableTeam(map, i);
        }
        this.history = new History();
    }

    public Map getMap() {
        return this.map;
    }


    public static void main(String[] args) {
        Game game = new Game(0);
        Map map = new Map();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            map.showMap(0, game.teams[0].getSubmarineList());
            map.showMap(1, game.teams[1].getSubmarineList());

            Log log = game.teams[game.currentTeam % 2].takeTurn(game);
            game.teams[(game.currentTeam+1) % 2].tellResponse(log, game);

            game.history.addLog(log);
            game.currentTeam++;
        }
    }
}