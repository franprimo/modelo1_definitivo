package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioModel {

	public UsuarioModel(){
		
	}
	
	public ArrayList<Usuario> load(){

		MySql conexion = MySql.getInstance();
		ResultSet resultado = conexion.query("SELECT * FROM usuarios;");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try{
			while(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId((int) resultado.getObject("id"));
				usuario.setName((String) resultado.getObject("usuario"));
				usuario.setPassword((String) resultado.getObject("pass"));				
				usuarios.add(usuario);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return usuarios;
	}	
	
}
