package Uge03;

import java.awt.Point;

public class swapPoint {
    public static void main(String[] args) {
        Point p1 = new Point(5,2);
        Point p2 = new Point(-3,6);
        swapPoints(p1, p2);
        System.out.println("(" + p1.x + ", " + p1.y + ")");
        System.out.println("(" + p2.x + ", " + p2.y + ")");
    }

    public static void swapPoints(Point q1, Point q2){
        int temp = q1.x;
        q1.x = q2.x;
        q2.x = temp;

        temp = q1.y;
        q1.y = q2.y;
        q2.y = temp;
    }
    
}
