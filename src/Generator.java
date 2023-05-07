package src;

import java.util.Random;

public class Generator {

    public int GenerateToPlus(int X)//generuje od zera do X
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

    public int[] GeneratePoint(int X, int Y)//generuje punkt [x,y] gdzie x<=X y<=Y
    {
        int[] punkt = {GenerateToPlus(X),GenerateToPlus(Y)};

        return punkt;
    }

    public int[] GeneratePointOutOf(int X, int Y, State in)
    {
        boolean out = false;
        int[] point = {0,0};
        int i=0;
        while(out==false||i<=X*Y)
        {
         point= GeneratePoint(X, Y);
         i++;
         if(in.belongsToState(point)==false)
         {
             out=true;
         }
        }

        if(out==false)
        {
            point= new int[]{-1, -1};
        }
        return point;
    }
}
