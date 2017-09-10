package englishchinese;

import java.awt.Color;

import javax.swing.JLabel;

public class chineselabel extends JLabel{
public chineselabel(int x,int y,String name){
	super(name);
	
	
	setBounds(x,y*70+100,300,60);
	setForeground(Color.white);
	setBackground(new Color(80,180,70));
	
	
	
	
	setOpaque(true);
//	140,140,200
//	220,220,30
//	60,160,60
}
	
}
