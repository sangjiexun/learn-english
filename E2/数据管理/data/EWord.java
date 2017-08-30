package data;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import english_reader.window;

public class EWord {
private String englishword;
private String chineseword;
private int Otime ;
private Date lasttime;
private static StringBuffer ba;
private static ArrayList<String> wll;
private static ArrayList<EWord> EWL;

public EWord(String englishword){
	this.englishword=englishword;
}

public EWord(String englishword,String chineseword){
	this.englishword=englishword;
	this.chineseword=chineseword;
}

public static void main(String[] args) {
	
ArrayList<EWord> EWL = new ArrayList<EWord>();
	EWL=daoru();
	System.out.println(EWL.toString());
}


public static  void dd (String ba){

    ba+="%";
    int l=ba.length();
    int ti=0;
    String tn=new String();
    tn="";
    wll=new ArrayList<String>();
    while (!(ba.substring(ti, ti+1).equals("%"))){
 	   char c = ba.charAt(ti);
 	   if((c>=65&&c<=90)||(c>=97&&c<=125)){
 	   tn+=c;
        }
 	   else if(c==44){//,的ascll值是44；
// 	   System.out.println("999");
// 	 wll.add(",");
 	  
        tn="";   
 	   }
 	   else if(c==46){//.的ascll值是44；
     	   
// 		  wll.add(".");
            tn="";   
     	   }
 	   else if(c==63){//?的ascll值是63；
     	  
// 		  wll.add("?");
            tn="";   
     	   }
 	  else if(c==36){//$的ascll值是63；
 		  wll.add(tn);
           tn="";   
    	   }
 	   else {
 	
// 	  creatWJL(x, y, tn);
// 	  System.out.println(tn);
 		   wll.add(tn);
 	   tn="";

 		   }
 	   ti++;
 	   }
 
  
}



protected static ArrayList<EWord> daoru() {
	ArrayList<EWord> EWL1 = null;
	try {
        BufferedReader br = new BufferedReader(
     new FileReader("C:/Users/Administrator/Desktop/代码合集/dictionary.txt"));
        String line ;
        String chinese;
         
        while((line = br.readLine()) != null){
            Scanner in = new Scanner(line);
        	String sword=in.next();//in.next()使用后会自动换行
            int offset = sword.length();
            chinese=line.substring(offset);
            EWL1=new ArrayList<EWord>();
            EWL1.add(new EWord(sword,chinese));
        	System.out.println(sword+chinese);
        	
            }
 br.close();
             
	}
    catch (Exception ex) {
        ex.printStackTrace();
    }
	
return EWL1;
}










}
