import java.util.Scanner;



public class AccessControl {
	
	public static void main(String[] args) {
		
		String userName = "";
		String userPassword = "";

		boolean userCheck = false;
		Boolean passwordCheck = false;
		Scanner input = new Scanner(System.in);
		
		

		while(!userCheck){
			System.out.println("Please enter a non-empty username: ");
			userName = input.nextLine();
			if(userName != ""){
				userCheck = true;
			}		
		}
		
		while(!passwordCheck){
			System.out.println("Please insert a password: ");
			
			userPassword = input.nextLine();

			if(Password.checkPWD(userPassword)){

				System.out.println("Please repeat the password: ");

				
				if(input.nextLine().equals(userPassword)){
					passwordCheck = true;
				}
				
			}
		}
		System.out.println("*** User "+ userName + " is registered");
		
		
		


		input.close();
	}
}
