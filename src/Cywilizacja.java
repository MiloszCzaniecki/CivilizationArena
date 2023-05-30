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
        map.generateBiomes();



//testy eksploracji

        TextGUI GUI = new TextGUI();
       for(int i=0;i<100;i++) //próby\
       {
           map.ExplorationTick(stateList);
           map.KResourcesTick(stateList);
            /*
           System.out.println("tick"+i);
            System.out.println("Wrocław");
            map.OUTTEXTPOINTSCMD(Wro);
           System.out.println("Warszawa");
            map.OUTTEXTPOINTSCMD(Wwa);
            System.out.println();
            */

           map.CMDINTMAPREADER(map.CMDBIOMEMAP());
           System.out.println();

           GUI.gui(Wro, Wwa, Krk, map);
           sleep(1000);
            System.out.println(Wro.getResources());
           System.out.println(Wwa.getResources());
           System.out.println(Krk.getResources());
           System.out.println();
          // for (int n = 0; n != 300; n++) {
          //     System.out.println();
         //  }
       }


        }







        //test biomu







    }





