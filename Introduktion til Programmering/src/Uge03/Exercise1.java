package Uge03;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int tal1;
        int tal2;

        String svar = input.nextLine();
        
        tal1 = Character.getNumericValue(svar.charAt(0));
        tal2 = Character.getNumericValue(svar.charAt(2));

        input.close();
        
        int sum = tal1 + tal2;
        System.out.println(sum);
    }
}
