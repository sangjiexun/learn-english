package tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mian.XWindow;

/**窗口参数设定工具类*/
public class T5 {
	
	
	/**一个可以直接回主界面的菜单*/
	public static JMenuBar createMenuBar(final JFrame J1) {
		// 实例化一个JMenuBar的对象
		JMenuBar jmb = new JMenuBar();
		JMenu menu1 = new JMenu("编辑");
		jmb.add(menu1);
		
		JMenuItem jmi1 = new JMenuItem("返回主页");
		menu1.add(jmi1);
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				J1.setVisible(false);
				T1.initmain();
				}
			}
		);
		return jmb;
	}
	
	/**通用参数设定*/
	public static void setData(final XWindow xJ1) throws ClassNotFoundException {
		xJ1. word1=T1.getinworld();//已会单词
		xJ1. word2=T1.getduonowworld();//正在学习的难点
		xJ1. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		xJ1. setVisible(true);
	}
	
	
}
