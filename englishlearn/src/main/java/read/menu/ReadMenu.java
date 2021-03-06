package read.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import read.english_reader.readWindow;
import read.wordshow.wordjlabel;
import tool.T1;
/**右击的菜单*/
public class ReadMenu extends JPopupMenu{
	private static final long serialVersionUID = 1L;
	
	JMenuItem item1 = new JMenuItem("加入已会单词");
	JMenuItem item2 = new JMenuItem("添加翻译"); 
	JMenuItem item3 = new JMenuItem("加入正在学习的单词");
	JMenuItem item4 = new JMenuItem("翻译");
	JMenuItem item5 = new JMenuItem("加入未知单词");
	JMenuItem item6 = new JMenuItem("百度搜索");

	private wordjlabel wj;
	private readWindow  widd;
	public ReadMenu(wordjlabel wordjlabel,final readWindow widd){
		this.wj=wordjlabel;
		this.widd=widd;
//		searchWords( wj.name.toLowerCase());
		
		
		item1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           
	           try {
				outjiaf();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
	           }//加入字符串容器，并且保存到本地；
	        
	    });
		
		item2.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){        	
	       widd.tp.t1.setText(wj.name.toLowerCase());      
	        }
	    });
		
		
		item3.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
//	        	System.out.println("jiaruchgong");
	           if (!((wj.ifknow)||(wj.ifnow))){
	           try {
				outnowjiaf();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} 
	           
	           }//加入正在学习的单词
	        }
	    });
		

		
		item4.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
//	            searchWords( wj.name.toLowerCase());
	        	T1 tt1=new T1();
	            try {
					wj.widd.tp.fy.setText(tt1.searchWords(wj.name.toLowerCase()));
				System.out.println("kk");
	            } catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
	        }
	    });
		
		
		item5.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           if (wj.ifknow){
	           outjianf();}
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


	
	   public void outjiaf() throws ClassNotFoundException{
		   widd.wo.word1.add(wj.name.toLowerCase());
		   outnowjianf();
		   T1.addinword(wj.name.toLowerCase());
		   T1.setlasttime(wj.name.toLowerCase());
	    }
	
	   
	   public void outjianf(){
		   widd.wo.word1.remove(wj.name.toLowerCase());
		   try {
			T1.delinword(wj.name.toLowerCase());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    }

	
	   public void outnowjiaf() throws ClassNotFoundException{
		  
		   T1.addNowWord(wj.name.toLowerCase());
		   widd.wo.word2.add(wj.name.toLowerCase());

	    }
	   
	   
  public void outnowjianf() throws ClassNotFoundException{

		   widd.wo.word2.remove(wj.name.toLowerCase());
		   T1.delnowword(wj.name.toLowerCase());
	    }

	}
