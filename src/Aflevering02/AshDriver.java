import java.text.DecimalFormat;

public class AshDriver {
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	private static int size = 7;
	private static double f = 0.8;


	public static void main(String[] args) {
		AshCloud ashCloud =new  AshCloud(size, f);
		double[][] world = ashCloud.runSimulation('N', 4);
        printWorld(world);
        world = ashCloud.runSimulation('W', 3);
        printWorld(world);
        
        
        // Put your own test here
	}
	
	// * prints the grid with with two-digit precision.
		private  static void printWorld(double[][] w) {
			System.out.println("--------------------");
			int size = w.length;
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
 					System.out.print(df.format(w[row][col]) + " ");
				}
				System.out.println();
			}
		}
		
/* The result should be
--------------------
0,00 0,00 0,00 0,00 0,00 0,00 0,00 
0,00 0,00 0,00 0,00 0,00 0,00 0,00 
0,00 0,00 0,00 0,00 0,00 0,00 0,00 
0,00 0,00 0,00 1,00 0,00 0,00 0,00 
0,00 0,00 0,10 0,80 0,10 0,00 0,00 
0,00 0,01 0,16 0,66 0,16 0,01 0,00 
0,00 0,00 0,00 0,00 0,00 0,00 0,00 
--------------------
0,00 0,00 0,00 0,00 0,00 0,00 0,00 
0,00 0,00 0,00 0,00 0,00 0,01 0,00 
0,00 0,00 0,00 0,00 0,10 0,16 0,00 
0,00 0,00 0,00 1,00 0,80 0,68 0,00 
0,00 0,00 0,00 0,00 0,10 0,25 0,00 
0,00 0,00 0,00 0,00 0,01 0,12 0,00 
0,00 0,00 0,00 0,00 0,00 0,00 0,00 

*/


}

