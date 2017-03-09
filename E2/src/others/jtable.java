package others;

import java.awt.Color;

import javax.swing.JLabel;

public class jtable extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  jtable(int x,int y,int i,int j,String a){
		super(a);

		this.setBounds(x,y,i,j);
		setOpaque(true);
		setBackground(Color.gray);
		
	}

}
