package Vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.DelincuenteController;
import Models.Delincuente;

public class Delincuentes extends JPanel {
	private JTextField campoNombre;
	private JTextField campoEdad;
	private JTextField campoSexo;
	private JTextField campoNacionalidad;
	private JTextField campoDireccion;
	private JTextField campoPoblacion;
	private List list;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JLabel lblNacionalidad;
	private JLabel lblDireccion;
	private JLabel lblPoblacion;
	private Delincuente delincuenteSelect;
	
	private Ventana ventana;
	private DelincuenteController dc;
	private Antecedentes panelAnt;

	public Delincuentes(Ventana v) {
		setBounds(100, 100, 450, 350);
		setLayout(null);
		this.ventana = v;
		dc = new DelincuenteController();
			
		etiquetas();
		camposTexto();
		boton();
		lista();
	}
	
	public void lista(){
		list = new List();
		list.setBounds(28, 26, 105, 256);
		list.setBackground(Color.WHITE);
		for(int i = 0; i<dc.getDelincuentes().size(); i++){
			list.add(dc.getDelincuentes().get(i).getNombre());
		}
		list.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				delincuenteSelect = dc.getDelincuentes().get(list.getSelectedIndex());
				volcadoDatos();
			}

		});
		add(list);
	}
	
	public void etiquetas(){
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(164, 26, 61, 16);
		add(lblNombre);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(164, 84, 61, 16);
		add(lblEdad);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(299, 84, 61, 16);
		add(lblSexo);
		
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(164, 139, 105, 16);
		add(lblNacionalidad);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(164, 187, 80, 16);
		add(lblDireccion);
		
		lblPoblacion = new JLabel("Poblacion:");
		lblPoblacion.setBounds(164, 236, 80, 16);
		add(lblPoblacion);
	}
	
	public void camposTexto(){
		campoNombre = new JTextField();
		campoNombre.setBounds(164, 44, 237, 28);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoEdad = new JTextField();
		campoEdad.setBounds(164, 104, 105, 28);
		add(campoEdad);
		campoEdad.setColumns(10);
		
		campoSexo = new JTextField();
		campoSexo.setBounds(299, 104, 102, 28);
		add(campoSexo);
		campoSexo.setColumns(10);
			
		campoNacionalidad = new JTextField();
		campoNacionalidad.setBounds(164, 157, 237, 28);
		add(campoNacionalidad);
		campoNacionalidad.setColumns(10);
		
		campoDireccion = new JTextField();
		campoDireccion.setBounds(164, 205, 237, 28);
		add(campoDireccion);
		campoDireccion.setColumns(10);
			
		campoPoblacion = new JTextField();
		campoPoblacion.setBounds(164, 254, 134, 28);
		add(campoPoblacion);
		campoPoblacion.setColumns(10);
	}
	
	public void boton(){
		JButton btnAntecedentes = new JButton("Antecedentes");
		btnAntecedentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionAntecedentes();
			}
		});
		btnAntecedentes.setBounds(305, 255, 117, 29);
		add(btnAntecedentes);
	}
	
	public void accionAntecedentes(){
		panelAnt = new Antecedentes(ventana, delincuenteSelect);
		ventana.getContentPane().add("Antecedentes", panelAnt);
		
		CardLayout layout = (CardLayout) ventana.getContentPane().getLayout();
		layout.show(ventana.getContentPane(), "Antecedentes");
	}
	
	public void volcadoDatos(){
		campoNombre.setText(delincuenteSelect.getNombre());
		campoEdad.setText(String.valueOf(delincuenteSelect.getEdad()));
		campoSexo.setText(delincuenteSelect.getSexo());
		campoNacionalidad.setText(delincuenteSelect.getNacionalidad());
		campoDireccion.setText(delincuenteSelect.getDireccion());
		campoPoblacion.setText(delincuenteSelect.getPoblacion());
	}
}
