package read.wordshow;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import read.english_reader.readWindow;
 

public class Word extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private readWindow widd;
	
	public ArrayList<String> word1;//in
	public ArrayList<String> word2;//now
	
	int x=50;
	int y=10;
	int count  =0;
    int count1 =0;
	int count2 =0;
	
	static String text;
	public  Word (readWindow window,String sentence){
		
		widd=window;

		word1=widd.word1;
		word2=widd.word2;
		System.out.println("word2:"+word2);
		setBackground(new Color(50,50,50));

	    setLayout(null);
	    
        sentence+="%";
        int l=sentence.length();
        int ti=0;
        String tn="";

        while (!(sentence.substring(ti, ti+1).equals("%"))){
     	   char c = sentence.charAt(ti);
     	   if((c>=65&&c<=90)||(c>=97&&c<=125)){
     	   tn+=c;
            }
     	   else if(c==44){//,��ascllֵ��44��
     	   
     	   creatWJL(x, y, tn);
     	   creatWJL(x, y, ",");
     	  
            tn="";   
     	   }
     	   else if(c==46){//.��ascllֵ��44��
         	   
            creatWJL(x, y, tn);
         	creatWJL(x, y, ".");
                tn="";   
         	   }
     	   else if(c==63){//?��ascllֵ��63��
         	  
         	 creatWJL(x, y, tn);
         	 creatWJL(x, y, "?");
                tn="";   
         	   }
     	  else if(c==36){//$��ascllֵ��63��
               x=50;
               y+=20;
               tn="";   
        	   }
     	   else {
     	
     	  creatWJL(x, y, tn);
//     	  System.out.println(tn);
     	   tn="";
  
     		   }
     	   ti++;
     	   }
        
        
//        T1 tt1=new T1();
//        tt1.WriteData(text);
		widd.tp.unknow.setText("未知单词数："+count1);
		widd.tp.unknowl.setText("未知率："+count1*100/count+"%");
		widd.tp.wordnumber.setText("总单词数："+count);
		widd.tp.learning.setText("在学单词数："+count2);
		repaint();
	}
	
	
        public void wordshow(){
		TextArea t=widd.ta;
	} 
	

        
        protected boolean ifWsords(String input) {
       	boolean isFound = false;


   		if (word1.contains(input.toLowerCase())){
   			isFound=true;
   		}

		return isFound;

   	}
      
        
        protected boolean ifnowWords(String input) {
       	boolean isFound = false;

   		if (word2.contains(input.toLowerCase())){
   			isFound=true;
   		}

		return isFound;
   	}

        
    public void creatWJL( int x,int y,String z){//创建单词标签
    	
		Font wz=new java.awt.Font("Dialog", 1,15);
		FontMetrics fm = new JLabel().getFontMetrics(wz);
    	int len=(int) ((fm.stringWidth( z )));
    	if(!(z.equals(""))){
    	add(new wordjlabel(x,y,len,z,wz,widd,ifWsords(z),ifnowWords(z)));
//    	System.out.println(z);
    	if(!(ifWsords(z))){
    	count1++;	
    	}
    	else{
    		text+=(" "+z);
    	}
    	if(ifnowWords(z)){
        	count2++;	
        	text+=(" "+z);
        	}
    	
    	count++;
    	
        this.x+=len+10;
        if (this.x>600){
        	this.x=10;
        	this.y+=20;
        }
    	}
    	
}

}
