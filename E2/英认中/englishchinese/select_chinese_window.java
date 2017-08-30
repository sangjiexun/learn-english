package englishchinese;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Button.Tool_panel;
import others.grade;
import test.T1;
import tool.Panel1;
import worldshow.Word;

public class select_chinese_window extends JFrame {
	
	public TextArea ta;
	public ArrayList<String> word=null;
	public ArrayList<String> word1;//�ѻᵥ��
    public ArrayList<String> word2;//����ѧϰ�ĵ���
	public Word wo;
	public String text,t;
	public int wnum,c;
	public JPanel jpanel1;
	public static select_chinese_window test;
	public chineselabel cq,cw, ce,cr,cd,cf;
	public JLabel e1,ex1,p0,p1,p2,g1,g2,b1,b2;//b1,b2Ϊ�������Դ��� 
	public JButton j1, j2, j3, j4;
	public String english_w1,english_wr;
	public String chinese_w1,chinese_w2,chinese_w3,chinese_w4,chinese_w5,chinese_w6;
	public grade grade1;


	public select_chinese_window(ArrayList<String> w1,ArrayList<String> w2) {
        word1=w1;
        word2=w2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ť�󣬳������
		setBounds(200,30,1000,700);//���ô�С
		getContentPane().setBackground(new Color(30,30,30));
		setTitle("select chinese");
		jpanel1=new JPanel();
		setdata();
		setjpanel1();
		add(jpanel1,BorderLayout.WEST);
		setVisible(true);

	}

	
	

	
	
	private void setdata() {
//		english_w1=word1.get((int) (Math.random()*word1.size()));
		if (Math.random()<0.3){
		word =word1;
		c=1;
		
		}
		else{
		word=word2;
		c=2;}//��ߵ���
		
		english_w1=word.get((int) (Math.random()*word.size()));
		System.out.println(search(english_w1));
		chinese_w1=search(word.get((int) (Math.random()*word.size())));
		chinese_w2=search(word.get((int) (Math.random()*word.size())));
		chinese_w3=search(word.get((int) (Math.random()*word.size())));
		chinese_w4=search(word.get((int) (Math.random()*word.size())));
		chinese_w5=search(word.get((int) (Math.random()*word.size())));
		chinese_w6=search(word.get((int) (Math.random()*word.size())));
		int ram16=new Random().nextInt(6)+1;
		switch(ram16){
		case 1:{chinese_w1=search(english_w1);
		break;}
		case 2:{chinese_w2=search(english_w1);
		break;}
		case 3:{chinese_w3=search(english_w1);;
		break;}
		case 4:{chinese_w4=search(english_w1);
		break;}
		case 5:{chinese_w5=search(english_w1);
		break;}
		case 6:{chinese_w6=search(english_w1);
		break;}
			
		}
		repaint();
		
}



	private String search(String inputWord) {
		
		try {
            BufferedReader br = new BufferedReader(
         new FileReader("C:/Users/Administrator/Desktop/����ϼ�/dictionary.txt"));
            String line ;
            boolean isFound = false;
             
//            System.out.println(inputWord.substring(0,inputWord.length()-1));
            if(inputWord.equals("")){
                return " ";
            }
                         
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
            	String sword=in.next();//in.next()ʹ�ú���Զ�����
                if(sword.equals(inputWord)){

                    int offset = inputWord.length();
                    
                    return line.substring(offset);
 
                }
       
        }
		}
        catch (Exception ex) {
            ex.printStackTrace();
        }
	
