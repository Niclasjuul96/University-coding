public class FizzBuzz {
    String str;
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100; i++) {
            System.out.println(Calculate(i));
            
        }

    }


    public static String Calculate(int i){
        if (i % 3 == 0 && i % 5 == 0){
            String str = "FizzBuzz";
            return str;
        } else if (i % 5 == 0){
            String str = "Buzz";
            return str;
        }else if(i % 3 == 0){
            String str = "Fizz";
            return str;
        }else{
            return i + "";
        }
    } 
}
