package recitation_others;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class jtable extends JLabel{

	private static final long serialVersionUID = 1L;

	public  jtable(final int x,final int y,final int i,final int j,String a){
		super(a);

		this.setBounds(x,y,i,j);
		setOpaque(true);
		setBackground(new Color(30,100,239));
		addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				
			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				setBounds(x-20,y-10, i+40, j+20);
				setBackground(new Color(70,200,239));
			}

			public void mouseExited(MouseEvent e) {
				setBounds(x,y,i,j);
				setBackground(new Color(30,100,239));
			}
	});
	}
}
