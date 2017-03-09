package enlish;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import others.jtable;
import others.mykey;

public class window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public window(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300,30,900,700);
	setTitle("English help");
	add(new panel(this),BorderLayout.NORTH);
	addKeyListener(new mykey());  
	
	setVisible(true);
	}
	
	
	
}
