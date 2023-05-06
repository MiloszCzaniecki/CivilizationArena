package src;

import java.util.*;

public class State {
    private Set<int[]> area = new HashSet<>();
    private static Set<int[]> usedspace = new HashSet<>();





    private int gold;
    private int food;
    private int materials;
    private  int ID;

    private static int quantity=0;

    public State(int[] a, int g, int f, int m)
    {
        usedspace.add(a);
        area.add(a);
        gold = g;
        food = f;
        materials = m;
        ID=quantity+1;
        quantity++;
    }

    public State() {
        area.addAll(usedspace);
    }


    public Set<int[]> getArea() {
        return area;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    public int getMaterials() {
        return materials;
    }

    public int getID() {
        return ID;
    }

    public static int getQuantity() {
        return quantity;
    }

    public void annex( int[] a)
    {
        area.add(a);
        usedspace.add(a);
    }
    public void lose(int[] a)
    {
        int[] usun = null;
        for(int[] e: area)
        {
            if(Arrays.equals(a,e))
            {
                usun=e;
                break;
            }

        }
        area.remove(usun);

    }
    public boolean expand(int[] x, Map map)
    {
        boolean success = false;
        if(map.belongsToMap(x))
        {
            annex(x);
            success=true;
        }
        return success;
    }


    public void addGold(int a)
    {
        gold=gold+a;
    }
    public void addFood(int a)
    {
        food=food+a;
    }
}
