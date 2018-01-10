package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**流操作工具类
 * */
public class T4 {

	public static StringBuffer getWordStringBuffer(String t) {
		StringBuffer ba=new StringBuffer();
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

		return ba;
	}

	public static String readDate(){
		String sb = new String();
		
		try{
        
	    BufferedReader br = new BufferedReader(new FileReader
	    		("C:/Users/Administrator/Desktop/代码合集/grade.txt"));
		
        sb=br.readLine();

        System.out.println(sb);

		} catch (Exception ex) {

		System.out.println(ex);
		}
		return sb;

		}
	
	 public static void WriteDate(String nfile) {

			try{

			BufferedWriter output = new BufferedWriter(new FileWriter
					("C:/Users/Administrator/Desktop/代码合集/grade.txt"));

			output.write(String.valueOf(nfile)+"\r\n");


			output.close();

			} catch (Exception ex) {

			System.out.println(ex);

			}

			}
	
	
	
	
	
	

}
