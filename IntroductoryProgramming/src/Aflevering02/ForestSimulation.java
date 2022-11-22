
import java.awt.Point;

public class ForestSimulation {
	
	    
	    private int steps; 
	    private int noOftrees; 
	    private  Tree[] trees; // Array contaiong the trees
	    
	    /**
	     * Constructor. Initializes the data structures and the graphics.
	     * @param noOftrees The number of trees.
	     * @param steps The number of steps, the simmulation should run.
	     */
	    public ForestSimulation(int noOftrees, int steps) {
	        this.noOftrees = noOftrees;
	        this.steps = steps;
	        init();
	    }

	    
	    /** 
	     *  Public method which performs the simulation.
	     */
	    
	    public void run() {
	        // During each execution of the loop one step of the
	        // simulation is performed.
	        for (int i = 0; i < steps; i++) {
	            // Draw an empty Forest.
	            drawEmptyForest();
	            // Loop over all trees
	            for (int j = 0; j < trees.length; j++) {
	                // Draw and then grow a trees 
	                drawTree(trees[j]);
	                trees[j].grow();
	               // check(trees[j]);
	                
	            }   
	         // show the new situation and pause 100 millseconds
	            StdDraw.show(100);
	        }       
	    }
	    
	    
	    

	    /**
		 * @param tree
		 */
		private void check(Tree tree) {
			if(tree instanceof Beech){
				System.out.println("Beech");
			} else if(tree instanceof Birch){
				System.out.println("Birch");
			} else if(tree instanceof Spruce){
				System.out.println("Spruce");
			} else if(tree instanceof MagicTree){
				System.out.println("MagicTree");
			} else {
				System.out.println("ERROR. Unknown tree type.");
			}
			
			
			
			
			
		}


		/**
	     * Draws a single Tree. The position and appearence are determined 
	     * by querying the Tree.
	     * @param Tree The Tree to be drawn.
	     */
	    private void drawTree(Tree tree) {
	        StdDraw.setPenColor(tree.getColor());
	        StdDraw.filledCircle(tree.getPosition().x, tree.getPosition().y, tree.getSize());      
	    }



	/**
	 *  Initializes the graphics and creates the trees.
	 */
	    private void init() {
	        StdDraw.setXscale(-1,ConstAndUtil.FORESTSIZE+1);
	        StdDraw.setYscale(-1,ConstAndUtil.FORESTSIZE+1);
	        StdDraw.setPenRadius(0.9/(ConstAndUtil.FORESTSIZE+1));
	        drawEmptyForest();
	        
	        createtrees();
	                
	    }

	    /**
	     *  Creates the trees and stores them in the array "trees".
	     *  Roughly 1/3 are beechs, spruces and birches. One
	     *  drunken driver is added.
	     */
	    private  void createtrees() {
	        // create an array of type Tree
	        trees = new Tree[noOftrees];
	        // fill the array
	        for (int i = 0; i < trees.length/3; i++) {
	            trees[i] = new Beech(ConstAndUtil.getLegalRandomPosition(),1.0);
	        }
	        for (int i = trees.length/3; i < 2*trees.length/3; i++) {
	            trees[i] = new Spruce(ConstAndUtil.getLegalRandomPosition(),1.0);
	        }
	        for (int i = 2*trees.length/3; i < trees.length-1; i++) {
	            trees[i] = new Birch(ConstAndUtil.getLegalRandomPosition(),2.0);
	        }
	        trees[trees.length-1] = new MagicTree(new Point(ConstAndUtil.FORESTSIZE/2,
	        		ConstAndUtil.FORESTSIZE/2),3.0);
	    }

	    /** Does what the name suggests
	     * 
	     */
	    private void drawEmptyForest() {
	        StdDraw.clear(StdDraw.GRAY);
	        StdDraw.setPenColor(StdDraw.WHITE);
	        StdDraw.filledSquare((ConstAndUtil.FORESTSIZE)/2.0, (ConstAndUtil.FORESTSIZE)/2.0, 
	                ConstAndUtil.FORESTSIZE/2.0);
	        
	    }

}
