package mian;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import tool.Panel1;


public class Mianwindow extends JFrame{
	public Panel1 tp1;
	public static void main(String[] args) {
		Mianwindow widm = new Mianwindow();
	}
	
	
	public Mianwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ť�󣬳������
		setBounds(300,30,900,700);//���ô�С
		setTitle("������");
		tp1=new Panel1();//��ӹ�����
		add(tp1,BorderLayout.WEST);
//		MouseListener iconbig = null;
		
		
		
		
		
		
		setVisible(true);

	}



	

}
