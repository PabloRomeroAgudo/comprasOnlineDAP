package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.bson.BsonInvalidOperationException;

import controller.UsuarioController;
import utils.Colores;

public class MenuUsuario extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	private static final String TITULO = "AMADEOZON - USUARIOS";
	private static Integer opcion = 0;
	
	private final UsuarioController controller = new UsuarioController();
	
	private JPanel contentPane;
	
	private MenuPUButton findByName;
	private MenuPUButton findById;
	private MenuPUButton findAll;
	private MenuPUButton add;
	private MenuPUButton update;
	private MenuPUButton delete;
	private JLabel instruccionesLabel;
	private JTextArea eYSTexto;
	private MenuPUButton accept;

	public MenuUsuario(Window parent) {
		this.setModal(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Colores.C100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TopBar topBar = new TopBar(this, parent, TITULO);
		topBar.setBounds(0, 0, 810, 25);
		contentPane.add(topBar);
		
		findByName = new MenuPUButton("BUSCAR POR NOMBRE");
		findByName.setBounds(10, 35, 223, 40);
		findByName.addActionListener(this);
		contentPane.add(findByName);
		
		findById = new MenuPUButton("BUSCAR POR ID");
		findById.setBounds(10, 99, 223, 40);
		findById.addActionListener(this);
		contentPane.add(findById);
		
		findAll = new MenuPUButton("MOSTRAR TODO");
		findAll.setBounds(10, 163, 223, 40);
		findAll.addActionListener(this);
		contentPane.add(findAll);
		
		add = new MenuPUButton("AÑADIR");
		add.setBounds(10, 227, 223, 40);
		add.addActionListener(this);
		contentPane.add(add);
		
		update = new MenuPUButton("ACTUALIZAR");
		update.setBounds(10, 291, 223, 40);
		update.addActionListener(this);
		contentPane.add(update);
		
		delete = new MenuPUButton("BORRAR");
		delete.setBounds(10, 355, 223, 40);
		delete.addActionListener(this);
		contentPane.add(delete);
		
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(243, 35, 557, 329);
		contentPane.add(scrollPane);
		
		instruccionesLabel = new JLabel("Bienvenido a " + TITULO);
		instruccionesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instruccionesLabel.setOpaque(true);
		instruccionesLabel.setBackground(Colores.C50);
		instruccionesLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(instruccionesLabel);
		
		eYSTexto = new JTextArea();
		eYSTexto.setEditable(false);
		eYSTexto.setBorder(null);
		eYSTexto.setBackground(Colores.C50);
		eYSTexto.setColumns(10);
		eYSTexto.addKeyListener(this);
		scrollPane.setViewportView(eYSTexto);
		
		accept = new MenuPUButton("✔  ACEPTAR  ✔");
		accept.setEnabled(false);
		accept.addMouseListener(this);
		accept.setBounds(243, 374, 557, 21);
		accept.addActionListener(this);
		contentPane.add(accept);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		accept.setEnabled(true);
		if (findByName == e.getSource()) {
			opcion = 1;
			instruccionesLabel.setText("Introduce el inicio del nombre:");
			eYSTexto.setEditable(true);
			eYSTexto.setText("");
		} else if (findById == e.getSource()) {
			opcion = 2;
			instruccionesLabel.setText("Introduce el id:");
			eYSTexto.setEditable(true);
			eYSTexto.setText("");
		} else if (findAll == e.getSource()) {
			opcion = 0;
			accept.setEnabled(false);
			instruccionesLabel.setText(TITULO);
			eYSTexto.setEditable(false);
			eYSTexto.setText(controller.findAll());
		} else if (add == e.getSource()) {
			opcion = 3;
			instruccionesLabel.setText("Introduce el nuevo usuario en formato JSON:");
			eYSTexto.setEditable(true);
			eYSTexto.setText("");
		} else if (update == e.getSource()) {
			opcion = 4;
			instruccionesLabel.setText("Introduce el usuario que quieras modificar en formato JSON:");
			eYSTexto.setEditable(true);
			eYSTexto.setText("");
		} else if (delete == e.getSource()) {
			opcion = 5;
			instruccionesLabel.setText("Introduce el id del usuario a borrar:");
			eYSTexto.setEditable(true);
			eYSTexto.setText("");
		} else if (accept == e.getSource()) {
			aceptar(false);
		}
	}
	
	private void aceptar(Boolean isIntro) {
		String objeto;
		String[] lineas = eYSTexto.getText().split("\n");

		try {
			switch (opcion) {
			case 1:
				objeto = controller.findByName(lineas[0]);
				eYSTexto.append(objeto.isEmpty() ? "\nNo se ha encontrado" : "\n" + objeto);
				
				accept.setEnabled(false);
				eYSTexto.setEditable(false);
				break;
			case 2:
				objeto = controller.findById(Integer.valueOf(lineas[0]));
				eYSTexto.append(objeto.isEmpty() ? "\nNo se ha encontrado" : "\n" + objeto);
				
				accept.setEnabled(false);
				eYSTexto.setEditable(false);
				break;
			case 3:
				if (!isIntro) {
					objeto = eYSTexto.getText();
					Boolean anyadido = controller.add(objeto);
					eYSTexto.append(anyadido ? "\nAñadido con éxito" : "\nNo se puede añadir");
					
					accept.setEnabled(false);
					eYSTexto.setEditable(false);
				}
				break;
			case 4:
				if (!isIntro) {				
					objeto = eYSTexto.getText();
					boolean modificado = controller.update(objeto);
					eYSTexto.append(modificado ? "\nModificado con éxito" : "\nNo se puede modificar");

					accept.setEnabled(false);
					eYSTexto.setEditable(false);
				}
				break;
			case 5:
				Boolean borrado = controller.delete(Integer.valueOf(lineas[0]));
				eYSTexto.append(borrado ? "\nBorrado con éxito" : "\nNo se puede borrar");
				
				accept.setEnabled(false);
				eYSTexto.setEditable(false);
				break;
			}
		} catch (NumberFormatException | BsonInvalidOperationException e) {}
	}
	

	// KEY LISTENER
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			if (eYSTexto.getText().isBlank()) {
				eYSTexto.setText("");
			}
			aceptar(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	
	// MOUSELISTENER
	
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			if (accept.isEnabled()) {
				if (accept == e.getSource()) {
					accept.setBackground(Colores.G700);
				}			
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
				if (accept == e.getSource()) {
					if (accept.isEnabled()) {
						if (accept.getIsHovering()) {
							accept.setBackground(Colores.G600);
						} else {
							accept.setBackground(Colores.C100);
						}
					} else {
						accept.setBackground(Colores.C100);
					}		
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if (accept == e.getSource()) {
				if (accept.isEnabled()) {
					accept.setIsHovering(true);
					accept.setBackground(Colores.G600);
					accept.setForeground(Color.WHITE);
					accept.setBorder(new LineBorder(Colores.G600, 1, true));				
				}
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if (accept == e.getSource()) {
				accept.setIsHovering(false);
				accept.setBackground(Colores.C100);
				accept.setForeground(Colores.C700);
				accept.setBorder(new RoundedBorder(10));
			}
		}
}
