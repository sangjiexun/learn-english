package tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//主界面的工具栏
public class Toolpanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public Toolpanel(){
	setLayout(null);
	setPreferredSize(new Dimension(200, 50));//工具栏的宽度；
	setBackground(Color.CYAN);
    JButton OT1=new JButton("open");
    OT1.setBounds(10,370, 70, 60);
	OT1.setBorder(new LineBorder(Color.CYAN));
	OT1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
		}
		
		
		
	});
	
    add(OT1);
	
}
}