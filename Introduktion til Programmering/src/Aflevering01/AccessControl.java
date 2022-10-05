import java.util.Scanner;



public class AccessControl {
	
	public static void main(String[] args) {
		
		String userName = "";
		String userPassword = "";

		boolean login = false;
		boolean userCheck = false;
		boolean passwordCheck = false;
		
		
		while(true){
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
			
			

			while(!login){
				
				System.out.print("To logon enter Username: ");
				
				if(input.nextLine().equals(userName)){
					System.out.println("To logon enter Password: ");
					if(input.nextLine().equals(userPassword)){
						login = true;
					}
				}
			}
			
			System.out.println("*** User " + userName + " is logged on");

			System.out.println("You now have the following choices: \n 1 - Change password \n 2 - Log off \n 3 - Shut down");

			String str = input.nextLine();

			if(str.equals("1") || str.equals("2") || str.equals("3")){

				switch(str){
					case "1":
						System.out.println("Indtast din nuværende password: ");
						String inputPassword = input.nextLine();

						if(inputPassword.equals(userPassword)){
							
						}
						break;
					case "2":

						break;
					case "3":

						break;
					default:
				}
				
				
				
			}

			input.close();
		}

		
	}
}
