package src;

import java.util.Set;

public abstract class Structure {
    private Set<int[]> area;
    private int state;
    private int durability;

    public Structure(int[] a, int id)
    {
        area.add(a);
        state = id;
        durability =0;
    }

    public  void takeDamage(int dmg)
    {
        durability=durability-dmg;
    }
    public void changeDurability(int dur)
    {
        durability=+dur;
    }
}
