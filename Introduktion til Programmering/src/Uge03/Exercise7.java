package Uge03;

import java.util.Scanner;

public class Exercise7{
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String array[];
        System.out.println("Please insert your full name");
        String name = sc1.nextLine();
        array = new String[10];
        array = name.split(" ");
        name = "";
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                name = array[i] + "," + name;
            }
        }
        sc1.close();

        System.out.println("Your name in reverse order is: " + name);
    }
}