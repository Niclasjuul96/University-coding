import java.awt.*;

public class Spruce extends Tree1 {
    //defining the growthRate variable
    public float growthRate = 0.3f;

    //making a grow function
    public void grow() {
        setSize(getSize() + growthRate);
    }

    //making a constructor for Spruce trees
    public Spruce(Point pos, double size) {
        this.setColor(Color.GREEN);
        this.setPosition(pos);
        this.setSize(size);
    }

}
