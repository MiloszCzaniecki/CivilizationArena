package src;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//OSTROŻNIE Z UŻYWANIEM TEGO GUI, PO ZAPEŁNIENIU MAPY SIĘ BUGUJE I KOMPUTER MOŻE SIĘ SPALIĆ
public class TextGUI {

    public void gui (State A, State B, State C, Map map) {// Wyświetla GUI
        int[][] mapa = new int[map.getWidth() + 1][map.getHeight() + 1];
        for (int y = 0; y < map.getHeight(); y++)
        {
            for (int x = 0; x < map.getWidth(); x++) {
                mapa[x][y] = 0;
            }
        }
        addToMap(A,mapa,map,1);
        addToMap(B,mapa,map,2);
        addToMap(C,mapa,map,3);

        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                System.out.print(mapa[x][y]);
            }
            System.out.println();
        }



    }

    public void addToMap(State A, int[][] mapa, Map map, int symbol)// Dodaje obszar stanu A do mapy i oznacza go określonym symbolem
    {
        if (A.getArea() != null) {
            Set<int[]> bufor = new HashSet<>();
            bufor.addAll(A.getArea());


            for (int y = 0; y < map.getHeight(); y++) {
                for (int x = 0; x < map.getWidth(); x++) {

                    for (int[] c : bufor) {

                        int f = c[0];
                        int g = c[1];
                        if ((f == x) && (g == y)) {
                            mapa[x][y] = symbol;
                        }
                    }
                }
            }
        }


    }


    }


