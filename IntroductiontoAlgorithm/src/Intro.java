import java.util.Scanner;

public class intro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        int input = scanner.nextInt();
        int input2 = scanner.nextInt();

        int i = input+input2;

        System.out.println(i); // Print result using System.out.println()
        scanner.close();
    }
}