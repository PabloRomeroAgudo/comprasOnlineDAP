package utils;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollBarUI extends BasicScrollBarUI {
	
	@Override
	protected void configureScrollBarColors() {
		this.thumbColor = Colores.C700;
		this.thumbHighlightColor = Colores.C100;  // Color de alrededor izda
		this.thumbLightShadowColor = Colores.C950; // Color de alrededor dcha
		
		this.trackColor = Colores.C100; // Color del fondo del track (detras del deslizador)
		// equivalente a hacer el background nulo (ya que estamos poniendo el mismo fondo que el jpanel)
	}
				
	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton button = new JButton("zero button");
	    Dimension zeroDim = new Dimension(0,0);
	    button.setPreferredSize(zeroDim);
	    button.setMinimumSize(zeroDim);
	    button.setMaximumSize(zeroDim);
	    return button;
    }
	
	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton button = new JButton("zero button");
	    Dimension zeroDim = new Dimension(0,0);
	    button.setPreferredSize(zeroDim);
	    button.setMinimumSize(zeroDim);
	    button.setMaximumSize(zeroDim);
	    return button;
    }
}
