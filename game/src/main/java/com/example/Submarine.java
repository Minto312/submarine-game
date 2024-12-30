package com.example;
public class Submarine {
    private int teamId;
    private char code;
    private int hp;
    private MapCell currentCell;

    public Submarine(MapCell startCell, char code, int teamId) {
        this.teamId = teamId;
        this.code = code;
        this.hp = 3;
        this.currentCell = startCell;
        this.currentCell.setSubmarine(this, teamId);
    }

    public char getCode() {
        return this.code;
    }

    public MapCell getCurrentCell() {
        return this.currentCell;
    }

    public void move(MapCell toCell) {
        this.currentCell.removeSubmarine(this.teamId);

        this.currentCell = toCell;
        this.currentCell.setSubmarine(this, this.teamId);
    }

    public int getHp() {
        return this.hp;
    }

    public void takeDamage() {
        this.hp -= 1;
        if (this.hp == 0) {
            this.currentCell.sinkSubmarine();
            // チームの潜水艦を削除
        }
    }

}