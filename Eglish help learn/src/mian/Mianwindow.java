package mian;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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
		tp1=new Panel1();//添加工具栏
		add(tp1,BorderLayout.WEST);
		setVisible(true);

	}



	

}
