package utils;

import javax.swing.DefaultButtonModel;

//Code extracted from: https://stackoverflow.com/questions/22543633/stopping-jbutton-highlighting-on-press
	public class FixedStateButtonModel extends DefaultButtonModel {

		private static final long serialVersionUID = 1L;

		@Override
     public boolean isPressed() {
         return false;
     }

     @Override
     public boolean isRollover() {
         return false;
     }

     @Override
     public void setRollover(boolean b) {
         //NOOP
     }

 }