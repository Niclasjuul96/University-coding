package Uge08;

public class GlasBottle extends Bottle{
    String color;

    public String getColor() {
        return color;
    }

    public GlasBottle(int volume, String content, String color){
        super(volume, content);
        this.color = color;
    }

    public String toString(){
        String s = super.toString();
        s += "Color: " + color;
        return s;
    }

    
}
