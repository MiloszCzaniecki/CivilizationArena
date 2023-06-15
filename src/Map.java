package src;

import java.util.*;

public class Map {
    private static int width;
    private static int height;


    private static int quantity=0;



    public  Map(int w, int h)
    {
            width = w;
            height = h;
            quantity++;
    }
    public Map()//konstruktor domyślny
    {


    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getQuantity() {
        return quantity;
    }
    public boolean belongsToMap(int[] point)//sprawdza, czy podany punkt znajduje się na mapie
    {
        boolean belongs = false;
        int w = getWidth();
        int h = getHeight();
        for(int x=0; x<w+1;x++)
        {
            for(int y=0;y<h+1;y++)
            {
                int[] point1 = {x,y};
                if(Arrays.equals(point,point1))
                {
                    belongs = true;
                }

            }
        }
        return belongs;
    }
    public void changeOccupation(int[] x,State A, State B)//zmienia przynależność punktu z A do B
    {
        if(belongsToMap(x)==true)
        {
            A.lose(x);
            B.annex(x);
        }


    }
    public boolean neighbourS(int[]x, State A)//sprawdza, czy punkt x ma sąsiada
    {
        boolean neighbour = false;
        int[] case1={0,0};
        case1[0]=x[0];
        case1[1]=x[1]+1;
        int[] case2={0,0};
        case2[0]=x[0];
        case2[1]=x[1]-1;
        int[] case3={0,0};
        case3[0]=x[0]+1;
        case3[1]=x[1];
        int[] case4={0,0};
        case4[0]=x[0]-1;
        case4[1]=x[1];



        for(int[] element: A.getArea())
        {


            if(Arrays.equals(case1,element)||Arrays.equals(case2,element)||Arrays.equals(case3,element)||Arrays.equals(case4,element))
            {
                neighbour=true;
                break;
            }

        }
        return neighbour;
    }
    public void Attack(int[] x, State A, State B) // A atakuje B
    {
        if(neighbourS(x,A)&&B!=null) {
            int a = A.getGold();
            int b = B.getGold();
///TUTAJ jest miejsce w którym można zaimplementować dowolną mechanikę wygrywania/przegrywania, na razie tylko złoto tutaj mamy
            if (a > b) {
                changeOccupation(x, B, A);

            }
        }
    }

    public boolean isFreeS(int[] x)//sprawdza, czy punkt x jest wolny, tj. nie należy do żadnego stanu
    {
        boolean free=true;
        State prop = new State();


        for(int[] e: prop.getArea())
        {
            if(Arrays.equals(x,e))
            {
                free = false;
            }

        }



        return free;
    }

    public State occupation (List<State> states, int[] x)// znajduje State, do którego należy punkt x
    {
        boolean found=false;
        for(State prop: states)
        {
            for(int[] element: prop.getArea())
            {
                if(Arrays.equals(element,x))
                {
                    found=true;
                    return prop;

                }
            }
            if(found==true)
            {
                break;
            }
        }
        return null;
    }

    public boolean belongsToState(State s, int[] x)//sprawdza, czy punkt x należy do danego State s
    {
        boolean belongs=false;
        for(int[] element: s.getArea())
        {
            if(Arrays.equals(element,x))
            {
                belongs=true;

                break;
            }
        }

        return belongs;
    }

    public void ExplorationTick(List<State> states)//wykonuje operację eksploracji dla każdego stanu w liście states
    {
        for(State S: states)
        {
            S.ExploringAction(states,getWidth(),getHeight());
        }
    }








////TYLKO DO TESTÓW
    public void OUTTEXTPOINTSCMD(State A) //metoda dla wiersza poleceń/kompilatora NIE UŻYWAĆ POZA TESTAMI
    {
        if(A.getArea()!=null)
        {
            int count1 = 0;
            Set<int[]> q1 = new HashSet<>();
            q1.addAll(A.getArea());
            for (int[] a : q1) {
                int[] bufor = a;
                int b = bufor[0];
                int c = bufor[1];
                count1++;
                System.out.print("point ("+b+".");
                System.out.println(c+")");


            }
            System.out.println(count1);
            q1.clear();
        }

    }

    public void CMDPOINTREADER(int[] x)
    {
        int b = x[0];
        int c = x[1];

        System.out.print("point ("+b+".");
        System.out.println(c+")");
    }
}

