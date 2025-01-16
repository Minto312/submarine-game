
public class AttackLog extends Log {
    public final String performType = "attack";
    public final MapCell targetCell;
    public String reaction;

    public AttackLog(int turn, int doTeamId, MapCell targetCell) {
        super(turn, doTeamId);
        this.targetCell = targetCell;
        this.reaction = "";
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }
    
    @Override
    public void showLog() {
        char y = (char) (this.targetCell.getY()-1 + 'A');
        char x = (char) (this.targetCell.getX());

        System.out.println("attack " + y + "-" + x + " " + this.reaction);
    }
}