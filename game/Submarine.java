class Submarine {
    private int hp;
    private int x, y;

    public Submarine(int startX, int startY) {
        this.hp = 100;
        this.x = startX;
        this.y = startY;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
}