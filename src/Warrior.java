package src;
import java.util.Random;

//TO JEST NA RAZIE ZROBIONE TYLKO BIORĄC POD UWAGĘ RZECZY Z KLASY MAP

public class Warrior extends Unit {
    private int currentX;
    private int currentY;
    private Map map;

    public Warrior(int power, int range, int health, int state, int price, int currentX, int currentY, Map map) {
        super(power, range, health, state, price);
        this.currentX = currentX;
        this.currentY = currentY;
        this.map = map;
    }

    @Override
    public void attack(Unit enemy) {
        if (enemy != null && enemy.getState() != 0) {
            int damage = getPower();
            enemy.setHealth(enemy.getHealth() - damage);
            System.out.println("Wojownik zadał " + damage + " obrażeń.");
            if (enemy.getHealth() <= 0) {
                enemy.setState(0);
                System.out.println("Wojownik został pokonany.");
            }
        } else {
            System.out.println("Nie ma kogo atakować.");
        }
    }

    @Override
    public void move(int x, int y) {
        if (isFreePosition(x, y)) {
            System.out.println("Wojownik przemieszcza się na pozycję: (" + x + ", " + y + ")");
            currentX = x;
            currentY = y;
        } else {
            System.out.println("Pozycja (" + x + ", " + y + ") jest zajęta lub poza mapą.");
        }
    }

    private boolean isFreePosition(int x, int y) {
        int[] position = {x, y};
        return map.belongsToMap(position) && map.isFreeS(position);
    }

    public void makeRandomMove() {
        Random random = new Random();
        int direction = random.nextInt(4);  // Losowe wybranie jednego z czterech kierunków (0-3)

        int newX = currentX;
        int newY = currentY;

        // Zmiana pozycji w zależności od wylosowanego kierunku
        if (direction == 0) {
            newX--;  // Ruch w lewo
        } else if (direction == 1) {
            newX++;  // Ruch w prawo
        } else if (direction == 2) {
            newY--;  // Ruch w górę
        } else if (direction == 3) {
            newY++;  // Ruch w dół
        }

        move(newX, newY);

    }
}