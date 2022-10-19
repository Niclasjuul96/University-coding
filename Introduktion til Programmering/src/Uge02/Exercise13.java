package Uge02;

public class Exercise13 {
    public static void main(String[] args) {
        int k;

        for(int i = 0; i < 8; i++){
            k = 3 + 2*i;
            if(i != 7){
                System.out.print(k+ " ");
            }else{
                System.out.print(k);
            }
            
        }
        System.out.println();
        for(int i = 3; i < 18; i=i+2){
            if(i!= 17){
                System.out.print(i+" ");
            }else{
                System.out.print(i);
            }
            
        }



    }
    
}
