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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ť�󣬳������
		setBounds(300,30,900,700);//���ô�С
		setTitle("������");
		tp1=new Panel1(this);//��ӹ�����
		add(tp1,BorderLayout.WEST);
		JMenuBar jmb = createMenuBar();

		this.setJMenuBar(jmb);
		
		setVisible(true);

	}
	
	private JMenuBar createMenuBar() {
		// ʵ����һ��JMenuBar�Ķ���
		JMenuBar jmb = new JMenuBar();
		// �˵��������
		String[] arrayMenu = { "���ݲ���", "��������", "����" };
		// �˵����������
		String[][] arrayMenuItem = { { "��������ѧϰ����", "��Ӵʵ�", "���Ĵʵ����" }, 
				{ "�Զ�ƥ������" ,"ѧϰ��¼"},{ "��������", "�������" } };
		// ��������ѭ���������˵���
		for (int i = 0; i < arrayMenu.length; i++) {
			// ʵ����һ��JMenu�Ķ���
			JMenu menu = new JMenu(arrayMenu[i]);
			// ��menu��ӵ�jmb������
			jmb.add(menu);
			for (int j = 0; j < arrayMenuItem[i].length; j++) {
				// ʵ����JMenuItem�Ķ���
				JMenuItem jmi = new JMenuItem(arrayMenuItem[i][j]);
				// ��jmi������ӵ�menu��
				menu.add(jmi);
			}
		}
		return jmb;
	}
}


	


