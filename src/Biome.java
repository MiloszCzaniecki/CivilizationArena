package src;

import java.util.Set;

public class Biome {

    private Set<int[]> area;
    private int resources;

    private int id=0;
    private static int quantity=0;


    public Biome(int[] a)
    {
        area.add(a);
        quantity++;
        id=quantity;
    }


    public Set<int[]> getArea() {
        return area;
    }
    public void addArea(int[] x)
    {
        area.add(x);
    }

}
