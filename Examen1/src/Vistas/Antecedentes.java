package Vistas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.DelincuenteController;
import Models.Delincuente;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Antecedentes extends JPanel {
	private JTextField campoInfo;
	private Ventana ventana;
	private Delincuente delincuente;
	private DelincuenteController dc;

	public Antecedentes(Ventana v, Delincuente d) {
		setBounds(100, 100, 450, 350);
		setLayout(null);
		this.ventana = v;
		this.delincuente = d;
		
		dc = new DelincuenteController();

		componentes();
	}
	
	public void componentes(){
		JLabel lblAntecedentes = new JLabel("Antecedentes");
		lblAntecedentes.setBounds(28, 35, 164, 16);
		add(lblAntecedentes);
		
		campoInfo = new JTextField();
		campoInfo.setText(delincuente.getAntecedentes());
		campoInfo.setBounds(28, 63, 384, 135);
		add(campoInfo);
		campoInfo.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionSalvar();
			}
		});
		btnSalvar.setBounds(28, 222, 117, 29);
		add(btnSalvar);
		
		JButton btnDelincuentes = new JButton("Delincuentes");
		btnDelincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionDelincuentes();
			}
		});
		btnDelincuentes.setBounds(28, 250, 117, 29);
		add(btnDelincuentes);
	}
	
	public void accionDelincuentes(){
		CardLayout layout = (CardLayout) ventana.getContentPane().getLayout();
		layout.show(ventana.getContentPane(), "Delincuentes");
	}
	
	public void accionSalvar(){
		dc.save(this.delincuente, campoInfo.getText());
	}

}
