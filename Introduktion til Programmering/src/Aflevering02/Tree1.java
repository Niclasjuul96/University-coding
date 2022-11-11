import java.awt.*;

public abstract class Tree1 implements Tree {
    //Defining different variables for all trees
    private Color color;
    private Point pos;
    private double size;





    public Point getPosition(){
    return this.pos;
    }

    public Color getColor(){
        return color;
    }
    public double getSize(){
        return size;
    }
    public void setColor(Color color){
        this.color=color;
    }
    public void setSize(double size){
        this.size=size;
        if (this.size < 0){this.size = 0;}
    }

    public void setPosition(Point p){
       this.pos=p;
           }
}
