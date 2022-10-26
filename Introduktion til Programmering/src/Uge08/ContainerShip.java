package Uge08;

public class ContainerShip extends Ship {
    
    private int teu;

    public int getTeu() {
        return teu;
    }

    public String toString(){
        return super.toString()+" container carrier with "+teu+" TEU";
    }
}
