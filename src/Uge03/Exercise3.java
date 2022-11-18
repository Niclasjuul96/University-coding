package Uge03;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        int i = Integer.parseInt(sc1.nextLine());

        sc1.close();

        printNumbers(i);
    }
    
    public static int printNumbers(int max){

        for(int i = 1;i <= max; i++){
            System.out.print("[" + i + "]");
        }
        System.out.println();


        return 0;
    }
}
