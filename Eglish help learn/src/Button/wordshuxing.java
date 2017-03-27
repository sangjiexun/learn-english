package Button;
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
		
		setBounds(x,y,150,h);
		setOpaque(true);
	
	}


}
