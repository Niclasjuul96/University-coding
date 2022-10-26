package Uge08;

public class Bottle extends Vessel {
    String content;

    public String getContent() {
        return content;
    }

    public Bottle(int volume, String content){
        super(volume);
        this.content = content;

    }

    public String toString(){
        String s = super.toString();
        s += "Content: " + content;
        return s;
    }
}
