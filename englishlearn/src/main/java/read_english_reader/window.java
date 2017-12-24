package read_english_reader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import read_Button.Tool_panel;
import test.T1;
import read_worldshow.Word;

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
		JMenuBar jmb = createMenuBar();
		this.setJMenuBar(jmb);
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

	
	
	private JMenuBar createMenuBar() {
		// 实例化一个JMenuBar的对象
		JMenuBar jmb = new JMenuBar();
		JMenu menu1 = new JMenu("编辑");
		jmb.add(menu1);
		
		JMenuItem jmi1 = new JMenuItem("返回主页");
		menu1.add(jmi1);
		jmi1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				T1 tt1=new T1();
				tt1.initmain();
				}
			}
		);
		
		return jmb;
	}
	
	
}
