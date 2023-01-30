import java.util.Random;

class test{

    public static void main(String[] args) {
        Random terning = new Random();

        for(int i = 0; i <100; i++) {
            System.out.println(terning.nextInt(6)+terning.nextInt(6)+2);
        }

    }



}

