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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,900,700);//设置大小
		setTitle("主窗口");
		tp1=new Panel1(this);//添加工具栏
		add(tp1,BorderLayout.WEST);
		JMenuBar jmb = createMenuBar();

		this.setJMenuBar(jmb);
		
		setVisible(true);

	}
	
	private JMenuBar createMenuBar() {
		// 实例化一个JMenuBar的对象
		JMenuBar jmb = new JMenuBar();
		// 菜单项的数组
		String[] arrayMenu = { "数据操作", "其他功能", "帮助" };
		// 菜单子项的数组
		String[][] arrayMenuItem = { { "导入正在学习单词", "添加词典", "更改词典词义" }, 
				{ "自动匹配文章" ,"学习记录"},{ "帮助主题", "关于软件" } };
		// 根据数据循环来创建菜单栏
		JMenu menu1 = new JMenu("数据操作");
		jmb.add(menu1);
		JMenuItem jmi1 = new JMenuItem("导入正在学习单词");
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
			           System.out.println("读取文件内容出错");
			           e1.printStackTrace();
			       }
			        System.out.println(ba);
				}
				String bba=ba.toString();
//			 Scanner s = new Scanner(bba).useDelimiter(" ");//用空格分离单词
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
//			// 实例化一个JMenu的对象
//			JMenu menu = new JMenu(arrayMenu[i]);
//			// 将menu添加到jmb对象中
//			jmb.add(menu);
//			for (int j = 0; j < arrayMenuItem[i].length; j++) {
//				// 实例化JMenuItem的对象
//				JMenuItem jmi = new JMenuItem(arrayMenuItem[i][j]);
//				// 将jmi对象添加到menu中
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
           System.out.println("读取文件内容出错");
           e1.printStackTrace();
       }
	
//		db.text=ba.toString();
//		db.zairu();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


	


