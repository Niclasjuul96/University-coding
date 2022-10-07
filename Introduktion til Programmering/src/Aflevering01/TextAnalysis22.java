import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextAnalysis22 {



    public TextAnalysis22(String souceFileName , int i) throws FileNotFoundException {

        File text = new File(souceFileName);
       
        Scanner sc1= new Scanner(text);
        String data1 = "";
        String array1[] = {};

    
        while(sc1.hasNextLine()){
            data1 = data1 + "\n"+ sc1.nextLine();       
        }
        array1 = data1.split("[^a-zA -Z]+");

        System.out.println(array1.length);

        sc1.close();
    }

    public static void main(String[] args) throws FileNotFoundException {


        TextAnalysis22 ta22 = new TextAnalysis22("simpletext01.txt", 40);

        int i = ta22.frequency("es");
        //int i2 = ta22.wordcount();
        
        //System.out.println(i);
    }



    public int wordcount(String str) throws FileNotFoundException
    {

       
        // returns the number of words in the file

        int i = 0;
        return i;
    }

    public int frequency(String string)
    {

        

        // returns the number of occurrences
        // of " word " in the text (case - sensitive ).

        int i = string.hashCode();

        return i;
    }

    public boolean contains(String word1, String word2)
    {
        

        
        // returns true if word1 is directly followed by word2 somewhere
        // in the text (see above , not case - sensitive ).
        return true;
    }


}
