package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import util.InfraException;

public class ArquivoUserDAO implements UserDAO{
	
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

	@Override
	public void add(HashMap<String, String> user) throws IOException, FileNotFoundException, InfraException{
		
		FileOutputStream fileOut = new FileOutputStream("D:\\Study\\users.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
		try{
			out.writeObject(user);
		}catch (IOException i) {
			throw new InfraException("Falha ao salvar lista de usuarios");
		}finally {
			out.close();
			fileOut.close();
      }
	}

	@Override
	public void delete(String login) throws IOException, FileNotFoundException, ClassNotFoundException, InfraException {
		
		HashMap<String, String> userList = new HashMap<String, String>();
		
		FileInputStream fileIn = new FileInputStream("D:\\Study\\users.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        FileOutputStream fileOut = new FileOutputStream("D:\\Study\\users.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
        
        try {
        	userList = (HashMap<String, String>) in.readObject();
        	
        	if(userList.containsKey(login)) {
        		userList.remove(login);
        		add(userList);
        	}
        }catch (IOException i) {
        	throw new InfraException("Falha ao deletar usuarios");
        }finally {
        	in.close();
        	fileIn.close();
        	out.close();
		}
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
