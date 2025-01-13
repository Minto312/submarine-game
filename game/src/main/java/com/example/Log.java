

public class Log {
    private static int counter = 0;
    public final int turn;
    public final int doTeamId;
    public final String performType;
    public final MapCell toCell;
    public String reaction;

    public Log(int doTeamId, String performType, MapCell toCell, String react) {
        this.turn = ++counter;
        this.doTeamId = doTeamId;
        this.performType = performType;
        this.toCell = toCell;
        this.reaction = react;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public void showLog() {
        System.out.println("[" + this.turn + "ターン目] " + this.doTeamId + "チーム: " + this.performType + " " + this.toCell.getY() + ", " + this.toCell.getX() + " " + this.reaction);
    }
}