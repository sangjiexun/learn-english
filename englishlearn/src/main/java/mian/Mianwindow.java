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

import org.apache.log4j.Logger;

import test.Mylog;
import test.T1;
import test.T2;
import tool.Panel1;

/**
 * 主窗口与程序入口
 */
public class Mianwindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public Panel1 tp1;
	private static StringBuffer ba;
	
 
    public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词   
//    private ArrayList<String> kd1=new ArrayList<String>();
	
	
    /**
     * 程序入口
     * */
	public static void main(String[] args) throws ClassNotFoundException {		
		initmain();
	}
    
	
	/**
	 * 主窗口构建
	 * */
	public Mianwindow(ArrayList<String> w1 ,ArrayList<String> w2) {
		this.word1=w1;
		this.word2 =w2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,800,600);//设置大小
		setTitle("主窗口");//窗口的名字

		tp1=new Panel1(this);//创建工具栏并利用this传递参数
		add(tp1,BorderLayout.WEST);
		JMenuBar jmb = createMenuBar();
		this.setJMenuBar(jmb);
		
		setVisible(true);//设置为可见
	}
	

	
	/**实例化一个JMenuBar的对象
	 * */
	private JMenuBar createMenuBar() {
		
		JMenuBar jmb = new JMenuBar();
		JMenu menu1 = new JMenu("数据操作");
		jmb.add(menu1);
		JMenuItem jmi1 = new JMenuItem("导入正在学习单词");
		menu1.add(jmi1);
		
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
					new TextArea();
					ba=new StringBuffer();
					JFrame Jopen = null;
					FileDialog my=new FileDialog(Jopen);//传一个窗口文件
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

				String importWordString=ba.toString();
				
				T2 tt2 =new T2();
				ArrayList<String> ImportWord=new ArrayList<String>();

				
				ImportWord =tt2.getImportWord(importWordString);
		        				
				System.out.println("要导入的单词："+ImportWord);
				
				
				T1 tt1 =new T1();
				Logger logger = tt1.getMyLog(Mylog.class);
			    logger.debug("导入了单词"+ImportWord);
			
				try {
					tt1.delinword(ImportWord);
					tt1.addNowWord(ImportWord);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			} );

		return jmb;
	}
	

	private  static void initmain(){
		T1 tt1=new T1();//创建工具类
		ArrayList<String> wordin = null;
		ArrayList<String> wordnow = null;
		try {
			wordin = tt1.getinworld();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wordnow = tt1.getnowworld();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		Mianwindow widm = new Mianwindow(wordin,wordnow);
		 Logger logger = tt1.getMyLog(Mylog.class);
		 logger.debug("主窗口打开成功");
	}
	
	

	

}


