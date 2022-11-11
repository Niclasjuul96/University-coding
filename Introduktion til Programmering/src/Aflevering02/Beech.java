import java.awt.*;

public class Beech extends Tree1 {
    // defining the growthRate
    public float growthRate = 1f;

    //making the grow function
    public void grow() {
        setSize(getSize() + growthRate);
    }

    //Constructor for Beech trees
    public Beech(Point pos, double size) {
        this.setColor(Color.MAGENTA);
        this.setPosition(pos);
        this.setSize(size);
    }

}
