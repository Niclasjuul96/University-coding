import java.awt.*;
public interface Tree {

    Color getColor();
    Point getPosition();
    double getSize();
    public abstract void grow();
    public void setSize(double size);
    public void setColor(Color color);

}
