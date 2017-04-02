package worldshow;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.TextArea;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

import english_learn.window;
 

public class Word extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private window widd;
	public ArrayList<String> word1;
	public ArrayList<String> word2;
	
	int x=50;
	int y=10;
	int count  =0;
    int count1 =0;
	int count2 =0;
	
	public  Word (window window,String sentence){
		
		widd=window;
		setLayout(null);
		
		
		word1=new ArrayList<String>();
//		word1=getWal();
//		outf();
		word1=inword();
		word2=innowword();
//        String sentence =widd.text;
        Scanner s = new Scanner(sentence).useDelimiter(" ");//用空格分离单词
       

//  改进方案：
        sentence+="%";
        int l=sentence.length();
        int ti=0;
        String tn="";

        while (!(sentence.substring(ti, ti+1).equals("%"))){
     	   char c = sentence.charAt(ti);
     	   if((c>=65&&c<=90)||(c>=97&&c<=125)){
     	   tn+=c;
            }
     	   else if(c==44){//,的ascll值是44；
     	   
     	   creatWJL(x, y, tn);
     	   creatWJL(x, y, ",");
     	  
            tn="";   
     	   }
     	   else if(c==46){//.的ascll值是44；
         	   
         	  creatWJL(x, y, tn);
         	 creatWJL(x, y, ".");
                tn="";   
         	   }
     	   else if(c==63){//?的ascll值是63；
         	  
         	  creatWJL(x, y, tn);
         	  creatWJL(x, y, "?");
                tn="";   
         	   }
     	  else if(c==36){//?的ascll值是63；
               x=50;
               y+=20;
               tn="";   
        	   }
     	   else {
     	
     	  creatWJL(x, y, tn);
     	   tn="";
  
     		   }
     	   ti++;
     	   }
        
 
        
		widd.tp.unknow.setText("未知单词数："+count1);
		widd.tp.unknowl.setText("未知率："+count1*100/count+"%");
		widd.tp.wordnumber.setText("总单词数："+count);
		widd.tp.learning.setText("在学单词数："+count2);
	}
	
	
        public void wordshow(){
		TextArea t=widd.ta;
	} 
	
        

        
        
        public ArrayList<String> inword(){
        	
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
        
        
 public ArrayList<String> innowword(){
        	
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
        
        
        
        
        
        
        
   //备用判断方法     
//        public boolean ifWords(String input) {
//        	 boolean isFound = false;
//    		try {
//                BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
//                String line;
//       
//                             
//                while((line = br.readLine()) != null){
//                    Scanner in = new Scanner(line);
//     
//                    if(in.next().equals(input.toLowerCase())){
////                        wj.widd.tp.show();
//                    	
//                        isFound = true;
//                        break;
//                    }
//                }
//                 
//               
//            }
//            catch (Exception ex) {
//                ex.printStackTrace();
//            }
//			return isFound;
// 
//    	}
        
        public boolean ifWsords(String input) {
       	boolean isFound = false;
//   		int z0=0;
//   		int z1=word1.size();
//   		while (true){
//   			if(input.compareTo(word1.get((z0+z1)/2))==0){
//   				return true;
//   			}else if(input.compareTo(word1.get((z0+z1)/2))>0){
//   				z0=(z0+z1)/2;
//   			}else{
//   				z1=(z0+z1)/2;
//   			}
//	
//   		}
   		if (word1.contains(input.toLowerCase())){
   			isFound=true;
   		}
   		
   		
       	
		return isFound;

   	}
      
        
        public boolean ifnowWords(String input) {
       	boolean isFound = false;
//   		int z0=0;
//   		int z1=word1.size();
//   		while (true){
//   			if(input.compareTo(word1.get((z0+z1)/2))==0){
//   				return true;
//   			}else if(input.compareTo(word1.get((z0+z1)/2))>0){
//   				z0=(z0+z1)/2;
//   			}else{
//   				z1=(z0+z1)/2;
//   			}
//	
//   		}
   		if (word2.contains(input.toLowerCase())){
   			isFound=true;
   		}
   		
   		
       	
		return isFound;

   	}
        
        
        
        
    public void creatWJL( int x,int y,String z){//创建单词标签
		Font wz=new Font("宋体",Font.PLAIN,16);
		FontMetrics fm = new JLabel().getFontMetrics(wz);
    	int len=fm.stringWidth( z );
    	if(!(z.equals(""))){
    	add(new wordjlabel(x,y,len,z,wz,widd,ifWsords(z),ifnowWords(z)));
    	if(!(ifWsords(z))){
    	count1++;	
    	}
    	if(ifnowWords(z)){
        	count2++;	
        	}
    	
    	count++;
    	
        this.x+=len+10;
        if (this.x>600){
        	this.x=10;
        	this.y+=20;
        }
    	}
    	
}
        
    public void outf(){
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
