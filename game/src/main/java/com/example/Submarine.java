// package com.example;

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

    public String move(MapCell toCell) {
        int dy = toCell.getY() - this.currentCell.getY();
        int dx = toCell.getX() - this.currentCell.getX();

        System.out.println("[debug] currentCell: (" + this.currentCell.getY() + ", " + this.currentCell.getX() + ")");
        System.out.println("[debug] toCell: (" + toCell.getY() + ", " + toCell.getX() + ")");
        String direction = "";
        System.out.println("[debug] dy: " + dy + ", dx: " + dx);

        int distance = Math.abs(dy) + Math.abs(dx);
        if (dy < 0) {
            direction = "北";
        } else if (dy > 0) {
            direction = "南";
        } else if (dx > 0) {
            direction = "東";
        } else if (dx < 0) {
            direction = "西";
        }
        System.out.println("[debug] 潜水艦 " + this.code + " が " + direction + " に " + distance
                + " マス移動しました。(" + toCell.getY() + ", " + toCell.getX() + ")");

        String reaction = "潜水艦を" + direction + "に" + distance + "マス移動！";
        System.out.println(reaction);

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
            System.out.println("[debug] 潜水艦 " + this.code + " が沈みました。");
            System.out.println("命中！撃沈！");
        }
    }

}
