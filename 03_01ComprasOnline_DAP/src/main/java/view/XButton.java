package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import lombok.Getter;
import lombok.Setter;
import utils.Colores;
import utils.FixedStateButtonModel;

public class XButton extends JButton implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Window w;
	
	public XButton(String text, Window w) {
		this.w = w;
		this.setText(text);
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(Colores.C700);
		this.setForeground(Colores.C100);
		
		this.setModel(new FixedStateButtonModel());
		
		this.addActionListener(this);
		this.addMouseListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		w.dispose();
	}

	public void mouseClicked(MouseEvent e) {}


	public void mousePressed(MouseEvent e) {}


	public void mouseReleased(MouseEvent e) {}


	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.RED);
		this.setForeground(Colores.C100);
	}


	public void mouseExited(MouseEvent e) {
		this.setBackground(Colores.C700);
		this.setForeground(Colores.C100);
	}
}
