

public class MapCell {
    private static final int PLAYER_COUNT = 2;

    private int x, y; // 0-6
    private boolean isBlocked;
    private Submarine[] submarine;


    public MapCell(int x, int y, boolean isBlocked) {
        this.x = x;
        this.y = y;
        this.isBlocked = isBlocked;
        this.submarine = new Submarine[PLAYER_COUNT];
    }

    public void sinkSubmarine() {
        this.isBlocked = true;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public void setSubmarine(Submarine submarine, int teamId) {
        if (this.submarine[teamId] != null) throw new IllegalArgumentException("Submarine already exists");
        this.submarine[teamId] = submarine;
    }

    public void removeSubmarine(int teamId) {
        if (this.submarine[teamId] == null) throw new IllegalArgumentException("No submarine to remove");
        this.submarine[teamId] = null;
    }

    public Submarine getSubmarine(int teamId) {
        return this.submarine[teamId];
    }

    public boolean existSubmarine(int teamId) {
        return this.submarine[teamId] != null;
    }
}