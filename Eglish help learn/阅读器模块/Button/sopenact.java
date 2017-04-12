package Button;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import english_reader.window;

public class sopenact implements ActionListener {
	
	window db;
	private StringBuffer ba;
	public String t;
	public sopenact(window Drb){
		 db=Drb;
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		ba=new StringBuffer();
		
        db.qingkong();
        
		ba=new StringBuffer();
	
        String  t=db.t;
//        System.out.println(t);
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
	
		db.text=ba.toString();
		db.zairu();


	}
	

}
