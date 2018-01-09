package read_english_reader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import mian.XWindow;
import read_menu.Tool_panel;
import tool.T5;
import read_worldshow.Word;

public class readWindow extends XWindow {
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
	public readWindow() throws ClassNotFoundException {
        T5.setData(this);
        System.out.println(this.word2);
		setBounds(300,30,900,700);
//		getContentPane().setVisible(false);
		getContentPane().setBackground(new Color(40,40,40));
		setTitle("English help");
		tp=new Tool_panel(this);
		add(tp,BorderLayout.EAST);
		JMenuBar jmb = T5.createMenuBar(this);
		this.setJMenuBar(jmb);
		

	}
	
	
	public void zairu (){
		wo=new Word(this,text);
		add(wo);
		repaint();
		setVisible(true);
	};
	
	public void qingkong (){
		remove(wo);
		repaint();
		setVisible(true);
	};


	
}
