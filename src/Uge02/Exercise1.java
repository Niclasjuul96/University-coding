package Uge02;

public class Exercise1{
    public static void main(String[] args) {
        int i = 1;
        int multiplier = 3;

        for(int j = 0; j < 6; j++ ){
            System.out.println(i);
            i+=multiplier;
            multiplier+=2;
        }
    }
}