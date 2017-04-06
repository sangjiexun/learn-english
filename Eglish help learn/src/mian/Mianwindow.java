package mian;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tool.Panel1;


public class Mianwindow extends JFrame{
	public Panel1 tp1;
	public static void main(String[] args) {
		Mianwindow widm = new Mianwindow();
		
	}
	
	
	public Mianwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,900,700);//设置大小
		setTitle("主窗口");
		tp1=new Panel1(this);//添加工具栏
		add(tp1,BorderLayout.WEST);
		JMenuBar jmb = createMenuBar();

		this.setJMenuBar(jmb);
		
		setVisible(true);

	}
	
	private JMenuBar createMenuBar() {
		// 实例化一个JMenuBar的对象
		JMenuBar jmb = new JMenuBar();
		// 菜单项的数组
		String[] arrayMenu = { "数据操作", "其他功能", "帮助" };
		// 菜单子项的数组
		String[][] arrayMenuItem = { { "导入正在学习单词", "添加词典", "更改词典词义" }, 
				{ "自动匹配文章" ,"学习记录"},{ "帮助主题", "关于软件" } };
		// 根据数据循环来创建菜单栏
		for (int i = 0; i < arrayMenu.length; i++) {
			// 实例化一个JMenu的对象
			JMenu menu = new JMenu(arrayMenu[i]);
			// 将menu添加到jmb对象中
			jmb.add(menu);
			for (int j = 0; j < arrayMenuItem[i].length; j++) {
				// 实例化JMenuItem的对象
				JMenuItem jmi = new JMenuItem(arrayMenuItem[i][j]);
				// 将jmi对象添加到menu中
				menu.add(jmi);
			}
		}
		return jmb;
	}
}


	


