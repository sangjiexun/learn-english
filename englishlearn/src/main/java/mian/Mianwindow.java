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

import tool.Mylog;
import tool.T1;
import tool.T2;

/**
 * 主窗口与程序入口
 */
public class Mianwindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public Panel1 mainpanel;//主容器	 
    public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词   
//    private ArrayList<String> kd1=new ArrayList<String>();
	
	
    /**
     * 程序入口
     * */
	public static void main(String[] args) throws ClassNotFoundException {		
		T1.initmain();
	}
	
	/**
	 * 主窗口构建
	 * */
	public Mianwindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(300,30,800,600);//设置大小
		setTitle("主窗口");//窗口的名字
		mainpanel=new Panel1(this);//创建工具栏并利用this传递参数
		add(mainpanel,BorderLayout.WEST);
		JMenuBar menuBar = createMenuBar();//创建了菜单栏并添加了
		this.setJMenuBar(menuBar);
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
		
		//导入单词的操作
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
					new TextArea();
					StringBuffer ba=new StringBuffer();
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
				
				ArrayList<String> ImportWord=new ArrayList<String>();
				ImportWord =T2.getImportWord(importWordString); 				
				System.out.println("要导入的单词："+ImportWord);
				Logger logger = T1.getMyLog(Mylog.class);
			    logger.debug("导入了单词"+ImportWord);
			
				try {
					T1.delinword(ImportWord);
					T1.addNowWord(ImportWord);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			} );

		return jmb;
	}
	
}


