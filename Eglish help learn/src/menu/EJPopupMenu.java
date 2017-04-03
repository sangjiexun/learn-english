package menu;
//右击显示的内容
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import english_learn.window;
import worldshow.wordjlabel;

public class EJPopupMenu extends JPopupMenu{
	private static final long serialVersionUID = 1L;
	
	JMenuItem item1 = new JMenuItem("加入已会单词");

	JMenuItem item2 = new JMenuItem("添加翻译"); 
 
	JMenuItem item3 = new JMenuItem("加入正在学习的单词");
	
	JMenuItem item4 = new JMenuItem("翻译");
	
	JMenuItem item5 = new JMenuItem("加入未知单词");
	
	JMenuItem item6 = new JMenuItem("百度搜索");
	
	
	private wordjlabel wj;
	private window  widd;
	public EJPopupMenu(wordjlabel wordjlabel,window widd){
		this.wj=wordjlabel;
		this.widd=widd;

		
		
		item1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           if (!(wj.ifknow)){
	           outjiaf();}//加入字符串容器，并且保存到本地；
	        }
	    });
		
		item2.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           widd.tp.t1.setText(wj.name.toLowerCase()); 
	        }
	    });
		
		item3.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           if (!(wj.ifknow)){
	           outnowjiaf();}//加入正在学习的单词
	        }
	    });
		

		
		item4.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            searchWords( wj.name.toLowerCase());
	        }
	    });
		
		
		item5.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           if (wj.ifknow){
	           outjianf();}//删除字符串容器，并且保存到电脑；
	        }
	    });
		

		item6.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){ 
	        	   try { 
	        		    String url = "http://www.baidu.com/s?wd="+wj.name; 
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
	    });
		
		
		
		
		
		add(item1);
		add(item2);
		add(item3);
		add(item4);
		add(item5);
		add(item6);
		
	}


	

	protected void searchWords(String inputWord) {
		try {
            BufferedReader br = new BufferedReader(
         new FileReader("C:/Users/Administrator/Desktop/代码合集/dictionary.txt"));
            String line ;
            boolean isFound = false;
             
            System.out.println(inputWord);
            if(inputWord.equals("")){
                return;
            }
                         
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
 
                if(in.next().equals(inputWord)){
                    int offset = inputWord.length();
                    wj.widd.tp.fy.setText(line.substring(offset));
                    wj.widd.tp.repaint();
                    System.out.println(wj.widd.tp.fy.getText());
                    isFound = true;
                    break;
                }
            
             
            if(!isFound){
                wj.widd.tp.fy.setText("没找到相应项>..<");
            }
        }
		}
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
		
	}
	


  
	
	   public void outjiaf(){

   
		   widd.wo.word1.add(wj.name.toLowerCase());
		   outnowjianf();
		   out();
	    	
	    	
	    }
	
	   public void outjianf(){

		   
		   widd.wo.word1.remove(wj.name.toLowerCase());
		   
		   out();
	    	
	    }
	
	   public void out(){
		   
		   
    	try{
	    		
	    		ObjectOutputStream out=new ObjectOutputStream(
	    				new FileOutputStream(
	    						"C:/Users/Administrator/Desktop/代码合集/obj.txt"));
	    		out.writeObject(widd.wo.word1);
	    		out.close();
	    	}catch(IOException e ){
	    		e.printStackTrace();
	    	}
	    	
	   }
	
	
	   public void outnowjiaf(){

		   
		   widd.wo.word2.add(wj.name.toLowerCase());
//		   widd.wo.word2.remove("hello world");//bug解决区
		   System.out.println("jiar");
		   outnow();
	    	
	    	
	    }
	   
	   
  public void outnowjianf(){

		   
		   widd.wo.word2.remove(wj.name.toLowerCase());
		   System.out.println("jiar");
		   outnow();
	    	
	    }
	   
	   
	   public void outnow(){
		   
		   
	    	try{
		    		
		    		ObjectOutputStream out=new ObjectOutputStream(
		    				new FileOutputStream(
		    						"C:/Users/Administrator/Desktop/代码合集/now.txt"));
		    		out.writeObject(widd.wo.word2);
		    		out.close();
		    	}catch(IOException e ){
		    		e.printStackTrace();
		    	}
		    	
		   }


	}
