package reciteenlish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import others.grade;
import others.jtable;
import test.T1;

public class panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public recitewindow widd; 
    private jtable j1,j2,j3,j11,j21,j31,j4,j41;
    private JLabel jex;
    private TextField t1;
    private JPasswordField t2 ;
    private String w1,w2,w3,w4,w5,w6,w7;
    private JButton b1;
    public ArrayList<String> e;
	public grade grade1;
    public int i1;
    
	public panel(recitewindow widd){
	i1=Integer.parseInt(readDate());
	grade1=new grade(i1);
	e=widd.word2;
	this.widd=widd;

	w1=e.get(50);
	w3=w1;
	setLayout(null);
	setPreferredSize(new Dimension(200, 700));
	setBackground(new Color(199,237,204));
	
	j4=new jtable(500,20,200,50,"等级");
	j41=new jtable(500,70,200,50,"经验");
	
	j1=new jtable(20,20,400,50,w1);
	j11=new jtable(20,70,400,50,"starting");
	w7=w1;
	j2=new jtable(20,200,400,100,"中文");
	j21=new jtable(20,300,400,100,"start"); 
	
	j3=new jtable(500,200,200,100,"start");
	j31=new jtable(500,300,200,100,"start");
	
	
	
	jex=new JLabel();
	jex.setBounds(20,120,680,80);
	jex.setBackground(new Color(240,128,128));
	jex.setOpaque(true);
	
	j1.setFont(new Font("Dialog",2, 25));
	j2.setFont(new Font("Dialog",2, 50));
	j3.setFont(new Font("Dialog",2, 30));
	
	j11.setFont(new Font("Dialog",2, 25));
	j21.setFont(new Font("Dialog",2, 50));
	j31.setFont(new Font("Dialog",2, 30));
	
	j4.setFont(new Font("Dialog",2, 40));
	j41.setFont(new Font("Dialog",2, 40));
	
	
	
	
	t1=new TextField();
	t2 = new JPasswordField();
	t2.setBounds(80, 500, 180, 30);
	t2.setEchoChar((char) 0);
	t2.setFont(new Font("Dialog",2, 20));
	t2.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent k) {
        	T1 tt1=new T1();
//        	System.out.println(t2.getText());
        	if(t2.getText().equals(" ")||t2.getText().equals("0")
        			){
        	t2.setText("");}
        	
        	
            if(k.getKeyChar()==32){
            if(t2.getText().equals(w7)){
            	try {
            		System.out.println(w7);
					tt1.increasetime(w7);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	j3.setText(w7);
//            	j2.setText(j1.getText());
            	w7=j1.getText();
            	
            	
            	
//            	w1=e.get((int) (Math.random()*e.size()));
            	double ram=Math.random();
            	System.out.println(ram);
            	if (ram<0.1){

            	w1=e.get((int) (Math.random()*40));
            	}
            	else if(ram<0.2){
            	w1=e.get((int) (Math.random()*80));
            	
            	}
            	else if(ram<0.3){
                	w1=e.get((int) (Math.random()*120));
                	
                	}
            	else if(ram<0.4){
                	w1=e.get((int) (Math.random()*150));
                	
                	}
            	else if(ram<0.5){
                	w1=e.get((int) (Math.random()*200));
                	
                	}
            	else
            	{w1=e.get((int) (Math.random()*e.size()));}
            	
            	
            	
            	j1.setText(w1);
            	
            	j31.setText(j21.getText());
            	j21.setText(j11.getText());
            	
//            	w2=searchWords(w1);//ԭ���ķ���
            	try {
					w2=tt1.searchWords(w1);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
            	j11.setText(w2);
            	
            	grade1.ex++;
            	w5=""+grade1.ex;
            	
            	w6=""+grade1.getgrade();
            	j4.setText("等级"+w6);
            	j41.setText("经验"+w5);
            	jex.setBounds(20,120,(int)(grade1.getlen()*680),80);
            	WriteDate(w5);
                
            	j41.setBackground(new Color(0,174,239));
            	
            }
            else{
            j41.setBackground(Color.red);	
            grade1.ex=grade1.ex-((int)((Math.random()+0.12)));
            j41.setText("经验"+w5);
           
            }
            
            System.out.println(w7);
            t2.setText("");
            j2.setText("中文");
            }
            if(k.getKeyChar()=='\n'){
            	baidusousuo();
            }
            //��ʾ��
            if(k.getKeyChar()=='0'){
            	j2.setText(w7);
            }
            //���ش�
//            if(k.getKeyChar()=='9'){
//            	j2.setText("����");
//            }
        }
      	

    });
	t2.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyChar()=='0'){
        		j2.setText("中文");
        		System.out.println("asf");
            }
			
		}});
	
	
	b1=new JButton("查字典");
	b1.setBounds(320, 500, 95, 30);
	b1.setBackground( new Color(28,134,238));
	
	b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent c){
        	baidusousuo();
        }
 });
	
	

	
	add(j1);add(j11);
	add(j2);add(j21);
	add(j3);add(j31);
	add(t2);add(b1);
    add(j4);add(j41);
    add(jex);
    
	System.out.println(e.size());  
	}

	
	 public static void WriteDate(String nfile) {

			try{

			BufferedWriter output = new BufferedWriter(new FileWriter
					("C:/Users/Administrator/Desktop/代码合集/grade.txt"));//����TXTλ��

			output.write(String.valueOf(nfile)+"\r\n");

			output.close();

			} catch (Exception ex) {

			System.out.println(ex);

			}
			}
	 
	 
	 

		public static String readDate(){
			String sb = new String();
			
			try{
           
            
		    BufferedReader br = new BufferedReader(new FileReader
		    		("C:/Users/Administrator/Desktop/代码合集/grade.txt"));
			
            sb=br.readLine();

            System.out.println(sb);

			} catch (Exception ex) {

			System.out.println(ex);
			}
			return sb;
			
			}
 
	 
		
		public void baidusousuo(){ 
	     	   try { 
	     		    String t=t2.getText();
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
		

}
