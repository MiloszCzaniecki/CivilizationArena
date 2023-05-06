package src;

import java.util.Random;

public class Generator {

    public int GenerateToPlus(int X)
    {
        int x;
        Random gen = new Random();
        x=(gen.nextInt())%(X+1);
        if(x<0)
        {
            x=-x;
        }
        return x;
    }

    public int[] GeneratePoint(int X, int Y)
    {
        int[] punkt = {GenerateToPlus(X),GenerateToPlus(Y)};

        return punkt;
    }
}
