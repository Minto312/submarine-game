class Submarine {
    private char code;
    private int hp;
    private MapCell currentCell;

    public Submarine(MapCell startCell, char code) {
        this.code = code;
        this.hp = 3;
        this.currentCell = startCell;
    }

    public char getCode() {
        return this.code;
    }

    public void move(MapCell toCell, int teamId) {
        this.currentCell.removeSubmarine(teamId);

        this.currentCell = toCell;
        this.currentCell.setSubmarine(this, teamId);
    }

    public void takeDamage(int damage) {
        this.hp -= 1;
        if (this.hp == 0) {
            this.currentCell.sinkSubmarine();
            // チームの潜水艦を削除
        }
    }

}