package view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import utils.Colores;
import utils.FixedStateButtonModel;
import java.awt.Font;

public class MenuButton extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	public MenuButton(String text) {
		this.setText(text);
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(Colores.C500);
		this.setForeground(Colores.C100);
		this.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		this.setModel(new FixedStateButtonModel());
		
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Colores.C600);		this.setFont(new Font("Tahoma", Font.BOLD, 13));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Colores.C500);		this.setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
