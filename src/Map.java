package src;

import java.util.*;

public class Map {
    private static int width;
    private static int height;
    private static int quantity = 0;
    private static List<Biome> Biomes = new ArrayList<>();
    private static List<State> States = new ArrayList<>();
    private static List<Fortress> Forts = new ArrayList<>();


    public Map(int w, int h) {
        width = w;
        height = h;
        quantity++;
    }

    public Map() {


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

    public boolean belongsToMap(int[] point) {
        boolean belongs = false;
        int w = getWidth();
        int h = getHeight();
        for (int x = 0; x < w + 1; x++) {
            for (int y = 0; y < h + 1; y++) {
                int[] point1 = {x, y};
                if (Arrays.equals(point, point1)) {
                    belongs = true;
                }

            }
        }
        return belongs;
    }

    public void changeOccupation(int[] x, State A, State B)//z A do B
    {
        if (belongsToMap(x) == true) {
            A.lose(x);
            B.annex(x);
        }



    }

    public boolean neighbourS(int[] x, State A) {
        boolean neighbour = false;
        int[] case1 = {0, 0};
        case1[0] = x[0];
        case1[1] = x[1] + 1;
        int[] case2 = {0, 0};
        case2[0] = x[0];
        case2[1] = x[1] - 1;
        int[] case3 = {0, 0};
        case3[0] = x[0] + 1;
        case3[1] = x[1];
        int[] case4 = {0, 0};
        case4[0] = x[0] - 1;
        case4[1] = x[1];


        for (int[] element : A.getArea()) {


            if (Arrays.equals(case1, element) || Arrays.equals(case2, element) || Arrays.equals(case3, element) || Arrays.equals(case4, element)) {
                neighbour = true;
                break;
            }

        }
        return neighbour;
    }

    public void Attack(int[] x, State A, State B) // A atakuje B
    {
        if (neighbourS(x, A) && B != null) {
            int a = A.getResources();
            int b = B.getResources();
///TUTAJ jest miejsce w którym można zaimplementować dowolną mechanikę wygrywania/przegrywania, na razie tylko złoto tutaj mamy
            if (a > b) {
                changeOccupation(x, B, A);

            }
        }
    }

    public boolean isFreeS(int[] x) {
        boolean free = true;
        State prop = new State();


        for (int[] e : prop.getArea()) {
            if (Arrays.equals(x, e)) {
                free = false;
            }

        }


        return free;
    }

    public State occupation(List<State> states, int[] x) {
        boolean found = false;
        for (State prop : states) {
            for (int[] element : prop.getArea()) {
                if (Arrays.equals(element, x)) {
                    found = true;
                    return prop;

                }
            }
            if (found == true) {
                break;
            }
        }
        return null;
    }

    public boolean belongsToState(State s, int[] x) {
        boolean belongs = false;
        for (int[] element : s.getArea()) {
            if (Arrays.equals(element, x)) {
                belongs = true;

                break;
            }
        }

        return belongs;
    }


    public void addBiome(int[] a, int typ) {
        Biomes.add(new Biome(a, typ));
    }

    public void generateBiomes() {
        Generator Gen = new Generator();

        int q = Gen.GenerateToPlus(getWidth()) / 2 + 1;
        for (int i = 0; i < q; i++) {
            addBiome(Gen.GeneratePoint(getWidth(), getHeight()), Gen.GenerateToPlus(2));
        }

        int bq = Biomes.size() - 1;

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                Biomes.get(Gen.GenerateToPlus(bq)).addArea(new int[]{x, y});
            }
        }

    }

    public List<Biome> getBiomes() {
        return Biomes;
    }

    public int resourcesK(State s) {
        int k = 0;

        for (int[] punkt : s.getArea()) {
            for (Biome b : getBiomes()) {
                for (int[] wunkt : b.getArea()) {
                    int[] c = punkt;

                    if (Arrays.equals(c, wunkt)) {
                        k = k + b.getIntResources();
                    }


                }
            }


        }


        return k;
    }

    public int whichBiome(int[] x) {
        int k = -1;


        for (Biome b : getBiomes()) {
            for (int[] wunkt : b.getArea()) {
                int[] c = x;

                if (Arrays.equals(c, wunkt)) {
                    k = b.getIntResources();
                }


            }


        }
        return k;
    }

        public void resourcesRenewK (State s)
        {
            s.addResources(resourcesK(s));
        }


        public void newState()
        {
            Generator gen = new Generator();
            State prop = new State();
            int[] point = gen.GeneratePointOutOf(getWidth(),getHeight(),prop);
            State state = new State(point,gen.GenerateToPlus(100), gen.GenerateToPlus(100), gen.GenerateToPlus(100) );

            States.add(state);
            Forts.add(state.newFortress(point));
        }

        public void outKResourcesTick (List < State > states)
        {
            for (State s : states) {
                resourcesRenewK(s);
            }
        }

    public void KResourcesTick ()
    {
        for (State s : States) {
            resourcesRenewK(s);
        }
    }



        public void outExplorationTick (List < State > states)
        {
            for (State S : states) {
                S.ExploringAction(states, getWidth(), getHeight());
            }
        }

    public void ExplorationTick ()
    {
        for (State S : States) {
            S.ExploringAction(States, getWidth(), getHeight());

        }
        for(boolean done1=true;done1==false;) {
            for (State S : States) {
                for (boolean done = true; done == false; ) {
                    for (Fortress fort : Forts) {
                        if (fort.getState() == S && S.getArea().contains(fort.getArea()) == false) {
                            S.fortDestruct();
                            Forts.remove(fort);
                            done = false;
                            break;
                        }
                    }
                }

                if (S.getFortQ() == 0) {
                    States.remove(S);
                    done1=false;
                    break;
                }
            }
        }
    }

