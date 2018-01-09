package read_menu;
import java.awt.Color;
import javax.swing.JLabel;

public class wordshuxing extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x=10;
	int y;
	int w=200;
	int h=40;
	public wordshuxing (int num,String name){
		super(name);
		y=50*num-40;
		setBounds(x,y,w,h);
		setForeground(Color.white);
		setBackground(new Color(60,160,60));
		setOpaque(true);
	}

}
