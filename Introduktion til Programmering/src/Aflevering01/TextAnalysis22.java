import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextAnalysis22 {

    //Laver fields, som skal bruges til vores program, for det meste variabler, som skal tilgås af andre funktioner.
    String array1[];
    int words = 0; 

    //Denne er vores hoved funktion, som bliver kaldt med navnet på textfilen samt hvor stor textfilen må max være. 
    public TextAnalysis22(String souceFileName , int maxNoOfWords ) throws FileNotFoundException{

        //her der initializer mine variabler, som jeg skal bruge senere. 
        File text = new File(souceFileName);
        array1 = new String[maxNoOfWords];
        String tempString = "";

        //Vi benytter os af util funktionen "scanner", som skal aflæse teksten. 
        Scanner sc1= new Scanner(text);

        //Her laver vi en whileløkke, som går ind og ser på om der er flere linjer tilbage i teksten. 
        //Det er her jeg bruger min tempstring, som placere alle ord fra tekstfilen ind i en lang string
        while(sc1.hasNextLine()) {
            tempString =  tempString + "\n" + sc1.nextLine();
        }

        sc1.close(); 
        //Her indsætter jeg alle de forskellige ord ind i mit array ved at bruge vores string splitter.
        array1 = tempString.split("[^a-zA-Z]+");

        //Her laver jeg en forloop som køres igennem og finde alle ord i vores array og optæller vores words variable. 
        for(int i = 0; i < array1.length; i++) {
            //Denne if sætning bruger vi således at vi tjekker om arrayet indeholder et null, da den er fyldt med null, 
            //da vi bruger maxNoOfwords for at angive det maximale antal ord, og derfor kun optæller hvis der er et ord i arrayet.
            if(array1[i] != null) {
                words++; 
            }
        }     
    }
    //Wordcounts tæller antal ord, som bliver optalt i tekst TextAnalysis22. 
    public int wordCount() {
        return words;
    }

    //frequency får en string som input og matcher det op med ord i arrayet. og derfor finder alle de ord man selv har indtastet.
    public int frequency(String word){
        int count = 0;
        for (int i = 0;i < array1.length;i++) {
            if(array1[i] != null) {
                if(array1[i].equals(word)) {
                    count++;   
                }
            }
        }    
        return count;
    }


    //Tjekker om 2 ord er ved siden af hinanden. 
    public boolean contains(String word1, String word2) {

        //først combinere vi disse 2 ord vi har fået som input og laver det til lowercase, da det ikke er case-sentitive.
        String combined = word1.toLowerCase()+word2.toLowerCase();

        //Derefter looper vi igennem hele vores array hvor på vi tjekker om det er null eller ej, derefter sammensætter vi de 2 ord og tjekker om det er det samme som vores inputs. 
        //Hvis det er tilfældet, så vil vi return true. 
        for(int i = 0; i < array1.length; i++) {
            if(i + 1 < array1.length){
                if(array1[i] != null && array1[i+1] != null){
                    String arrayString = array1[i].toLowerCase() + array1[i+1].toLowerCase();
                        if(combined.equals(arrayString)) {
                            return true;
                        }
                }
            }
        }            
        return false;
    }
}