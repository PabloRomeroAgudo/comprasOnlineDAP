package view;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;
import utils.Colores;

public class TopBar extends JPanel implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private Window w;
	@Getter
	@Setter
	private Window father;
	@Getter
	@Setter
	private int xMouse;
	@Getter
	@Setter
	private int yMouse;
	
	public TopBar(Window w, Window father, String title) {
		this.w = w;
		this.father = father;
		this.setLayout(null);
		this.setBackground(Colores.C700);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		XButton button = new XButton("X", w);
		button.setBounds(770, 0, 40, 25);
		this.add(button);
		
		JLabel titulo = new JLabel(title);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		titulo.setForeground(Colores.C100);
		titulo.setBounds(10, 0, 195, 25);
		this.add(titulo);
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		w.setLocation(x - xMouse, y - yMouse);
		if (father != null) {
			father.setLocation(x - xMouse, y - yMouse);
		}
	}

	public void mouseMoved(MouseEvent e) {}
}
