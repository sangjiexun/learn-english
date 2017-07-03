package mian;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词
    
    
    public ArrayList<String> kd1=new ArrayList();
	public static void main(String[] args) {
		
		//获取数据
		ArrayList<String> wordin = inword();
		ArrayList<String> wordnow = innowword();
		
		
		 widm = new Mianwindow(wordin,wordnow);
//		 actionPerformed();
		 
	}
	
	
	public Mianwindow(ArrayList<String> w1 ,ArrayList<String> w2) {
		this.word1=w1;
		this.word2 =w2;
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
//			        System.out.println(t);
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
			       
//			        System.out.println(ba);
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
//		     	 System.out.println(tn);
		     	 if(!(tn.equals(""))){
		     		 kd1.add(tn);
		     		 
		     	 }
		     	 tn="";}
//		     	   System.out.println(c);
		     	

		     		   }
		     	   ti++;
		     	   }
		        
		        				
				System.out.println("要导入的单词："+kd1);
				
				for (int i=0;i<kd1.size();i++){
	
			if(ifinWords(kd1.get(i))&&
			!(word2.contains(kd1.get(i)))){
                 if(word1.contains(kd1.get(i))){
                	 word1.remove(kd1.get(i)); 
                 }
				     word2.add(kd1.get(i));
			}
			

		}
			
				outnow();	
				out();
				
			}
			} );
	       

		
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
                   while((lineTxt = bufferedReader.readLine())!= null)  
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
	
	
	
	public static ArrayList<String> inword(){
    	
    	ArrayList<String> w1 = null;
    	try {
			ObjectInputStream in=new ObjectInputStream(
	new FileInputStream("C:/Users/Administrator/Desktop/代码合集/obj.txt"));
			
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
	new FileInputStream("C:/Users/Administrator/Desktop/代码合集/now.txt"));
			
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
	
	
	protected boolean ifinWords(String inputWord) {
		boolean isFound = false;
		try {
            BufferedReader br = new BufferedReader(
         new FileReader("C:/Users/Administrator/Desktop/代码合集/dictionary.txt"));
            
            String line ;
            System.out.println(inputWord);
            if(inputWord.equals("")){
                return isFound;
            }
                         
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
 
                if(in.next().equals(inputWord)){
                    int offset = inputWord.length();
                  
                    isFound = true;
                    break;
                }
 
        }
            
		}
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
		return isFound;

	}
	
	
	public void outnow(){
		   		   
    	try{
	    		
	    		ObjectOutputStream out=new ObjectOutputStream(
	    				new FileOutputStream(
	    						"C:/Users/Administrator/Desktop/代码合集/now.txt"));
	    		out.writeObject(word2);
	    		out.close();
	    	}catch(IOException e ){
	    		e.printStackTrace();
	    	}
	    	
	   }
	
	public void out(){
		   
		   
    	try{
	    		
	    		ObjectOutputStream out=new ObjectOutputStream(
	    				new FileOutputStream(
	    						"C:/Users/Administrator/Desktop/代码合集/obj.txt"));
	    		out.writeObject(word1);
	    		out.close();
	    	}catch(IOException e ){
	    		e.printStackTrace();
	    	}
	    	
	   }
	
	
}


	


