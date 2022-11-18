import java.awt.*;

public class MagicTree extends Tree1 {

    //defining the growthRate variable
    float growthRate;
    int stepsSinceLastMove=0;

    //making a grow function
    public void grow() {
        growthRate = ConstAndUtil.getRandomIntBetween(-1, 2);
        setSize(getSize() + growthRate);

        stepsSinceLastMove++;
        if(stepsSinceLastMove>10){
            setPosition(ConstAndUtil.getLegalRandomPosition());
            stepsSinceLastMove =0;
        }



    }

    //making a constructor for Spruce trees
    public MagicTree(Point pos, double size) {
        this.setColor(Color.ORANGE);
        this.setPosition(pos);
        this.setSize(size);
    }


}
