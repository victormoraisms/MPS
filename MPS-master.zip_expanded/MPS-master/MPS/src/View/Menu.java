package View;

import java.util.Scanner;

import Controller.UserController;

public class Menu {

	public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        
        UserController usr = new UserController();
        usr.initializeList();

        // print menu

        
 		System.out.println("1. Add User" + "\n" +
						   "2. List all users" + "\n" +
				           "3. List specific user" + "\n" +
						   "4. Delete specific user");

        System.out.println("0. Quit");

        // handle user commands

        boolean quit = false;

        int menuItem;

        do {

              System.out.print("Choose menu item: ");

              menuItem = in.nextInt();

              switch (menuItem) {

              case 1:
            	  
            	  	String senha = null;
            	  	String login = null;

                    System.out.println("Add user");
                    
                    do{
                    	System.out.println("Login:");
                    	
                        login = in.nextLine();
                        
                    }while(login.isEmpty());
                    
                    do{
                    	System.out.println("Senha:");
                    	
                        senha = in.nextLine();
                    }while(senha.isEmpty());
                    
                    usr.add(login, senha);

                    break;

              case 2:

                    System.out.println("List all users");

                    // do something...

                    break;

              case 3:

                    System.out.println("List especific user");

                    // do something...

                    break;

              case 4:

                    System.out.println("Delet specific user");

                    String loginDel = null;
                    
                    do{
                    	System.out.println("Login:");
                    	
                        loginDel = in.nextLine();
                        
                    }while(loginDel.isEmpty());
                    
                    usr.del(loginDel);

                    break;

              case 0:

                    quit = true;

                    break;

              default:

                    System.out.println("Invalid choice.");

              }

        } while (!quit);

        System.out.println("Bye-bye!");

  }
	
}