////TYLKO DO TESTÓW
        public void OUTTEXTPOINTSCMD (State A) //metoda dla wiersza poleceń/kompilatora NIE UŻYWAĆ POZA TESTAMI
        {
            if (A.getArea() != null) {
                int count1 = 0;
                Set<int[]> q1 = new HashSet<>();
                q1.addAll(A.getArea());
                for (int[] a : q1) {
                    int[] bufor = a;
                    int b = bufor[0];
                    int c = bufor[1];
                    count1++;
                    System.out.print("point (" + b + ".");
                    System.out.println(c + ")");


                }
                System.out.println(count1);
                q1.clear();
            }

        }

        public void CMDPOINTREADER ( int[] x)
        {
            int b = x[0];
            int c = x[1];

            System.out.print("point (" + b + ".");
            System.out.println(c + ")");
        }

        public void CMDBIOMELIST ()
        {
            for (Biome prop : getBiomes()) {
                System.out.println(prop.getType());
            }

        }

        public int[][] CMDBIOMEMAP ()
        {
            int[][] mapa = new int[getWidth() + 1][getHeight() + 1];



            for(int y=0;y<getHeight();y++)
            {
                for(int x=0;x<getWidth();x++)
                {
                  mapa[x][y] = whichBiome(new int[]{x,y});

                }
            }


            return mapa;
        }

        public void CMDINTMAPREADER(int[][] mapa)
        {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    System.out.print(mapa[x][y]);
                }
                System.out.println();
            }
        }

        public int[][] CMDSTATEMAP()
        {
            int[][] mapa = new int[getWidth() + 1][getHeight() + 1];



            for(int y=0;y<getHeight();y++)
            {
                for(int x=0;x<getWidth();x++)
                {
                    if(occupation(States, new int[]{x, y})==null)
                    {
                        mapa[x][y] =0;
                    }
                    else {
                        mapa[x][y] = occupation(States, new int[]{x, y}).getID();
                    }

                }
            }


            return mapa;
        }
    }


