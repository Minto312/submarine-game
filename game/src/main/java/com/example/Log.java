

public class Log {
    private static int counter = 0;
    public static final int turn;
    public static final int doTeamId;
    public static final String performType;
    public static final MapCell toCell;
    public static String reaction;

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

    public static void direction() {
        // unimplemented
    }
}