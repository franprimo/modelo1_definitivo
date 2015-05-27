package Controllers;

import java.util.ArrayList;

import Models.Usuario;
import Models.UsuarioModel;

public class UsuarioController {
	UsuarioModel um;
	
	public UsuarioController(){
		um = new UsuarioModel();
	}
	
	public ArrayList<Usuario> cargaUsuario(){
		return um.load();
	}

}
