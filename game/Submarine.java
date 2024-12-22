class Submarine {
    private char code;
    private int hp;
    private MapCell currentCell;

    public Submarine(MapCell startCell, char code) {
        this.code = code;
        this.hp = 3;
        this.currentCell = startCell;
    }

    public void move(String cellCode, int teamId, Map map) { // [A-1]
        this.currentCell.removeSubmarine(teamId);

        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

        this.currentCell = map.getCell(y, x);
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