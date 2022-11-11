
import java.awt.Point;
import java.util.Random;



/** Convenience class. 
 * Defines some (global) constants and static utility methods.
 * @author Paul Fischer.
 *
 */

public class ConstAndUtil {
	public static final int FORESTSIZE = 1000;
	
	private static Random rand = new Random();
	
	
    /** Checks whether the position is in the forest.
     * @param x X-ccordinate of the position to be checked.
     * @param y Y-ccordinate of the position to be checked.
     * @return true if the position is in the forest.
     * This method can be changed to only allow another set of positions.
     */
	public static boolean positionOK(double x, double y){
		return
		((0 <= x) && (x <= FORESTSIZE) && (0 <= y) && (y <= FORESTSIZE));
		
	}
	
	/**
	 * Checks whether the position is in the forest.
	 * @param p The point defining the position.
	 * @return true if the position is in the forest.
	 */
	public static boolean positionOK(Point p){
		return(positionOK(p.x,p.y));
	}
	
	/** 

    /**
     * @return a Point in the forest.
     */
	public static Point getLegalRandomPosition() {
		int x,y;
		do{
			x = rand.nextInt(FORESTSIZE);
			y = rand.nextInt(FORESTSIZE);
		}while(!positionOK(x,y));
		return new Point(x,y);
	}
	
    /**
     * Moves a position back into the forest. Does nothing if position is ok.
     * @param position The position to be checked. 
     */
    public static void putInForest(Point position) {
        if(position.x < 0) {position.x = 1;}
        if(position.x > FORESTSIZE) {position.x = FORESTSIZE-1 ;}
        if(position.y < 0) {position.y = 1;}
        if(position.y > FORESTSIZE) {position.y = FORESTSIZE-1 ;}
    }
    
    
    public static int getRandomIntBetween(int low, int high){
    	return low + rand.nextInt(high-low+1);
    }
	
				


}
