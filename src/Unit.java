package src;

public abstract class Unit {
    private int power;
    private int range;
    private int health;
    private int state;
    private int price;

    public Unit(int power, int range, int health, int state, int price) {
        this.power = power;
        this.range = range;
        this.health = health;
        this.state = state;
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public int getRange() {
        return range;
    }

    public int getHealth() {
        return health;
    }

    public int getState() {
        return state;
    }

    public int getPrice() {
        return price;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void attack(Unit enemy);

    public abstract void move(int x, int y);
}
