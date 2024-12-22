

public class SubmarineGame {
    public static void main(String[] args) {
        Map map = new Map();
        Team team1 = new Team();
        Team team2 = new Team();
        History history = new History();

        // Example moves
        team1.makeMove(0, 2, 2);
        history.logAction("Team 1 submarine 0 moved to (2, 2)");

        team2.makeMove(1, 3, 3);
        history.logAction("Team 2 submarine 1 moved to (3, 3)");

        history.printHistory();
    }
} 