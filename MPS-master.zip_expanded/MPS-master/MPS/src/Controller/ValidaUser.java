package Controller;

import java.util.regex.Pattern;

import util.LoginInvalidoException;

public class ValidaUser {
	
	public void validaLoginSenha(String login, String senha) throws Exception {
		
		if(!login.isEmpty() && !senha.isEmpty()) {
			
			validaTamanhoLogin(login);
			
			validaNumerosLogin(login);
			
			validaTamanhoSenha(senha);
			
			validaNumerosSenha(senha);
			
		}else {
			System.out.println("Insira um login e senha nao nulos");
			throw new LoginInvalidoException("Login ou senha nulos");
		}
		
	}
	
	public void validaTamanhoLogin(String login) throws Exception {
		
		if(login.length() > 15) {
			
			System.out.println("Login so pode ter no maximo 15 caracteres");
			throw new LoginInvalidoException("Login so pode ter no maximo 15 caracteres");
		}
		
	}
	
	
	public void validaNumerosLogin(String login) throws Exception {
		
		if(login.matches(".*\\d.*")) {
			
			System.out.println("Login nao pode conter numeros");
			throw new LoginInvalidoException("Login nao pode conter numeros");
			
		}
		
	}
	
	public void validaTamanhoSenha(String senha) throws Exception {
		
		if(senha.length() > 16) {
			
			System.out.println("Senha so pode ter no maximo 16 caracteres");
			throw new LoginInvalidoException("Senha so pode ter no maximo 16 caracteres");
			
		}else if(senha.length() < 6) {
			
			System.out.println("Senha deve ter no minimo 6 caracteres");
			throw new LoginInvalidoException("Senha deve ter no minimo 6 caracteres");
			
		}
		
	}
	
	public void validaNumerosSenha(String senha) throws Exception {
		
		if(!senha.matches(".*\\d.*")) {
			
			System.out.println("Senha deve conter no minimo 1 numero");
			throw new LoginInvalidoException("Senha deve conter no minimo 1 numero");
			
		}
		
	}
	
	

}
