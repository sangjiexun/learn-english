 package mian;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import test.T1;
import tool.Panel1;

 
public class Mianwindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Panel1 tp1;
	private static StringBuffer ba;
    public static Mianwindow widm;
    public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词
    
    
    public ArrayList<String> kd1=new ArrayList<String>();
	public static void main(String[] args) throws ClassNotFoundException {
		T1 tt1=new T1();//创建工具类
		
		ArrayList<String> wordin = tt1.getinworld();
		ArrayList<String> wordnow = tt1.getnowworld();		
		
		 widm = new Mianwindow(wordin,wordnow);
	 
	}	
	
	public Mianwindow(ArrayList<String> w1 ,ArrayList<String> w2) {
		this.word1=w1;
		this.word2 =w2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,900,700);//设置大小
		setTitle("主窗口");//窗口的名字
		tp1=new Panel1(this);//创建工具栏并利用this传递参数
		add(tp1,BorderLayout.WEST);
		JMenuBar jmb = createMenuBar();
		this.setJMenuBar(jmb);
		
		setVisible(true);//设置为可见
	}
	
	private JMenuBar createMenuBar() {
		// 实例化一个JMenuBar的对象
		JMenuBar jmb = new JMenuBar();
//数组暂时没使用
//		// 菜单项的数组
//		String[] arrayMenu = { "数据操作", "其他功能", "帮助" };
//		// 菜单子项的数组
//		String[][] arrayMenuItem = { { "导入正在学习单词", "添加词典", "更改词典词义" }, 
//				{ "自动匹配文章" ,"学习记录"},{ "帮助主题", "关于软件" } };
		// 根据数据循环来创建菜单栏
		JMenu menu1 = new JMenu("数据操作");
		jmb.add(menu1);
		JMenuItem jmi1 = new JMenuItem("导入正在学习单词");
		menu1.add(jmi1);
		jmi1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {	
				{
					new TextArea();
					ba=new StringBuffer();
					FileDialog my=new FileDialog(widm);
			        my.setVisible(true);
			        String t=my.getDirectory()+my.getFile();
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
				}
				String bba=ba.toString();
				bba+="%";	
		        int ti=0;
		        String tn="";

		        while (!(bba.substring(ti, ti+1).equals("%"))){
		     	   char c = bba.charAt(ti);
		     	   if((c>=65&&c<=90)||(c>=97&&c<=125)){
		     	   tn+=c;
		            } 
		     	   else {
		     		   if(!(c==13||c==36||c==20)&&(c==32)){
//		     	 System.out.println(tn);
		     	 if(!(tn.equals(""))){
		     		 kd1.add(tn);		     		 
		     	 }
		     	 tn="";}
		     		   }
		     	   ti++;
		     	   }		        
		        				
				System.out.println("要导入的单词："+kd1);
				
				T1 tt1 =new T1();
				
				for (int i=0;i<kd1.size();i++){
	
      
                 try {
					tt1.delinword(kd1.get(i));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
                 try {
					tt1.addnowword(kd1.get(i));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				}
			}
			} );

		return jmb;
	}
	
	
	
	public static void actionPerformed() {
		new TextArea();
		ba=new StringBuffer();
		FileDialog my=new FileDialog(widm);
        my.setVisible(true);
        String t=my.getDirectory()+my.getFile();
        System.out.println(t);
        try {
        	
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
				                    new FileInputStream(t)));
                   String lineTxt = null;
                   while((lineTxt = bufferedReader.readLine())!= null){
                   ba.append(lineTxt+" $ "+"\r\n");
                   }
                   bufferedReader.close();
        }catch (Exception e1) {
           System.out.println("读取文件内容出错");
           e1.printStackTrace();
       }
	}
	

}


	


