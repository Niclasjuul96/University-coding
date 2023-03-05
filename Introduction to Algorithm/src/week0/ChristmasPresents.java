import java.util.Scanner;

public class ChristmasPresents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        int Anna = scanner.nextInt();
        int Laura = scanner.nextInt();
        int Oscar = scanner.nextInt();
        scanner.close();
        

        int message = 0;

        //Anna
        if(Anna < Laura && Anna < Oscar){
            System.out.println("Anna");
            message++;
        }

        //Laura
        if(Laura < Anna){
            System.out.println("Laura");
            message++;
        }

        //Oscar
        if(Oscar < Anna || Oscar < Laura){
            System.out.println("Oscar");
            message++;
        }

        if(message == 0){
            System.out.println("NONE");
        }
    }
}
