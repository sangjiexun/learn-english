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

	public ArrayList<String> word1;//�ѻᵥ��
    public ArrayList<String> word2;//����ѧϰ�ĵ���
    
	public recitewindow(ArrayList<String>w1, ArrayList<String> w2){
		word1=w1;
		word2=w2;
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300,30,900,700);
	setTitle("English help");
	add(new panel(this),BorderLayout.NORTH);
	
	addKeyListener(new mykey());  
	
	setVisible(true);
	}
	
	
	
}
