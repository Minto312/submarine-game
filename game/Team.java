import java.util.Vector;


public abstract class Team {
    private static final int SUBMARINE_COUNT = 4;
    private int teamId;
    private Vector<Submarine> submarineList;

    public Team(Map map, int teamId) {
        this.teamId = teamId;
        submarineList = new Vector<Submarine>(SUBMARINE_COUNT);
        for (int i = 0; i < SUBMARINE_COUNT; i++) {
            MapCell startCell = map.getCell(0, i); // strategyで決める
            
            char code = (char)('a' + i);

            submarineList.add(new Submarine(startCell, code));
        }
    }

    public Vector<Submarine> getSubmarineList() {
        return submarineList;
    }

    public void move(char submarineCode, String cellCode, Map map) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

        MapCell toCell = map.getCell(y, x);
        for (Submarine submarine : submarineList) {
            if (submarine.getCode() == submarineCode) submarine.move(toCell, this.teamId);
        }
    }

    public void attack(String cellCode, Map map) {
        int[] res = Util.parseCellCode(cellCode);
        int y = res[0];
        int x = res[1];

    }

    public abstract void takeTurn(Map map);
}