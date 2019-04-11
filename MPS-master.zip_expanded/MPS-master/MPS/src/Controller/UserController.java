package Controller;

import java.io.IOException;
import java.util.HashMap;

import Persistencia.PersistenciaUsuario;
import util.InfraException;
import util.LoginInvalidoException;

public class UserController  {
	
	ValidaUser validador = new ValidaUser();
	PersistenciaUsuario usuarioPersistente = new PersistenciaUsuario();
	HashMap<String, String> user = new HashMap<String, String>();
	
	//List<Validador> validadores;
	
	
//	public UserController(List<Validador> validadores) {
//		super();
//		this.validadores = validadores;
//	}

	
	public void initializeList() throws ClassNotFoundException, IOException, InfraException {
		
		try {
			usuarioPersistente.init(user);
			System.out.println("Lista de usuarios carregada");
			}catch(InfraException i){
				System.out.println(i);
			}
		
	}

	public void add(String login, String senha) throws Exception {
		
			validador.validaLoginSenha(login, senha);
			
			user.put(login, senha);
			
			try {
			usuarioPersistente.saveUser(user);
			System.out.println("Serialized user data is saved in D:\\Study\\users.ser");
			}catch(InfraException i){
				System.out.println(i);
			}
   	}

	public String lisAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String list(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public void del(String login) throws Exception {
		
		try {
			usuarioPersistente.deleteUser(login);
			System.out.println("User deleted.");
			}catch(InfraException i){
				System.out.println(i);
			}
		
	}

}
