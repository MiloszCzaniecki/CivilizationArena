package src;

public interface Unit {
    public int getPower();
    public int getRange();
    public int getHealth();
    public int getState();
    public int getPrice();
    public void setPower(int power);
    public void setRange(int range);
    public void setHealth(int health);
    public void setState(int state);
    public void setPrice(int price);
    public void attack(Unit enemy);
    public void move(int x, int y);
}
