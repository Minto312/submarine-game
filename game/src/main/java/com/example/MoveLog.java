
public class MoveLog extends Log {
    public final String performType = "move";
    public final String direction;
    public final int distance;

    public MoveLog(int turn, int doTeamId, String direction, int distance) {
        super(turn, doTeamId);
        this.direction = direction;
        this.distance = distance;
    }
    
    @Override
    public void showLog() {
        System.out.println("move " + direction + " " + distance);
    }
}