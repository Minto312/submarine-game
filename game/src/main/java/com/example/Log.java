import java.util.Objects;

public abstract  class Log {
    public final int turn;
    public final int doTeamId;

    public Log(int turn, int doTeamId) {
        this.turn = turn;
        this.doTeamId = doTeamId;
    }

    public abstract void showLog();
}