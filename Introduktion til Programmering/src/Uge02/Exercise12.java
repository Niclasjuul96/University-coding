package Uge02;

public class Exercise12 {

    public static void main(String[] args) {
        int tal1 = 0;
        int tal2 = 0;
        boolean increase;
        for(int i = 0;i < 6;i++){
            increase = false;
            tal2 = tal1;
            for(int j = 0;j < 6;j++){
                
                

                if(tal2 == 0 || increase  == true){
                    increase = true;
                    if(j != 6){
                        System.out.print(tal2 + " ");
                    }else{
                        System.out.print(tal2);
                    }
                    
                    tal2+=1;
                }else{
                    if(j != 6){
                        System.out.print(tal2 + " ");
                    }else{
                        System.out.print(tal2);
                    }
                    tal2-=1;
                }
                
            }
            tal1+=1;
            System.out.println();
        }
       
    }
    
}
