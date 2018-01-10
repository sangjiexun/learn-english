package read.english_reader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;

import mian.XWindow;
import read.menu.Tool_panel;
import read.wordshow.Word;

public class readWindow extends XWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public readWindow() throws ClassNotFoundException {
		super();
		
	}


	public TextArea ta;
//	public ArrayList<String> word=null;
	public Word wo;
	public Tool_panel tp;
	public String text,t;
	public int wnum;

	
	//载入操作
	public void zairu (){
		wo=new Word(this,text);
		add(wo);
		repaint();
		setVisible(true);
	};
	
	//清空操作
	public void qingkong (){
		remove(wo);
		repaint();
		setVisible(true);
	}


	@Override
	public void zdy() {
		  System.out.println(this.word2);
			setBounds(300,30,900,700);
			getContentPane().setBackground(new Color(40,40,40));
			setTitle("English help");
			tp=new Tool_panel(this);
			add(tp,BorderLayout.EAST);
	};


	
}
