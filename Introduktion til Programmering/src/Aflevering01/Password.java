import java.util.Scanner;

public class Password {
	
	public static final int Password_Length = 8;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print(
				"1. Atleast 8 Charactors\n"
			  + "2. only alpha-numerical characters, i.e., a,. . . ,z,A,. . . ,Z,0,. . . ,9\n"
			  + "3. at least two letters \n"
			  + "4. at least two numbers \n"
			  + "5. at least one upper case \n"
			  + "6. at least one lower case \n");
		
		String s = input.nextLine();
		
		if(checkPWD(s)) {
			
			System.out.println("The Password you have entered is Valid " + s);		
		}else {
			System.out.println("The Password you have entered is invalid " + s );
		}
		
		
	}
	
	public static boolean checkPWD(String password) {
		
		if(password.length() < Password_Length) return false;
		
		int charcount = 0;
		int numcount = 0;
		int lowercount = 0;
		int uppercount = 0;
		
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			
			if(is_number(ch)) numcount++;
			else if(is_letter(ch)) {
				charcount++;
				if(is_lowercase(ch)) lowercount++;
			}
			else return false;
		}
		
		
		
		return true;
	}
	
	public static boolean is_letter(char ch) {
		
		ch = Character.toUpperCase(ch);
		return (ch >= 'A' && ch <= 'Z');
		
	}
	
	public static boolean is_number(char ch) {
		
		return(ch >= 0 && ch <= 9);
	}
	
	public static boolean is_lowercase(char ch) {
		return (ch >= 'a' && ch <= 'z');
	}
	
	public static boolean is_uppercase(char ch) {
		return (ch >= 'A' && ch <= 'Z');
	}
	
}
