import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextAnalysis22 {

    public TextAnalysis22(String fileString, int i) throws FileNotFoundException {

        Path Currentpath = Paths.get("");
        String s = Currentpath.toAbsolutePath().toString();

        File simpletext01 = new File(s + "\\Introduktion til Programmering\\src\\Aflevering01\\simpletext01.txt");
        File simpletext02 = new File(s + "\\Introduktion til Programmering\\src\\Aflevering01\\simpletext02.txt");
        File TimeMachine = new File(s + "\\Introduktion til Programmering\\src\\Aflevering01\\Timemachine.txt");
        


        
        Scanner sc1= new Scanner(simpletext01);
        String data1 = "";

        Scanner sc2= new Scanner(simpletext02);
        String data2 = "";

        Scanner sc3= new Scanner(TimeMachine);
        String data3 = "";

        while(sc1.hasNextLine()){
            data1 = sc1.nextLine();
            Arrays[] array1 = new ArrayList<>();
            data1.split(" ");
            System.out.println(data1);
        }

        while(sc2.hasNextLine()){
            data2 = sc2.nextLine();
            System.out.println(data2);
        }

        while(sc3.hasNextLine()){
            data3 = sc3.nextLine();
            System.out.println(data3);
        }





        sc1.close();
        sc2.close();
        sc3.close();
    }

    public static void main(String[] args) throws FileNotFoundException {


        TextAnalysis22 ta22 = new TextAnalysis22("simpletext01", 40);

        int i = ta22.frequency("es");
        
        //System.out.println(i);
    }



    public int wordcount(String str) throws FileNotFoundException
    {

        Scanner sc = new Scanner(str);
        String data = "";
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
