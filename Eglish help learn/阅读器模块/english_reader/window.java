package english_reader;
//����һ������
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;

import Button.Tool_panel;
import worldshow.Word;

public class window extends JFrame {
	public TextArea ta;
	public ArrayList<String> word=null;
	public Word wo;
	public Tool_panel tp;
	public String text,t;
	public int wnum;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ť�󣬳������
		setBounds(300,30,900,700);//���ô�С
		setTitle("English help");
		tp=new Tool_panel(this);//��ӹ�����
		add(tp,BorderLayout.EAST);//�����������ұ�

		setVisible(true);

	}
	
	
	public void zairu (){
		wo=new Word(this,text);
		add(wo);
		setVisible(true);
	};
	
	public void qingkong (){
		remove(wo);
		repaint();
		setVisible(true);
	};
	
	

}
