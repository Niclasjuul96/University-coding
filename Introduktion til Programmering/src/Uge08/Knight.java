package Uge08;

import java.awt.Point;
import java.lang.Math;

public class Knight extends Point{
    
    
    public Knight(int x, int y){
        super(x,y);
    }

    

    public void translate(int dx, int dy){
        if((Math.abs(dx) == 2 && Math.abs(dy) == 1 )|| (Math.abs(dx) == 1 && Math.abs(dy) == 2)){
            super.translate(dx, dy);
        }
    }

}
