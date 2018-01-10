package recitation.reciteenlish;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import mian.XWindow;
import tool.T5;
/**背诵界面的窗口*/
public class recitewindow extends XWindow {

	public recitewindow() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
//	public recitewindow() throws ClassNotFoundException{
//	T5.setData(this);
//	setBounds(300,30,900,700);
//	setTitle("English help");
//	add(new panel(this),BorderLayout.NORTH);
//
//	JMenuBar jmb = T5.createMenuBar(this);
//	this.setJMenuBar(jmb);
//	
//	}

	@Override
	public void zdy() {
		setBounds(300,30,900,700);
		setTitle("English help");
		try {
			add(new panel(this),BorderLayout.NORTH);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
