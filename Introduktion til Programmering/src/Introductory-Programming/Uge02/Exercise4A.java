package Uge02;

public class Exercise4A {
    public static void main(String[] args) {
		
        loop1();
        }
    



 public static void loop1() {
     
        int count = 11, num1 = 1, num2 = 1;
        

        for (int i = 1; i <= count+1; ++i)
        {
            System.out.print(num1+" ");

            /* On each iteration, we are assigning second number
             * to the first number and assigning the sum of last two
             * numbers to the second number
             */
            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
        }
    }
}
