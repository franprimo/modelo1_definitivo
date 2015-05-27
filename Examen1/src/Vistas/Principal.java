package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Controllers.LoginController;
import Controllers.UsuarioController;
import Models.Usuario;

public class Principal extends JPanel {

	private JPasswordField passwordField;
	private JComboBox<Usuario> comboBox;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnLogout;
	private Usuario usuarioSelect;
	private boolean esRegistrado = false;
	
	private UsuarioController uc;
	private LoginController lc;

	public Principal() {
		
		uc = new UsuarioController();
		lc = new LoginController();
		
		setBounds(100, 100, 450, 350);
		setLayout(null);

		etiquetas();
		botones();
		comboBox();
		password();
	
	}
	
	public void etiquetas(){
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(21, 51, 61, 16);
		add(lblUsuario);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(21, 79, 88, 16);
		add(lblPassword);
	}
	
	public void botones(){
		btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionLogin();
			}
		});
		btnLogin.setBounds(21, 123, 117, 29);
		add(btnLogin);
		
		btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(21, 152, 117, 29);
		add(btnLogout);
	}
	
	public void comboBox(){
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioSelect = (Usuario) comboBox.getSelectedItem();
			}
		});
		reloadComboBox();
		comboBox.setBounds(117, 47, 154, 27);
		add(comboBox);
	}
	
	public void password(){
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 73, 150, 28);
		add(passwordField);
	}
	
	public void reloadComboBox(){
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(uc.cargaUsuario().toArray());
		comboBox.setModel(modelo);
		comboBox.repaint();
	}
	
	public void accionLogin(){
		if(lc.checkLogin(usuarioSelect, passwordField.getText())==true){
			esRegistrado = true;
			JOptionPane.showMessageDialog(null, "Login Correcto.");
		}else{
			esRegistrado = false;
		}
	}
	
	public boolean estaRegistrado(){
		return esRegistrado;
	}
}
