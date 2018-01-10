package eforc.englishchinese;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mian.XWindow;
import recitation.others.grade;
import tool.T1;
import tool.T4;
/**中文选择英文的窗口
 * */
public class select_chinese_window extends XWindow {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public select_chinese_window() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

//	public TextArea ta;
	/**当前背的单词集合*/
	public ArrayList<String> word=null;
//	public Word wo;
//	public String text,t;
//	public int wnum;
	/**当前状态，提示用*/
	private int flag;
	public JPanel jpanel1;
//	public static select_chinese_window test;
	public chineselabel cq,cw, ce,cr,cd,cf;
	public JLabel e1,ex1,p0,p1,p2,g1,g2,b1,b2;//b1,b2为单词属性窗口 
	public JButton j1, j2, j3, j4;
	public String english_w1,english_wr;
	public String chinese_w1,chinese_w2,chinese_w3,chinese_w4,chinese_w5,chinese_w6;
	public grade grade1;


//	public select_chinese_window() throws ClassNotFoundException {
//        T5.setData(this);
//		setBounds(200,30,1000,700);
//		getContentPane().setBackground(new Color(30,30,30));
//		setTitle("select chinese");
//		jpanel1=new JPanel();
//
//		
//		 JPanel  GImage = new JPanel() {  
//		 
//		 /**
//		 * 
//		 */
//		private static final long serialVersionUID = -8226355005112414617L;
//
//		public  void paintComponent(Graphics g) {
////			System.out.println();
////			System.out.println("sdkflllll");
//          ImageIcon icon = new ImageIcon("C:/Users/Administrator/Desktop/图片素材库/timg.jpg");  
//          Image img = icon.getImage();  
//          g.drawImage(img, 0, 0, icon.getIconWidth(),  
//                  icon.getIconHeight(), icon.getImageObserver());    
//      }  
//
//  };  
//	
//   GImage.setBounds(0,0,900,700);
//
//	setdata();
//	setjpanel1();
//	jpanel1.add(GImage);
//	add(jpanel1,BorderLayout.WEST);
//	JMenuBar jmb = T5.createMenuBar(this);
//	this.setJMenuBar(jmb);
//	
//
//	}

	
	private void setdata() throws ClassNotFoundException {
//		english_w1=word1.get((int) (Math.random()*word1.size()));
		
		if (Math.random()<0.5){
		word =word1;
		flag=1;
		
		}
		else{
		word=word2;
		flag=2;}
//		T1 tt1=new T1();		
		
//		word=tt1.getduonowworld();
//		System.out.println(word.size());
		
		english_w1=word.get((int) (Math.random()*word.size()));
//		System.out.println(search(english_w1));
		System.out.println(T1.searchWords(english_w1));
		chinese_w1=T1.searchWords(word.get((int) (Math.random()*word.size())));
		chinese_w2=T1.searchWords(word.get((int) (Math.random()*word.size())));
		chinese_w3=T1.searchWords(word.get((int) (Math.random()*word.size())));
		chinese_w4=T1.searchWords(word.get((int) (Math.random()*word.size())));
		chinese_w5=T1.searchWords(word.get((int) (Math.random()*word.size())));
		chinese_w6=T1.searchWords(word.get((int) (Math.random()*word.size())));
		int ram16=new Random().nextInt(6)+1;
		switch(ram16){
		case 1:{chinese_w1=T1.searchWords(english_w1);
		break;}
		case 2:{chinese_w2=T1.searchWords(english_w1);
		break;}
		case 3:{chinese_w3=T1.searchWords(english_w1);;
		break;}
		case 4:{chinese_w4=T1.searchWords(english_w1);
		break;}
		case 5:{chinese_w5=T1.searchWords(english_w1);
		break;}
		case 6:{chinese_w6=T1.searchWords(english_w1);
		break;}
			
		}
		repaint();
}


