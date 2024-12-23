import java.util.ArrayList;

public class ComputerTeam extends Team {
    public ComputerTeam(Map map, int teamId) {
        super(map, teamId);
    }

    @Override
    public ArrayList<String> takeTurn(Map map) {
        ArrayList<String> logs = new ArrayList<String>();
        // ここに戦略を書く
        
        return logs;
    }
    
}