package Uge03;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int tal1;
        int tal2;
        String array[];

        String svar = input.nextLine();
        array = new String[5];

        array = svar.split(" ");
        
        tal1 = Integer.parseInt(array[0]);
        tal2 = Integer.parseInt(array[1]);

        input.close();
        
        int sum = tal1 + tal2;
        System.out.println(sum);
    }
}