	private void setjpanel1() {	

		int i1;
		i1=Integer.parseInt(T4.readDate());
		grade1=new grade(i1);
		

		jpanel1.setLayout(null);
		jpanel1.setPreferredSize(new Dimension(950, 150));//���950
		jpanel1.setBackground(new Color(60,60,60));
		
		ex1=new JLabel();
		ex1.setBounds(20, 200, 180,550);
		ex1.setBackground(new Color(220,220,30));
		ex1.setOpaque(true);
		
		b1=new JLabel();
		b1.setBounds(10, 150, 150, 50);
		b1.setOpaque(true);

		
		g1=new JLabel();
		g2=new JLabel();
		g1.setBounds(10, 30, 150, 50);
		g2.setBounds(10, 80, 180, 50);
		g1.setBackground(new Color(220,220,30));
		g2.setBackground(new Color(20,220,70));
		g1.setOpaque(true);
		g2.setOpaque(true);
		g1.setFont(new java.awt.Font("Dialog", 1,30));
		g1.setText("等级");
		g2.setFont(new java.awt.Font("Dialog", 1,20));
		g2.setText("经验"+grade1.ex);

		
		e1=new JLabel(english_w1);
		e1.setBounds(220, 30, 300,70);
		e1.setForeground(Color.white);
		e1.setBackground(new Color(140,140,200));
		e1.setOpaque(true);
		e1.setFont(new java.awt.Font("Dialog", 1,30));
		
		p0=new JLabel();
		p1=new JLabel();
		p2=new JLabel();
		
		p0.setBounds(550, 70, 300,70);
		p1.setBounds(550, 160, 300,70);
		p2.setBounds(550, 250, 300,70);
	
		p0.setFont(new java.awt.Font("Dialog", 1,20));
		p1.setFont(new java.awt.Font("Dialog", 1,30));
		p2.setFont(new java.awt.Font("Dialog", 1,30));
		p0.setBackground(new Color(190,120,150));
		p1.setBackground(new Color(190,120,150));
		p2.setBackground(new Color(190,120,150));
		p0.setOpaque(true);
		p1.setOpaque(true);
		p2.setOpaque(true);
		
		
		cq=new chineselabel(220, 1, chinese_w1);
		cw=new chineselabel(220, 2, chinese_w2);
		ce=new chineselabel(220, 3, chinese_w3);
		cr=new chineselabel(220, 4, chinese_w4);
		cd=new chineselabel(220, 5, chinese_w5);
		cf=new chineselabel(220, 6, chinese_w6);
		

		
		jpanel1.add(b1);
//		jpanel1.add(g1);
		jpanel1.add(g2);
		jpanel1.add(p0);
		jpanel1.add(p1);
		jpanel1.add(p2);
		jpanel1.add(e1);
//		jpanel1.add(ex1);//����ϵͳ
		jpanel1.add(cq);
		jpanel1.add(cw);
		jpanel1.add(ce);
		jpanel1.add(cr);
		jpanel1.add(cd);
		jpanel1.add(cf);
		

		//��ť�ϼ�
		j1=new JButton ("O 加入正在学习");
		j2=new JButton ("P 不认识");
		j3=new JButton ("K 百度搜索");
		j4=new JButton ("L 备用按钮");
		j1.setBounds(550, 430, 160, 60);
		j2.setBounds(550, 520, 160, 60);
		j3.setBounds(740, 430, 160, 60);
		j4.setBounds(740, 520, 160, 60);
		j1.setBackground(new Color(240,100,100));
		j2.setBackground(new Color(240,100,100));
		j3.setBackground(new Color(240,100,100));
		j4.setBackground(new Color(240,100,100));
		
		
		jpanel1.add(j1);
		jpanel1.add(j2);
		jpanel1.add(j3);
		jpanel1.add(j4);
		j4.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				
			}

