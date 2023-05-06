package src;

import java.util.ArrayList;
import java.util.List;

public class Cywilizacja {
    public static void main(String[] args)
    {
        //próbowałem usilnie dodać jakoś mechanikę sprawdzania do kogo należy dany punkt
        //wewnątrz klas, ale niestety się nie dało :/// więc improwizuję w taki sposób

        List<State> stateList = new ArrayList<>();//ale widziałem że to normalne, że trzeba użyć tego typu listy
        Map map = new Map(2,2);             //więc może i jest git
        State Wro = new State(new int[]{1,1},102,100,100);
        State Wwa = new State(new int[]{1,2},100,100,100);
        stateList.add(Wro);
        stateList.add(Wwa);
//test metody wyszukiwania państwa do którego należy punkt x
        System.out.println(map.belongsToState((map.occupation(stateList, new int[]{1,1})), new int[]{1,1}));

//testy metody Explore (dane państwo sprawdza czy x:należy do mapy, czy jest zajęty, czy przeciwnik ma mniej złota, a jeśli tak, atakuje
        Wro.Explore(new int[]{1,2},stateList);
        System.out.println(map.belongsToState(Wro, new int[]{1,2}));


    }
}
