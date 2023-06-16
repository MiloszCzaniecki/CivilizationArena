package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Cywilizacja {
    public static void main(String[] args) throws InterruptedException {



        Map map = new Map(10,10);
        map.generateBiomes();
        map.generateStates(4);


        System.out.println("MAPA BIOMÓW");
        map.CMDINTMAPREADER(map.CMDBIOMEMAP());
        sleep(2000);
       for(int i=0;i<900;i++) //próby\
       {
           map.ExplorationTick();
           map.KResourcesTick();



           System.out.println();
            if(i%10==0)
            {
                map.CMDINTMAPREADER(map.CMDSTATEMAP());
                sleep(100);

            }


           System.out.println();
           for (int n = 0; n != 50; n++) {
              System.out.println();
          }
       }
       for(State prop: map.getStates())
       {
           System.out.println(prop.getID()+" "+prop.getResources()+" "+prop.getGold());
       }


        }

    }





