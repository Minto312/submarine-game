// package com.example;
import java.util.Scanner;

public class Game {
    private final Map map;
    private int turn = 0;
    private int currentTeam;
    private final Team[] teams;
    private final History history;

    public Game(int firstTeamId) {
        this.currentTeam = firstTeamId;
        this.map = new Map();
        
        this.teams = new Team[2];
        this.teams[0] = new PlayableTeam(this.map, 0);
        this.teams[1] = new ComputerTeam(this.map, 1);
        this.history = new History();
    }

    public Map getMap() {
        return this.map;
    }

    public int getTurn() {
        return this.turn;
    }

    public void stepTurn() {
        this.turn++;
        this.currentTeam = (this.currentTeam + 1) % 2;
    }


    public static void main(String[] args) {
        Game game = new Game(0);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("game.teams[game.currentTeam % 2].getTeamId() = " + game.teams[game.currentTeam % 2].getTeamId());   
            game.map.showMap(0, game.teams[0].getSubmarineList());
            game.map.showMap(1, game.teams[1].getSubmarineList());

            Log log = game.teams[game.currentTeam].takeTurn(game);
            game.teams[(game.currentTeam+1) % 2].tellResponse(log, game);

            log.showLog(); 
            game.history.addLog(log);
            game.stepTurn();
        }
    }
}