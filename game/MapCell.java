

public class MapCell {
    private int x, y;
    private boolean isOccupied;
    private Submarine submarine;

    public MapCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
        this.submarine = null;
    }

    public void occupyCell(Submarine submarine) {
        this.isOccupied = true;
        this.submarine = submarine;
    }

    public void vacateCell() {
        this.isOccupied = false;
        this.submarine = null;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public Submarine getSubmarine() {
        return this.submarine;
    }
}