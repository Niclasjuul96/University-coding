import java.awt.*;

public class Birch extends Tree1 {

    //defining the growthRate variable
    public float growthRate = 0.5f;

    //making a grow function
    public void grow() {
        setSize(getSize() + growthRate);
    }

    //constructor for Birch trees
    public Birch(Point pos, double size) {
        this.setColor(Color.CYAN);
        this.setPosition(pos);
        this.setSize(size);
    }


}
