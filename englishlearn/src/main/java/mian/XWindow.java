package mian;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import tool.T1;
import tool.T5;


/**窗口通用模版*/
public abstract class XWindow extends JFrame {
	public ArrayList<String> word1;
    public ArrayList<String> word2;
    
    
    public XWindow() throws ClassNotFoundException{
    	 T5.setData(this);
    	 JMenuBar menuBar = T5.createMenuBar(this);//菜单栏
    	 zdy();
 		 this.setJMenuBar(menuBar);
    }
    
    public abstract void zdy();
    
    
}
