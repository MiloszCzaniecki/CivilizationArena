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



        Map map = new Map(10,10);             //więc może i jest git
        map.newState();
        map.newState();
        map.generateBiomes();



//testy eksploracji


        map.CMDINTMAPREADER(map.CMDBIOMEMAP());
       for(int i=0;i<500;i++) //próby\
       {
           map.ExplorationTick();
           map.KResourcesTick();
            /*
           System.out.println("tick"+i);
            System.out.println("Wrocław");
            map.OUTTEXTPOINTSCMD(Wro);
           System.out.println("Warszawa");
            map.OUTTEXTPOINTSCMD(Wwa);
            System.out.println();
            */


           System.out.println();

           map.CMDINTMAPREADER(map.CMDSTATEMAP());
           sleep(10);

           System.out.println();
          // for (int n = 0; n != 300; n++) {
          //     System.out.println();
         //  }
       }


        }







        //test biomu







    }





