package Assignment;

import java.util.ArrayList;
import java.util.Random;

public class Superheroes {
    public static void main(String[] args) {
        
        ArrayList<Integer> T = new ArrayList<Integer>(6);
        ArrayList<Integer> S = new ArrayList<Integer>(10);

        Random rand = new Random();

        for(int i = 0; i < 10; i++){
            S.add(rand.nextInt(100));
        }

        for(int i = 0; i < S.size(); i++){
            System.out.println(S.get(i));
        }

        for(int i = 0; i < 6; i++){
            T.add(S.get(rand.nextInt(10)));
        }

        System.out.println("done Random generation");

        for(int i = 0; i < T.size(); i++){
            System.out.println(T.get(i));
        }

    }
}
