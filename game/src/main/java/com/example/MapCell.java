// package com.example;

public class MapCell {
    private static final int PLAYER_COUNT = 2;

    private int x, y; // 0-6
    private boolean isBlocked;
    private Submarine[] submarine;


    public MapCell(int y, int x, boolean isBlocked) {
        this.x = x;
        this.y = y;
        this.isBlocked = isBlocked;
        this.submarine = new Submarine[PLAYER_COUNT];
    }

    public void sinkSubmarine() {
        this.isBlocked = true;
        this.submarine = new Submarine[PLAYER_COUNT]; // 相手の潜水艦も存在しない
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void setSubmarine(Submarine submarine, int teamId) {
        if (this.submarine[teamId] != null) {
            throw new IllegalArgumentException("Submarine already exists");
        }
        if (this.isBlocked) {
            throw new IllegalArgumentException("Cell is blocked");
        }
        
        this.submarine[teamId] = submarine;
    }

    public void removeSubmarine(int teamId) {
        if (this.submarine[teamId] == null) {
            throw new IllegalArgumentException("No submarine to remove");
        }

        this.submarine[teamId] = null;
    }

    public Submarine getSubmarine(int teamId) {
        return this.submarine[teamId];
    }

    public boolean existSubmarine(int teamId) {
        return this.submarine[teamId] != null;
    }
}