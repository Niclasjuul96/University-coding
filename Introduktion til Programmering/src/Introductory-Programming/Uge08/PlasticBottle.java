package Uge08;

public class PlasticBottle extends Bottle {

    String material;

    public PlasticBottle(int volume, String content, String material){
        super(volume, content);
        if(material.equals("PET")){
            this.material = material;
        }else{
            this.material = "OTHER";
        }
        
    }

    public String getMaterial() {
        return material;
    }

    public String toString(){
        String s = super.toString();
        s += material;
        return s;
    }
    
}
