package mian;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tool.Panel1;


public class Mianwindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Panel1 tp1;
	private static TextArea ta;
    private static StringBuffer ba;
    public static Mianwindow widm;
    public ArrayList<String> word1;//�ѻᵥ��
    public ArrayList<String> word2;//����ѧϰ�ĵ���
    
    
    public ArrayList<String> kd1=new ArrayList();
	public static void main(String[] args) {
		//��ȡ����
		
		ArrayList<String> wordin = inword();
		ArrayList<String> wordnow = innowword();

		
		 widm = new Mianwindow(wordin,wordnow);
//		 actionPerformed();
	}
	
	
	public Mianwindow(ArrayList<String> w1 ,ArrayList<String> w2) {
		this.word1=w1;
		this.word2 =w2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ť�󣬳������
		setBounds(300,30,900,700);//���ô�С
		setTitle("������");
		tp1=new Panel1(this);//��ӹ�����
		add(tp1,BorderLayout.WEST);
		JMenuBar jmb = createMenuBar();

		this.setJMenuBar(jmb);
		
		setVisible(true);

	}
	
	private JMenuBar createMenuBar() {
		// ʵ����һ��JMenuBar�Ķ���
		JMenuBar jmb = new JMenuBar();
		// �˵��������
		String[] arrayMenu = { "���ݲ���", "��������", "����" };
		// �˵����������
		String[][] arrayMenuItem = { { "��������ѧϰ����", "��Ӵʵ�", "���Ĵʵ����" }, 
				{ "�Զ�ƥ������" ,"ѧϰ��¼"},{ "��������", "�������" } };
		// ��������ѭ���������˵���
		JMenu menu1 = new JMenu("���ݲ���");
		jmb.add(menu1);
		JMenuItem jmi1 = new JMenuItem("��������ѧϰ����");
		menu1.add(jmi1);
		jmi1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				{
					ta=new TextArea();
					ba=new StringBuffer();
					FileDialog my=new FileDialog(widm);
			        my.setVisible(true);
			        String t=my.getDirectory()+my.getFile();
//			        db.t=t;
			        System.out.println(t);
			        try {
			        	
								BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(
							                    new FileInputStream(t)));
			                   String lineTxt = null;
			                   while(  (lineTxt = bufferedReader.readLine())!= null)  
			                   { 

			                   ba.append(lineTxt+" $ "+"\r\n");
			                   }
			                   bufferedReader.close();
			        }catch (Exception e1) {
			           System.out.println("��ȡ�ļ����ݳ���");
			           e1.printStackTrace();
			       }
			        System.out.println(ba);
				}
				String bba=ba.toString();
//			 Scanner s = new Scanner(bba).useDelimiter(" ");//�ÿո���뵥��
				bba+="%";
				
				int l=bba.length();
		        int ti=0;
		        String tn="";

		        while (!(bba.substring(ti, ti+1).equals("%"))){
		     	   char c = bba.charAt(ti);
		     	   if((c>=65&&c<=90)||(c>=97&&c<=125)){
		     	   tn+=c;
		            } 
		     	   else {
		     		   if(!(c==13||c==36||c==20)&&(c==32)){
		     	 System.out.println(tn);
		     	 if(!(tn.equals(""))){
		     		 kd1.add(tn);
		     		 
		     	 }
		     	 tn="";}
//		     	   System.out.println(c);
		     	
		     	
		  
		     		   }
		     	   ti++;
		     	   }
		        
				
				System.out.println(kd1);
				
			}} );
	       

		
		
		return jmb;
	}
	
	
	
	public static void actionPerformed() {
		ta=new TextArea();
		ba=new StringBuffer();
		FileDialog my=new FileDialog(widm);
        my.setVisible(true);
        String t=my.getDirectory()+my.getFile();
//        db.t=t;
        System.out.println(t);
        try {
        	
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
				                    new FileInputStream(t)));
                   String lineTxt = null;
                   while(  (lineTxt = bufferedReader.readLine())!= null)  
                   { 
//                   ta.append(lineTxt);
                   ba.append(lineTxt+" $ "+"\r\n");
                   }
                   bufferedReader.close();
        }catch (Exception e1) {
           System.out.println("��ȡ�ļ����ݳ���");
           e1.printStackTrace();
       }
	
//		db.text=ba.toString();
//		db.zairu();

	}
	
	
	
	public static ArrayList<String> inword(){
    	
    	ArrayList<String> w1 = null;
    	try {
			ObjectInputStream in=new ObjectInputStream(
	new FileInputStream("C:/Users/Administrator/Desktop/����ϼ�/obj.txt"));
			
			w1=(ArrayList<String>) in.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return w1;
    	
    }
	
	public static ArrayList<String> innowword(){
    	
    	ArrayList<String> w1 = null;
    	try {
			ObjectInputStream in=new ObjectInputStream(
	new FileInputStream("C:/Users/Administrator/Desktop/����ϼ�/now.txt"));
			
			w1=(ArrayList<String>) in.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return w1;
    	
    }
	
	

	
	
	
	
	
}


	


