package view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import utils.Colores;
import utils.FixedStateButtonModel;

public class MenuPUButton extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Boolean isHovering = false;

	public MenuPUButton(String text) {
		this.setText(text);
		this.setFocusPainted(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBorder(new RoundedBorder(10));
		this.setBackground(Colores.C100);
		this.setForeground(Colores.C700);

		this.setModel(new FixedStateButtonModel());

		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (this.isEnabled()) {
			this.setBackground(Colores.C300);			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.isEnabled()) {
			if (isHovering) {
				this.setBackground(Colores.C200);
			} else {
				this.setBackground(Colores.C100);
			}		
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.isEnabled()) {
			isHovering = true;
			this.setBackground(Colores.C200);			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isHovering = false;
		this.setBackground(Colores.C100);
	}

	public Boolean getIsHovering() {
		return isHovering;
	}

	public void setIsHovering(Boolean isHovering) {
		this.isHovering = isHovering;
	}
}
