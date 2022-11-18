package Uge02;

public class Exercise14 {
    public static void main(String[] args) {
        sumit();
    }

    private static void sumit() {
        int sum = 0;
        for(int i = 0; i < 200; i++){
            if(i % 7 == 0){
                sum+=i;
            }
        }
        System.out.println(sum);
    }
    
}
