package Button;
import java.awt.Color;

//label的属性
//传入位置，高度，标签内容
//产生标签
import javax.swing.JLabel;

public class wordshuxing extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public wordshuxing (int x,int y ,int h,String name){
		super(name);
		
		setBounds(x,y,200,h);
		setForeground(Color.white);
		setBackground(new Color(60,160,60));
		setOpaque(true);
	
	}


}
