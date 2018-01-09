package tool;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MYJButton extends JButton {
	int x;
	int y;
	int w;
	int h;
	public MYJButton(String name , int num,ActionListener a1){
		this.setText(name);
		  x=(num%4)*180-100;
		  y=(num/4)*120+80;
		  w=130;
		  h=90;
		 setBounds(x, y, w, h);
		 MouseListener e=new MouseListener(){

			public void mouseClicked(MouseEvent e) { }

			public void mousePressed(MouseEvent e) { }

			public void mouseReleased(MouseEvent e) { }

			public void mouseEntered(MouseEvent e) {
				setBounds(x-10, y-10, w+20, h+20);
			}

			public void mouseExited(MouseEvent e) {
				setBounds(x, y, w, h);				
			}
			 
		 };
		addMouseListener(e);
		addActionListener(a1); 
	}

}
