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
        this.teams[0] = new ComputerTeam(this.map, 0);
        this.teams[1] = new ComputerTeam(this.map, 1);
        this.history = new History();
    }

    public Map getMap() {
        return this.map;
    }

    public int getTurn() {
        return this.turn;
    }

    public History getHistory() {
        return this.history;
    }

    public void stepTurn() {
        this.turn++;
        this.currentTeam = (this.currentTeam + 1) % 2;
    }


    public static void main(String[] args) {
        Game game = new Game(0);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Turn: " + game.turn);
            System.out.println("チーム" + game.currentTeam + "のターンです。");
            game.map.showMap(game.teams);

            Log log = game.teams[game.currentTeam].takeTurn(game);
            game.teams[(game.currentTeam+1) % 2].tellResponse(log, game);

            log.showLog(); 
            game.history.addLog(log);
            System.out.println("\nEnter to continue\n");
            scanner.nextLine();
            game.stepTurn();
        }
    }
}