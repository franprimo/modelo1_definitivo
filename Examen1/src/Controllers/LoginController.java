package Controllers;

import javax.swing.JOptionPane;

import Models.Usuario;

public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkLogin(Usuario usuario, String pass){
		if(pass.equals("")){
			JOptionPane.showMessageDialog(null, "El campo contraseña no puede estar vacio.");
		}else{
			if(usuario.getPassword().equals(pass)){
				return true;
			}
		}
		return false;
	}

}
