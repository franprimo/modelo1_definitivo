package Controllers;

import java.util.ArrayList;

import Models.Delincuente;
import Models.DelincuenteModel;

public class DelincuenteController {

	private DelincuenteModel dm;
	private Delincuente delincuente;
	private String antecedentesMod;
	
	public DelincuenteController() {
		// TODO Auto-generated constructor stub
		dm = new DelincuenteModel();
	}
	
	public ArrayList<Delincuente> getDelincuentes(){
		return dm.load();
	}
	
	public void save(Delincuente d, String a){
		this.delincuente = d;
		this.antecedentesMod = a;
		
		dm.save(delincuente, antecedentesMod);
	}
}
