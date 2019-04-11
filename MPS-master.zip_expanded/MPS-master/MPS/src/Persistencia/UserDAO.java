package Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import util.InfraException;


public interface UserDAO{

void init(HashMap<String, String> userList) throws IOException, InfraException, ClassNotFoundException;

void add(HashMap<String, String> user) throws IOException, FileNotFoundException, InfraException;

void delete (String login) throws IOException, FileNotFoundException, ClassNotFoundException, InfraException;

String list();

String listAll();

}