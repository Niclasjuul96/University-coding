package Uge02;

public class Exercise3C {
    public static void main(String[] args) {
        
        for(int i = 0;i < 4; i++){
            int gentagelser = 9;
            int k = 9;
            for(int j = 0; j < 10;j++){
                for(int h = 0; h < gentagelser; h++){
                    System.out.print(k);
                }
                gentagelser-=1;
                k-=1;
            }
            System.out.println("");
        }
    }
}
