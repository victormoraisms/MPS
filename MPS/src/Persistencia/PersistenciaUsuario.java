package Persistencia;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import Model.User;
import util.InfraException;

public class PersistenciaUsuario {
	
	public void init(HashMap<String, String> userList) throws IOException, InfraException, ClassNotFoundException {
		
		
		File tempFile = new File("D:\\Study\\users.ser");
		boolean exists = tempFile.exists();
		
		if(exists) {
		
		FileInputStream fileIn = new FileInputStream("D:\\Study\\users.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        
        try {
        	userList = (HashMap<String, String>) in.readObject();
 
        }catch (IOException i) {
	    	  
	    	  throw new InfraException("Falha ao carregar lista de usuarios");

	      }finally {
				 
				 in.close();
		         fileIn.close();
			}
        
        }
		
	}
	
	public void saveUser(HashMap<String, String> user) throws IOException, InfraException{
		
		//user.put(login, senha);
		
		FileOutputStream fileOut =
		         new FileOutputStream("D:\\Study\\users.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
		try {
	         
	         out.writeObject(user);
	         
	         
	      }catch (IOException i) {
	    	  
	    	  throw new InfraException("Falha ao salvar lista de usuarios");

	      }finally {
				 
				 out.close();
		         fileOut.close();
			}
		
	}
	
	public void deleteUser(String login) throws IOException, InfraException, ClassNotFoundException {
		
		HashMap<String, String> userList = new HashMap<String, String>();
		
		FileInputStream fileIn = new FileInputStream("D:\\Study\\users.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        FileOutputStream fileOut = new FileOutputStream("D:\\Study\\users.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
        
        try {
        	userList = (HashMap<String, String>) in.readObject();
        	
        	if(userList.containsKey(login)) {
        		
        		userList.remove(login);
        		saveUser(userList);
        		
        	}
        	
        }catch (IOException i) {
	    	  
	    	  throw new InfraException("Falha ao deletar usuarios");

	      }finally {
				 
				 in.close();
		         fileIn.close();
			}
        
	}
	
	
}
