package mian;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tool.Toolpanel;


public class Mianwindow extends JFrame{
	public Toolpanel tp1;
	public static void main(String[] args) {
		Mianwindow widm = new Mianwindow();
	}
	
	
	public Mianwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,900,700);//设置大小
		setTitle("主窗口");
		tp1=new Toolpanel();//添加工具栏
		add(tp1,BorderLayout.EAST);
		setVisible(true);

	}



	

}
