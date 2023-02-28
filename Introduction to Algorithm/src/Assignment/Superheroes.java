package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Superheroes {
    public static void main(String[] args) {
        
        ArrayList<Integer> T = new ArrayList<Integer>(10);
        ArrayList<Integer> S = new ArrayList<Integer>(10);
        int CostofT = 0;


        Random rand = new Random();

        for(int i = 1; i < 11; i++){
            S.add(i*5);
        }

        for(int i = 0; i < S.size(); i++){
            System.out.println(S.get(i));
        }

        System.out.println("--------------------------------");
        for (int i = 0; i < 10; i++){
            int r = rand.nextInt(10);
            T.add(S.get(r));
             
        }
        Collections.sort(T);

        for(int i = 0; i < 6; i++){
            CostofT += T.get(i);
        }

        System.out.println("Cheapest 7 Superheroes for T: "+CostofT);
    }
}
