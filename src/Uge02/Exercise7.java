package Uge02;

public class Exercise7 {
    public static void main(String[] args) {
		int tal1 = 10;
		int tal2 = 0;
		
		for(int i = 0; i <= 4; i++) {
			System.out.print(tal1 + " " + tal2 + " ");
			
			tal1--;
			tal2++;
		}
        System.out.println(tal1 + " " + tal2);
	}
    
}
