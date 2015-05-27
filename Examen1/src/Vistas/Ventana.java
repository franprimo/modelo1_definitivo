package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private Principal panelPrincipal;
	private Delincuentes panelDelincuentes;
	private Antecedentes panelAntecedentes;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelPrincipal = new Principal();
		panelDelincuentes = new Delincuentes(this);
		
		this.getContentPane().add(panelPrincipal, "Principal");
		this.getContentPane().add(panelDelincuentes, "Delincuentes");
		
		componentes();
	}
		
	
	public void componentes(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) getContentPane().getLayout();
				layout.show(getContentPane(), "Principal");
			}
		});
		mnPrincipal.add(mntmPrincipal);
		
		JMenu mnDelincuentes = new JMenu("Delincuentes");
		menuBar.add(mnDelincuentes);
		
		JMenuItem mntmDelincuentes = new JMenuItem("Delincuentes");
		mntmDelincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelPrincipal.estaRegistrado()==false){
					JOptionPane.showMessageDialog(null, "Debes estar registrado para acceder aquí");
				}else{
					CardLayout layout = (CardLayout) getContentPane().getLayout();
					layout.show(getContentPane(), "Delincuentes");
				}

			}
		});
		mnDelincuentes.add(mntmDelincuentes);

	}

}
