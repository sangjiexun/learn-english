package mian;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
	public static void main(String[] args) {
		 widm = new Mianwindow();
//		 actionPerformed();
	}
	
	
	public Mianwindow() {
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
		     	 tn="";}
//		     	   System.out.println(c);
		     	
		     	
		  
		     		   }
		     	   ti++;
		     	   }
		        
				
				
				
			}} );
	       

		
		        
		
		
//		for (int i = 0; i < arrayMenu.length; i++) {
//			// ʵ����һ��JMenu�Ķ���
//			JMenu menu = new JMenu(arrayMenu[i]);
//			// ��menu��ӵ�jmb������
//			jmb.add(menu);
//			for (int j = 0; j < arrayMenuItem[i].length; j++) {
//				// ʵ����JMenuItem�Ķ���
//				JMenuItem jmi = new JMenuItem(arrayMenuItem[i][j]);
//				// ��jmi������ӵ�menu��
//				menu.add(jmi);
//			}
//		}
		
		
		
		
		
		
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


	


