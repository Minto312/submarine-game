import java.util.Vector;


class Team {
    private static final int SUBMARINE_COUNT = 4;
    private Vector<Submarine> submarineList;

    public Team(Map map) {
        submarineList = new Vector<Submarine>(SUBMARINE_COUNT);
        for (int i = 0; i < SUBMARINE_COUNT; i++) {
            MapCell startCell = map.getCell(0, i); // strategyで決める
            
            char code = (char)('a' + i);

            submarineList.add(new Submarine(startCell, code));
        }
    }

    public void makeMove(int index, int newX, int newY) {
        if (index >= 0 && index < submarineList.size()) {
            submarineList.get(index).move(newX, newY);
        }
    }
        if (index >= 0 && index < submarines.length) {
            submarines[index].move(newX, newY);
        }
    }
}