			public void keyPressed(KeyEvent e) {
	
			
			switch(e.getKeyChar()){
			case 'q':{ 
				try {
					if(T1.searchWords(english_w1).equals(chinese_w1)){
						showword();
						setdata();	
						reshow();
					}
					else{
						cq.setBackground(Color.RED);
					chengfa();
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;}
			case 'w':{ 
				try {
					if(T1.searchWords(english_w1).equals(chinese_w2)){
						showword();
						setdata();	
						reshow();
						}
					else{
						cw.setBackground(Color.RED);
					chengfa();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;}
			case 'e':{ 
				try {
					if(T1.searchWords(english_w1).equals(chinese_w3)){
						showword();
						setdata();	
						reshow();
						}
					else{
						ce.setBackground(Color.RED);
					chengfa();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;}
			case 'r':{ 
				try {
					if(T1.searchWords(english_w1).equals(chinese_w4)){
						showword();
						setdata();	
						reshow();
						}
					else{
						cr.setBackground(Color.RED);
					chengfa();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;}
			case 'd':{ 
				try {
					if(T1.searchWords(english_w1).equals(chinese_w5)){
						showword();
						setdata();	
						reshow();
						}
					else{
						cd.setBackground(Color.RED);
					chengfa();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;}
			case 'f':{ 
				try {
					if(T1.searchWords(english_w1).equals(chinese_w6)){
						showword();
						setdata();	
						reshow();
						}
					else{
						cf.setBackground(Color.RED);
					chengfa();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;}
			case 'o':{ 
				word1.remove(english_w1);
				word2.add(english_w1);
			
				try {
					T1.delinword(english_w1);
					T1.addNowWord(english_w1);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
//				out();//ԭ���ķ�����
//				outnow();
				break;}
					
			case 'p':{ 
				
				word1.remove(english_w1);
//				Deletew();
//				out();
				try {
					T1.delinword(english_w1);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				System.out.println(word1.size());
				try {
					showword();
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				try {
					setdata();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				reshow();				
				chengfa();	
				
				break;}
			case 'l':{
				try {
					showword();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					setdata();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				reshow();
				break;}
			
			case 'k':{ 
				baidusousuo(english_w1);
				break;}
			}
			}

			public void keyReleased(KeyEvent e) {
		
			}});		
		

	}
	
	private void reshow(){
		e1.setText(english_w1);
		cq.setText(chinese_w1);
		cw.setText(chinese_w2);
		ce.setText(chinese_w3);
		cr.setText(chinese_w4);
		cd.setText(chinese_w5);
		cf.setText(chinese_w6);
		cq.setBackground(new Color(60,160,60));
		cw.setBackground(new Color(60,160,60));
		ce.setBackground(new Color(60,160,60));
		cr.setBackground(new Color(60,160,60));
		cd.setBackground(new Color(60,160,60));
		cf.setBackground(new Color(60,160,60));
		p0.setText("词量:"+word1.size()+"在学："+word2.size());
		
//		b1.setText(text);
//		b2.setText(��֪����);
		if (flag==2){
			b1.setText("正在学习");	
			b1.setBackground(new Color(20,220,70));
		}
		if (flag==1){
			b1.setText("认识的单词");	
			b1.setBackground(new Color(50,70,200));
		}
		flag=0;
		repaint();
		
	}
	
	public void showword() throws ClassNotFoundException{
		T1 tt1=new T1();
		p1.setText(english_w1);
		p2.setText(tt1.searchWords(english_w1));
		grade1.ex++;
		T4.WriteDate(grade1.ex+""); 
		g2.setText("经验"+grade1.ex);
	}
	
	public void baidusousuo(String t){ 
	  	   try { 
	  		   
	  		    String url = "http://www.iciba.com/"+t; 
	  		    java.net.URI uri = java.net.URI.create(url); 
	  		    // 获取当前系统桌面扩展 
	  		    java.awt.Desktop dp = java.awt.Desktop.getDesktop(); 
	  		    // 判断系统桌面是否支持要执行的功能 
	  		    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) { 
	  		      dp.browse(uri);// 获取系统默认浏览器打开链接 
	  		    } 
	  		   } catch (java.lang.NullPointerException f) { 
	  		    // 此为uri为空时抛出异常 
	  		    f.printStackTrace(); 
	  		   } catch (java.io.IOException f) { 
	  		    // 此为无法获取系统默认浏览器 
	  		    f.printStackTrace(); 
	  		   } 
	  		  }

	 

	 public void chengfa(){//惩罚，减经验值
//
		 grade1.ex-=1;
		 T4.WriteDate(grade1.ex+"");
		 g2.setText("经验："+grade1.ex);
		
//		 repaint();
	 }


	@Override
	public void zdy() {
		setBounds(200,30,1000,700);
		getContentPane().setBackground(new Color(30,30,30));
		setTitle("select chinese");
		jpanel1=new JPanel();
		 JPanel  GImage = new JPanel() {  
		 
		 /**
		 * 
		 */
		private static final long serialVersionUID = -8226355005112414617L;

		public  void paintComponent(Graphics g) {
//			System.out.println();
//			System.out.println("sdkflllll");
          ImageIcon icon = new ImageIcon("C:/Users/Administrator/Desktop/图片素材库/timg.jpg");  
          Image img = icon.getImage();  
          g.drawImage(img, 0, 0, icon.getIconWidth(),  
                  icon.getIconHeight(), icon.getImageObserver());    
      }  

		
  };  
	
   GImage.setBounds(0,0,900,700);

	try {
		setdata();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setjpanel1();
	jpanel1.add(GImage);
	add(jpanel1,BorderLayout.WEST);
		
	}

	 
}
