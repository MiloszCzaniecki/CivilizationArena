package src;

import java.util.*;

public class State {
    private Set<int[]> area = new HashSet<>();
    private static Set<int[]> usedspace = new HashSet<>();





    private int gold;
    private int food;
    private int resources;
    private  int ID;

    private static int quantity=0;

    public State(int[] a, int g, int f, int r)//konstruktor inicjalizujący
    {
        usedspace.add(a);
        area.add(a);
        gold = g;
        food = f;
        resources = r;
        ID=quantity+1;
        quantity++;
    }

    public State() {
        area.addAll(usedspace);
    }//konstruktor domyślny


    public Set<int[]> getArea() {
        return area;
    }//wraca obszar State

    public int getGold() {
        return gold;
    }//zwraca liczbę złota

    public int getFood() {
        return food;
    }//zwraca liczbę jedzenia

    public int getResources() {
        return resources;
    }//zwraca liczbę zasobów

    public int getID() {
        return ID;
    }//zwraca ID

    public static int getQuantity() {
        return quantity;
    }

    public void annex( int[] a)//dodaje przestrzeń
    {
        area.add(a);
        usedspace.add(a);
    }
    public void lose(int[] a)//usuwa przestrzeń
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
    public boolean expand(int[] x, Map map)//rozszerza obszar
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

    //tutaj zaczyna się zabawa
    public void Explore(int[] x, List<State> states)// eksploruje lub atakuje?
    {   if(belongsToState(x)==false)
    {
        Map map = new Map();
        if (map.isFreeS(x)&&map.neighbourS(x,getState()))
        {
            expand(x, map);
        }
        else
        {
            map.Attack(x,getState(),map.occupation(states, x));
        }

    }

    }

    public boolean belongsToState(int[] x)// sprawdza, czy punkt x należy do State
    {
        boolean belongs = false;

        for(int[] element: getArea())
        {
            if(Arrays.equals(element,x))
            {
                belongs=true;

                break;
            }
        }
        return belongs;
    }

    public State getState()
    {
        return this;
    }

    public void ExploringAction(List<State> states, int X, int Y) //WAŻNE
    {

        Map map = new Map();
        Generator G = new Generator();
        Explore(G.GeneratePointOutOf(X, Y, getState()),states);
        map=null;


    }

    public void BlindExploringAction(List<State> states, int X, int Y)
    {
        Map map = new Map();
        Generator G = new Generator();
        Explore(G.GeneratePoint(X, Y),states);
        map=null;

    }

}
