

public class Log {
    private static int counter = 0;
    public final int turn;
    public final int doTeamId;
    public final String performType;
    public final MapCell toCell;
    public final String react;

    public Log(int doTeamId, String performType, MapCell toCell, String react) {
        this.turn = ++counter;
        this.doTeamId = doTeamId;
        this.performType = performType;
        this.toCell = toCell;
        this.react = react;
    }
}