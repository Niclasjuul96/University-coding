import java.util.Scanner;



public class AccessControl {
	
	public static void main(String[] args) {

		//Laver mine fields, som jeg skal benytte i denne accesscontol program.
		String userName = "";
		String userPassword = "";

		boolean login = false;
		boolean userCheck = false;
		boolean passwordCheck = false;
		Scanner input = new Scanner(System.in);
		
		//her laver vi en while som altid køre mens programmet er tændt. 
		while(true)
		{
			
			//Laver en while løkke der vil køre så længe userCheck er false, som betyder der ikke er oprettet et username endnu. 
			while(!userCheck)
			{
				System.out.print("Please enter a non-empty username: ");
				System.out.println("");
				userName = input.nextLine();
				//benytter sit input til at checke om det er tomt, og ikke indenholder et mellemrum.
				if(!userName.isEmpty() && !userName.contains(" "))
				{
					userCheck = true;
				}		
			}
			
			//Laver en while løkke der vil køre så længe passwordcheck er false, som betyder der ikke er oprettet et password endnu. 
			while(!passwordCheck)
			{
				System.out.print("Please enter a password	: ");
				System.out.println("");
				
				userPassword = input.nextLine();

				//checker om den indtastede password er godkendt ved at kalde checkPWD funktionen i Password.java filen.
				if(Password.checkPWD(userPassword))
				{

					System.out.print("Please repeat the password : ");
					System.out.println("");

					//checker om det gentagende password matcher det overstående password. 
					if(input.nextLine().equals(userPassword))
					{
						passwordCheck = true;
						System.out.println("*** User "+ userName + " is registered.");
					}
					
				}
			}
			
			
			
			//Så længe vi ikke er Logget ind 
			while(!login)
			{
				
				System.out.print("To logon enter username: ");
				System.out.println("");
				
				//Checker om det indtastede username passer med det registeret username.
				if(input.nextLine().equals(userName))
				{
					//while løkke der køre indtil det rigtige password er indtastet. 
					while(true){
						System.out.print("To logon enter password: ");
						System.out.println("");
						if(input.nextLine().equals(userPassword))
						{
							login = true;
							System.out.println("*** User " + userName + " is Logged on.");
							break;
						}
					}
					
				}
			}
			
			
			//Denne while køre sålænge vi er logget ind og derefter får nogle valgmuligher.
			while(login)
			{

			
				System.out.println("You now have the following choices: \n 1 - Change Password \n 2 - Log off \n 3 - Shut down \nPlease select: ");

				String str = input.nextLine();

				//checker om det indtasted indenholder 1,2 eller 3. 

				if(str.equals("1") || str.equals("2") || str.equals("3"))
				{
					//laver en switchcase der håndtere de forskellige valgmuligheder.
					switch(str)
					{
						case "1":
							//While der køre indtil man har indtastet et password som bliver accepteret af checkPWD funktionen.
							String inputPassword = "";
							while(!Password.checkPWD(inputPassword)){
								System.out.print("Please enter a password	: ");
								inputPassword = input.nextLine();
								System.out.println("");
								
							}
							//når vi får checkPWD funktionen til at return true, vil vi derefter gå ind og spørge efter at gentage passworded. 
							if(Password.checkPWD(inputPassword))
							{
								System.out.print("Please repeat the password : ");
								String repeatpassword = input.nextLine();
								System.out.println("");

								//Hvis den matcher så bliver passworded ændret. 
								if(inputPassword.equals(repeatpassword))
								{
									userPassword = inputPassword;
									System.out.println("*** Password changed for user " + userName);
								}
								else
								{
									System.out.println("The passwords does not match");
								}
							}
							break;
						case "2":
							//Logger brugeren ud. 
							System.out.println("*** User "+userName+" is logged off");
							login = false;
							break;
						case "3":
							//Lukker programmet.
							login = false;
							System.out.println("*** User " + userName +  " is logged off");
							System.out.println("*** System shutting down.");
							input.close();
							System.exit(0);
							break;
						default:
					}
					
					
					
				}
				continue;	
			}
			
			
		}

		
	}
}
