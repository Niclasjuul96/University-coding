package Uge08;

public class Vessel {
    int volume;

    public int getVolume() {
        return volume;
    }

    public Vessel(int volume){
        this.volume = volume;
    }

    public String toString(){
        String s = "Volume: " + volume;
        return s;
    }
}
