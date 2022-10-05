import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextAnalysis22 {

    public TextAnalysis22(String fileString, int i) throws FileNotFoundException {

        Path Currentpath = Paths.get("");
        String s = Currentpath.toAbsolutePath().toString();

        File simpletext01 = new File(s + "\\Introduktion til Programmering\\src\\Aflevering01\\simpletext01.txt");
        File simpletext02 = new File(s + "\\Introduktion til Programmering\\src\\Aflevering01\\simpletext02.txt");
        File TimeMachine = new File(s + "\\Introduktion til Programmering\\src\\Aflevering01\\Timemachine.txt");
        


        //wordcount(simpletext01);
        Scanner sc = new Scanner(simpletext01);
        String data = "";

        while(sc.hasNextLine()){
            data = sc.nextLine();
            System.out.println(data);
        }

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
