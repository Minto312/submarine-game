

class Team {
    private Submarine[] submarines;

    public Team() {
        submarines = new Submarine[4];
        for (int i = 0; i < 4; i++) {
            submarines[i] = new Submarine(i, 0);
        }
    }

    public void makeMove(int index, int newX, int newY) {
        if (index >= 0 && index < submarines.length) {
            submarines[index].move(newX, newY);
        }
    }
}