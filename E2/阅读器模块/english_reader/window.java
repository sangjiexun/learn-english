package english_reader;
//����һ������
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;

import Button.Tool_panel;
import worldshow.Word;

public class window extends JFrame {
	public TextArea ta;
	public ArrayList<String> word=null;
	
	public ArrayList<String> word1;//in
    public ArrayList<String> word2;//now
	public Word wo;
	public Tool_panel tp;
	public String text,t;
	public int wnum;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public window(ArrayList<String> w1,ArrayList<String> w2) {
		word1=w1;
		word2=w2;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,30,900,700);
//		getContentPane().setVisible(false);
		getContentPane().setBackground(new Color(40,40,40));
		setTitle("English help");
		tp=new Tool_panel(this);
		add(tp,BorderLayout.EAST);
		setVisible(true);

	}
	
	
	public void zairu (){
		wo=new Word(this,text);
		add(wo);
		repaint();
		setVisible(true);
//		System.out.println("sda");
	};
	
	public void qingkong (){
		remove(wo);
		repaint();
		setVisible(true);
	};

}
