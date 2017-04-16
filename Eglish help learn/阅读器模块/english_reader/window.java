package english_reader;
//创建一个窗口
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
	
	public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,900,700);//设置大小
//		getContentPane().setVisible(false);
		getContentPane().setBackground(new Color(40,40,40));
		setTitle("English help");
		tp=new Tool_panel(this);//添加工具栏
		add(tp,BorderLayout.EAST);//工具栏放在右边
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
