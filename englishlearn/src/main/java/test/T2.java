package test;

import java.util.ArrayList;

/**数据处理类用工具类
 * */
public class T2 {

	public ArrayList<String> getImportWord(String importWordString ){
		ArrayList<String> ImportWord=new ArrayList<String>();
		importWordString+='%';
        int ti=0;
        String tn="";
        while (!(importWordString.substring(ti, ti+1).equals("%"))){
     	   char c = importWordString.charAt(ti);
     	   if((c>=65&&c<=90)||(c>=97&&c<=125)){
     	   tn+=c;
            } 
     	   else if(!(c==13||c==36||c==20)&&(c==32)){
//     	 System.out.println(tn);
     	 if(!(tn.equals(""))){
     		ImportWord.add(tn);		     		 
     	 }
     	 tn="";} 
     	   ti++;
     	   }		    
		return ImportWord;
	}

}
