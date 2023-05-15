package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Cywilizacja {
    public static void main(String[] args) throws InterruptedException {
        //próbowałem usilnie dodać jakoś mechanikę sprawdzania do kogo należy dany punkt
        //wewnątrz klas, ale niestety się nie dało :/// więc improwizuję w taki sposób

        List<State> stateList = new ArrayList<>();//ale widziałem że to normalne, że trzeba użyć tego typu listy
        Map map = new Map(10,10);             //więc może i jest git
        State Wro = new State(new int[]{0,0},10,100,100);
        State Wwa = new State(new int[]{4,4},100,100,100);
        State Krk = new State(new int[]{6,6},120, 100,100);
        stateList.add(Wro);
        stateList.add(Wwa);
        stateList.add(Krk);


//testy eksploracji

        TextGUI GUI = new TextGUI();
       for(int i=0;i<500;i++) //próby\
        {
            map.ExplorationTick(stateList);
            /*
           System.out.println("tick"+i);
            System.out.println("Wrocław");
            map.OUTTEXTPOINTSCMD(Wro);
           System.out.println("Warszawa");
            map.OUTTEXTPOINTSCMD(Wwa);
            System.out.println();
            */


            GUI.gui(Wro, Wwa,Krk,map);
            sleep(10);

            for(int n=0;n!=300;n++)
            {
                System.out.println();
            }



        }
        GUI.gui(Wro, Wwa,Krk,map);
        sleep(100);
    //    map.CMDPOINTREADER(G.GeneratePointOutOf(10,10,Wro));




    }

}
