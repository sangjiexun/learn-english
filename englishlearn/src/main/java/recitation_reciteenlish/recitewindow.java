package recitation_reciteenlish;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import recitation_others.jtable;
import recitation_others.mykey;
import test.T1;

public class recitewindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词
    
	public recitewindow(ArrayList<String>w1, ArrayList<String> w2) throws ClassNotFoundException{
		word1=w1;
		word2=w2;
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300,30,900,700);
	setTitle("English help");
	add(new panel(this),BorderLayout.NORTH);
//	System.out.println(word2);
	addKeyListener(new mykey());  
	JMenuBar jmb = createMenuBar();
	this.setJMenuBar(jmb);
//
//	 JPanel  GImage = new JPanel() {  
//		 
//		 /**
//		 * 
//		 */
//		private static final long serialVersionUID = -8226355005112414617L;
//
//		public  void paintComponent(Graphics g) {
////			System.out.println();
//			System.out.println("sdkflllll");
//           ImageIcon icon = new ImageIcon("C:/Users/Administrator/Desktop/图片素材库/timg.jpg");  
//           Image img = icon.getImage();  
//           g.drawImage(img, 0, 0, icon.getIconWidth(),  
//                   icon.getIconHeight(), icon.getImageObserver());    
//       }  
//
//   };  
//	
//    GImage.setBounds(0,0,900,700);
//    GImage.setVisible(true);
//	add(GImage);
	
	setVisible(true);
	}

	
	
	
	
	
	
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
