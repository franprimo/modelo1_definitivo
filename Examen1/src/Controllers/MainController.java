package Controllers;

import Vistas.Principal;
import Vistas.Ventana;

public class MainController {
	private Ventana v;
	//private Principal p;
	
	public MainController(){
		v = new Ventana();
		//p = new Principal();
		//v.setContentPane(p);
		v.setVisible(true);
	}
}