		return " ";
	}






	private void setjpanel1() {//��������������
		
		
		int i1;
		i1=Integer.parseInt(readDate());
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
		g1.setText("�ȼ���");
		g2.setFont(new java.awt.Font("Dialog", 1,20));
		g2.setText("���飺"+grade1.ex);
	
		
		
		
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
		j1=new JButton ("O ��������ѧϰ");
		j2=new JButton ("P ����ʶ");
		j3=new JButton ("K �ٶ�����");
		j4=new JButton ("L ���ð�ť");
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

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			T1 tt1=new T1();
			
			switch(e.getKeyChar()){
			case 'q':{ 
				if(search(english_w1).equals(chinese_w1)){
					showword();
					setdata();	
					reshow();
				}
				else{
					cq.setBackground(Color.RED);
				chengfa();
				}
				break;}
			case 'w':{ 
				if(search(english_w1).equals(chinese_w2)){
					showword();
					setdata();	
					reshow();
					}
				else{
					cw.setBackground(Color.RED);
				chengfa();}
				break;}
			case 'e':{ 
				if(search(english_w1).equals(chinese_w3)){
					showword();
					setdata();	
					reshow();
					}
				else{
					ce.setBackground(Color.RED);
				chengfa();}
				break;}
			case 'r':{ 
				if(search(english_w1).equals(chinese_w4)){
					showword();
					setdata();	
					reshow();
					}
				else{
					cr.setBackground(Color.RED);
				chengfa();}
				break;}
			case 'd':{ 
				if(search(english_w1).equals(chinese_w5)){
					showword();
					setdata();	
					reshow();
					}
				else{
					cd.setBackground(Color.RED);
				chengfa();}
				break;}
			case 'f':{ 
				if(search(english_w1).equals(chinese_w6)){
					showword();
					setdata();	
					reshow();
					}
				else{
					cf.setBackground(Color.RED);
				chengfa();}
				break;}
			case 'o':{ 
				word1.remove(english_w1);
				word2.add(english_w1);
			
				try {
					tt1.delinword(english_w1);
					tt1.addnowword(english_w1);
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
					tt1.delinword(english_w1);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				System.out.println(word1.size());
				showword();
				setdata();
				reshow();				
				chengfa();	
				
				break;}
			case 'l':{
				showword();
				setdata();	
				reshow();
				break;}
			
			case 'k':{ 
				baidusousuo(english_w1);
				break;}
			}
			}

			@Override
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
		p0.setText("����:"+word1.size()+"��ѧ��"+word2.size());
		
//		b1.setText(text);
//		b2.setText(��֪����);
		if (c==2){
			b1.setText("����ѧϰ");	
			b1.setBackground(new Color(20,220,70));
		}
		if (c==1){
			b1.setText("��ʶ�ĵ���");	
			b1.setBackground(new Color(50,70,200));
		}
		c=0;
		repaint();
		
	}
	
	public void showword(){
		p1.setText(english_w1);
		p2.setText(search(english_w1));
		grade1.ex++;
		
		WriteDate(grade1.ex+"");
		 
		g2.setText("���飺"+grade1.ex);
	}
	
	public void baidusousuo(String t){ 
  	   try { 
  		   
  		    String url = "http://www.iciba.com/"+t; 
  		    java.net.URI uri = java.net.URI.create(url); 
  		    // ��ȡ��ǰϵͳ������չ 
  		    java.awt.Desktop dp = java.awt.Desktop.getDesktop(); 
  		    // �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ��� 
  		    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) { 

  		      dp.browse(uri);// ��ȡϵͳĬ������������� 

  		    } 
  		   } catch (java.lang.NullPointerException f) { 
  		    // ��ΪuriΪ��ʱ�׳��쳣 
  		    f.printStackTrace(); 
  		   } catch (java.io.IOException f) { 
  		    // ��Ϊ�޷���ȡϵͳĬ������� 
  		    f.printStackTrace(); 
  		   } 
  		  }
	
//	 public void out(){
//		   
//		   
//	    	try{
//		    		
//		    		ObjectOutputStream out=new ObjectOutputStream(
//		    				new FileOutputStream(
//		    						"C:/Users/Administrator/Desktop/����ϼ�/obj.txt"));
//		    		out.writeObject(word1);
//		    		out.close();
//		    	}catch(IOException e ){
//		    		e.printStackTrace();
//		    	}
//		    	
//		   }
	
//	 public void outnow(){
//		   
//		   
//	    	try{
//		    		
//		    		ObjectOutputStream out=new ObjectOutputStream(
//		    				new FileOutputStream(
//		    						"C:/Users/Administrator/Desktop/����ϼ�/now.txt"));
//		    		out.writeObject(word2);
//		    		out.close();
//		    	}catch(IOException e ){
//		    		e.printStackTrace();
//		    	}
//		    	
//		   }
	
	 public static String readDate(){
			String sb = new String();
			
			try{
        
         
		    BufferedReader br = new BufferedReader(new FileReader
		    		("C:/Users/Administrator/Desktop/����ϼ�/grade.txt"));
			
         sb=br.readLine();

         System.out.println(sb);

			} catch (Exception ex) {

			System.out.println(ex);

			}

			return sb;
			
			}
	 
	 public static void WriteDate(String nfile) {

			try{

			BufferedWriter output = new BufferedWriter(new FileWriter
					("C:/Users/Administrator/Desktop/����ϼ�/grade.txt"));//����TXTλ��

			output.write(String.valueOf(nfile)+"\r\n");


			output.close();

			} catch (Exception ex) {

			System.out.println(ex);

			}

			}
	 public void chengfa(){//����ʶ��ɾ��
//		 cq.setBackground(Color.RED);
		 grade1.ex-=1;
		 WriteDate(grade1.ex+"");
		 g2.setText("���飺"+grade1.ex);
		
//		 repaint();
	 }
	
	 public void Deletew(){	 
   for (int i=0;i<word1.size();i++){
	   
//	   if(word1.get(i).length()>7){
//		   System.out.println(word1.get(i)+word1.get(i).length());
//		   word1.remove(i);
//	   }
////	   
//	  for (int j=0;j<word1.get(i).length();j++){
//		if(word1.get(i).substring(j, j+1).equals("-")){
//			word1.remove(i);
//			break;
//		}
//	  }

	   
   }		 
	 }
	 
	 
}
