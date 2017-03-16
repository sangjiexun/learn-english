package english_learn;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,30,900,700);
		setTitle("English help");
		
		System.out.println("hh");
		tp=new Tool_panel(this);
		add(tp,BorderLayout.EAST);
		
		setVisible(true);

	}
	
	public void zairu (){
//		text="hello world";
		wo=new Word(this);
		add(wo);
		setVisible(true);
	};
	
	
	
	
	
}
