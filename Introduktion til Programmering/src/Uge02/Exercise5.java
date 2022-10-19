package Uge02;

public class Exercise5 {
    public static void main(String[] args) {
		
		int gentagelse = 5;
		int g = 5;
		int talgen = 1;
		int tal = 1;
		
		for(int j = 0; j < gentagelse; j++) {
			
			for (int i = 0; i < g; i++) {
			
				System.out.print("-");
			}
			
			for(int k = 0; k < talgen; k++) {
				
				System.out.print(tal);
				
			}
			
			for (int i = 0; i < g; i++) {
				
				System.out.print("-");
			}
			
			g = g-1;
			talgen= talgen +2;
			tal = tal +2;
			System.out.println("");
		}
	}
    
}
