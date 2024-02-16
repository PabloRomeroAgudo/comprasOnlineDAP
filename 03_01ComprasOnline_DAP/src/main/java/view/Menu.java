package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Colores;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuButton usuarios;
	private MenuButton productos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Colores.C100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TopBar topBar = new TopBar(this, null, "AMADEOZON");
		topBar.setBounds(0, 0, 810, 25);
		contentPane.add(topBar);
		
		usuarios = new MenuButton("USUARIOS");
		usuarios.setBounds(119, 182, 136, 30);
		usuarios.addActionListener(this);
		contentPane.add(usuarios);
		
		productos = new MenuButton("PRODUCTOS");
		productos.setBounds(547, 182, 136, 30);
		productos.addActionListener(this);
		contentPane.add(productos);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (usuarios == e.getSource()) {
			MenuUsuario mu = new MenuUsuario(this);
			mu.setLocationRelativeTo(this);
			mu.setVisible(true);
		} else if (productos == e.getSource()) {
			MenuProducto mp = new MenuProducto(this);
			mp.setLocationRelativeTo(this);
			mp.setVisible(true);
		}
	}
}
