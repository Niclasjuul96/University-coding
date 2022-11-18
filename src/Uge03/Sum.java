package Uge03;

import java.util.Scanner;

/**
 * @author Paul Fischer
 *
 */
public class Sum {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Input start value");
        int start = scanner.nextInt();
	    System.out.println("Input end value");
        int end = scanner.nextInt();
        int sum = computeSum(start,end);
        System.out.println("Sum is of integers from "+start+" to "+
        end+" is "+sum);
        scanner.close();
	}
    
    public static int computeSum(int start, int end){
        int sum = 0;
        
        for(int i = start; i <= end; i++){
            sum += i;
        }

        return sum;
    }
}
