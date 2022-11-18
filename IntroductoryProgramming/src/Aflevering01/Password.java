

import java.util.Scanner;

public class Password {
	
	//laver en field som bestemmer længden af et password mindst må indeholde.
	public static final int Password_Length = 8;
	
	public static void main(String[] args) {
		//Laver en scanner for at registere mine inputs.
		Scanner input = new Scanner(System.in);

		//Printer reglerne for passworded
		System.out.print(
				"1. Atleast 8 Charactors\n"
			  + "2. only alpha-numerical characters, i.e., a,. . . ,z,A,. . . ,Z,0,. . . ,9\n"
			  + "3. at least two letters \n"
			  + "4. at least two numbers \n"
			  + "5. at least one upper case \n"
			  + "6. at least one lower case \n");
		
		//Gemmer det indtastede i en string.
		String s = input.nextLine();

		//Checker om passworded er gyldigt.
		if(checkPWD(s)) {
			
			System.out.println("The Password you have entered is Valid " + s);		
		}else {
			System.out.println("The Password you have entered is invalid " + s );
		}
		//afslutter min scanner.
		input.close();
	}
	

	//Laver min checkPWD funktion
	public static boolean checkPWD(String password) {
		
		//Sørger for at Password er langt nok, her bruger vi den variabel vi lavede i toppen. 
		if(password.length() < Password_Length) return false;
		
		//Her laver vi fields som vi bruger senere til at tælle alle reglerne hvor meget der er forekommet.

		int charcount = 0;
		int numcount = 0;
		int lowercount = 0;
		int uppercount = 0;

		//Her laver jeg en forloop som gøre igennem og checker alle reglerne igennem og tæller op i vores integers.
		for (int i = 0; i < password.length(); i++) {
			//her finder vi den nuværende position i passworded og laver til en char, som vi bruger til at kalde vores andre funktioner.
			char ch = password.charAt(i);
			
			if(is_number(ch)) {
				numcount++;
			}else if(is_letter(ch)) {
				charcount++;
				if(is_lowercase(ch)) {
					lowercount++;
				}else{
					uppercount++;
				}
			}else{
				return false;
			}
		}
		
		//her laver jeg et check at alle de forskellige requirements er sat, hvis ikke så returner den false.
		if(charcount < 2 ) return false;
		if(numcount < 2) return false;
		if(lowercount < 1) return false;
		if(uppercount < 1) return false;
		
		return true;
	}
	
	//Her laver vi en funktion, som checker om passworded indenholder et bogstav.
	public static boolean is_letter(char ch) {
		
		ch = Character.toUpperCase(ch);
		return (ch >= 'A' && ch <= 'Z');
		
	}
	
	//Her laver vi en funktion, som checker om passworded indenholder et nummer. 
	public static boolean is_number(char ch) {

		int i = Character.getNumericValue(ch);

		return(i >= 0 && i <= 9);
	}
	
	//Her laver vi en funktion, som checker om passworded indenholder lowercase bogstav
	public static boolean is_lowercase(char ch) {
		return (ch >= 'a' && ch <= 'z');
	}
	
	//Her laver vi en funktion, som checker om passworded indenholder uppercase 
	public static boolean is_uppercase(char ch) {
		return (ch >= 'A' && ch <= 'Z');
	}
	
}
