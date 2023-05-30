package src;

import java.util.Set;

public abstract class Structure {
    private int[] area;
    private State state;

    private static int quantity=0;
    private int ID;
    private int durability;

    public Structure(int[] a, State s)
    {
        area=a;
        state = s;
        durability =0;
        quantity++;
        ID=quantity;

    }

    public Structure getStructure()
    {
        return this;
    }
    public  void takeDamage(int dmg)
    {
        durability=durability-dmg;
        if(state.getArea().contains(area)==false)
        {
            state.fortDestruct();
        }


    }
    public void changeDurability(int dur)
    {
        durability=+dur;
    }

    public int[] getArea()
    {
        return area ;
    }

    public State getState()
    {
        return state;
    }
}
