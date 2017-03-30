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
	
	private wordjlabel wj;
	private window  widd;
	public EJPopupMenu(wordjlabel wordjlabel,window widd){
		this.wj=wordjlabel;
		this.widd=widd;

		
		
		item1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           if (!(wj.ifknow)){
	           outjiaf();}//加入字符串容器，并且保存到电脑；
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
		

		
		
		
		
		add(item1);
		add(item2);
		add(item3);
		add(item4);
		add(item5);
		
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
	

//	
//	public static void WriteDate(String nfile) {
//
//		try{
//
//
//		FileReader read = new FileReader(new File("src/know.txt"));//打开txt
//
//		StringBuffer sb = new StringBuffer();
//
//		char ch[] = new char[1024];
//
//		int d = read.read(ch);
//
//		while(d!=-1){
//
//		String str = new String(ch,0,d);
//
//		sb.append(str);
//
//		d = read.read(ch);
//
//		}
//
//		System.out.println(sb.toString());
//
//		BufferedWriter output = new BufferedWriter(
//				new FileWriter("src/know.txt"));//保存TXT位置
//
//		output.write(String.valueOf(sb.toString()));
//
//
//		output.write(String.valueOf(nfile)+"\r\n");
//
//
//		output.close();
//
//		} catch (Exception ex) {
//
//		System.out.println(ex);
//
//		}
//
//		}

  
	
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
	//	   widd.wo.word2.remove("objective");//bug解决区
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
