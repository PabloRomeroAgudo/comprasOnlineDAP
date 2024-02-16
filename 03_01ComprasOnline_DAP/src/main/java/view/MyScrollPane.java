package view;

import javax.swing.JScrollPane;

import utils.Colores;
import utils.MyScrollBarUI;

public class MyScrollPane extends JScrollPane {

	private static final long serialVersionUID = 1L;
	
	public MyScrollPane() {
		this.setBorder(null);
		
		this.setBackground(Colores.C100);
		
		this.getVerticalScrollBar().setUI(new MyScrollBarUI());
	}
}
