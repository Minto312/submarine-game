import java.util.ArrayList;

public class game {
    public static void main(String[] args) {
        SubmarineGame game = new SubmarineGame(0);

        while (true) {
            ArrayList<String> logs = game.nextTurn();
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }
}