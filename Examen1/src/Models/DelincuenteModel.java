package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DelincuenteModel {

	public DelincuenteModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Delincuente> load(){
		MySql conexion = MySql.getInstance();
		ResultSet resultado = conexion.query("SELECT * FROM delincuentes;");
		ArrayList<Delincuente> delincuentes = new ArrayList<Delincuente>();
		
		try{
			while(resultado.next()){
				Delincuente delincuente = new Delincuente();
				delincuente.setId((int) resultado.getObject("id"));
				delincuente.setNombre((String) resultado.getObject("nombre"));
				delincuente.setEdad((int) resultado.getObject("edad"));
				delincuente.setSexo((String) resultado.getObject("sexo"));
				delincuente.setNacionalidad((String) resultado.getObject("nacionalidad"));
				delincuente.setDireccion((String) resultado.getObject("direccion"));
				delincuente.setPoblacion((String) resultado.getObject("poblacion"));
				delincuente.setAntecedentes((String) resultado.getObject("antecedentes"));
				delincuentes.add(delincuente);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
				
		return delincuentes;
	}
	
	public void save(Delincuente delincuente, String a){
		MySql conexion = MySql.getInstance();
		int id = delincuente.getId();
		String antecedentesMod = a;
		conexion.modifyQuery("UPDATE delincuentes SET antecedentes='"+antecedentesMod+"' WHERE id='"+id+"';");
	}

}
