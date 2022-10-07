import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextAnalysis22 {

    String array1[];
    int words = 0; 

    public TextAnalysis22(String souceFileName , int maxNoOfWords ) throws FileNotFoundException {

        File text = new File(souceFileName);

        array1 = new String[maxNoOfWords];
       
        Scanner sc1= new Scanner(text);
    
        while(sc1.hasNextLine()){  
            String[] line = sc1.nextLine().split("[^a-zA-Z]+");   
            System.out.println(line.length);
            for(int i = 0; i < line.length; i++){
                if(line[i] != null){
                    this.array1[words + i] = line[i];
                    words += 1;
                }
            }
            line = null;
        }
        sc1.close();
    }

    public static void main(String[] args) throws FileNotFoundException {


        TextAnalysis22 ta22 = new TextAnalysis22("simpletext01.txt", 40);

        int n = ta22.frequency("es");
        System.out.println(n);
        n = ta22.frequency("ES");
        System.out.println(n);
        int i = ta22.wordcount();
        System.out.println(i);
    }



    public int wordcount() throws FileNotFoundException
    {       
        // returns the number of words in the file
        return words;
    }

    public int frequency(String word)
    {
        // returns the number of occurrences
        // of " word " in the text (case - sensitive ).

        int count = 0;

        for (int i = 0;i < array1.length;i++) {
            if(array1[i] != null){
                if(array1[i].equals(word)){
                count++;
                }
            }
            
        }
        return count;
    }

    public boolean contains(String word1, String word2)
    {
        
        
        // returns true if word1 is directly followed by word2 somewhere
        // in the text (see above , not case - sensitive ).
        return true;
    }


}
