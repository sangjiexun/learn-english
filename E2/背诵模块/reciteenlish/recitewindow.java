package reciteenlish;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import others.jtable;
import others.mykey;

public class recitewindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词
    
	public recitewindow(ArrayList<String>w1, ArrayList<String> w2){
		word1=w1;
		word2=w2;
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300,30,900,700);
	setTitle("English help");
	add(new panel(this),BorderLayout.NORTH);
//	System.out.println(word2);
	addKeyListener(new mykey());  	
	setVisible(true);
	}
	
}
