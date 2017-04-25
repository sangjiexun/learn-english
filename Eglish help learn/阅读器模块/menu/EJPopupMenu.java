package menu;
//�һ���ʾ������
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
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

import english_reader.window;
import worldshow.wordjlabel;

public class EJPopupMenu extends JPopupMenu{
	private static final long serialVersionUID = 1L;
	
	JMenuItem item1 = new JMenuItem("�����ѻᵥ��");

	JMenuItem item2 = new JMenuItem("��ӷ���"); 
 
	JMenuItem item3 = new JMenuItem("��������ѧϰ�ĵ���");
	
	JMenuItem item4 = new JMenuItem("����");
	
	JMenuItem item5 = new JMenuItem("����δ֪����");
	
	JMenuItem item6 = new JMenuItem("�ٶ�����");
	
	
	private wordjlabel wj;
	private window  widd;
	public EJPopupMenu(wordjlabel wordjlabel,window widd){
		this.wj=wordjlabel;
		this.widd=widd;
//		searchWords( wj.name.toLowerCase());
		
		
		item1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	           
	           outjiaf();
	           }//�����ַ������������ұ��浽���أ�
	        
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
	           outnowjiaf();
	           }//��������ѧϰ�ĵ���
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
	           outjianf();}//ɾ���ַ������������ұ��浽���ԣ�
	        }
	    });
		

		item6.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){ 
	        	   try { 
	        		    String url = "http://www.baidu.com/s?wd="+wj.name; 
	        		    java.net.URI uri = java.net.URI.create(url); 
	        		    // ��ȡ��ǰϵͳ������չ 
	        		    java.awt.Desktop dp = java.awt.Desktop.getDesktop(); 
	        		    // �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ��� 
	        		    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) { 

	        		      dp.browse(uri);// ��ȡϵͳĬ������������� 

	        		    } 
	        		   } catch (java.lang.NullPointerException f) { 
	        		    // ��ΪuriΪ��ʱ�׳��쳣 
	        		    f.printStackTrace(); 
	        		   } catch (java.io.IOException f) { 
	        		    // ��Ϊ�޷���ȡϵͳĬ������� 
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
         new FileReader("C:/Users/Administrator/Desktop/����ϼ�/dictionary.txt"));
            String line ;
            boolean isFound = false;
             
//            System.out.println(inputWord.substring(0,inputWord.length()-1));
            if(inputWord.equals("")){
                return;
            }
                         
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
            	String sword=in.next();//in.next()ʹ�ú���Զ�����
                if(sword.equals(inputWord)){

                    int offset = inputWord.length();
                    wj.widd.tp.fy.setText(line.substring(offset));
                    wj.widd.tp.fy1.setText("�Ҿ���ԭ��");
                    wj.widd.tp.repaint();
                    System.out.println(wj.widd.tp.fy.getText());
                    isFound = true;
                    break;
      
                }
               
                else if(sword.equals(inputWord.substring(0,inputWord.length()-1))){
                    int offset = inputWord.length();
                    wj.widd.tp.fy.setText(line.substring(offset));
                    wj.widd.tp.fy1.setText("ԭ�ͣ�"+sword);
                    wj.widd.tp.repaint();
                    System.out.println(wj.widd.tp.fy.getText()+"(��һ����׺");
                    isFound = true;
                    break;
                }
                else if(sword.equals(inputWord.substring(0,inputWord.length()-2))){
                    int offset = inputWord.length();
                    wj.widd.tp.fy.setText(line.substring(offset));
                    wj.widd.tp.fy1.setText("ԭ�ͣ�"+sword);
                    wj.widd.tp.repaint();
                    System.out.println(wj.widd.tp.fy.getText()+"(��������׺");
                    isFound = true;
                    break;
                }
            if(!isFound){
                wj.widd.tp.fy.setText("û�ҵ���Ӧ��>..<");
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
	    						"C:/Users/Administrator/Desktop/����ϼ�/obj.txt"));
	    		out.writeObject(widd.wo.word1);
	    		out.close();
	    	}catch(IOException e ){
	    		e.printStackTrace();
	    	}
	    	
	   }
	
	
	   public void outnowjiaf(){

		   
		   widd.wo.word2.add(wj.name.toLowerCase());
//		   widd.wo.word2.remove("tame");//1��bug�����
//		   System.out.println("jiar");
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
		    						"C:/Users/Administrator/Desktop/����ϼ�/now.txt"));
		    		out.writeObject(widd.wo.word2);
		    		out.close();
		    	}catch(IOException e ){
		    		e.printStackTrace();
		    	}
		    	
		   }


	}
