package Button;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import english_learn.window;

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
		try {
            t=db.t;
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
		                    new FileInputStream(t)));
           String lineTxt = null;
           while(  (lineTxt = bufferedReader.readLine())!= null)  
           { 
//           ta.append(lineTxt);
           ba.append(lineTxt+" $ "+"\r\n");
           }
           bufferedReader.close();
}catch (Exception e1) {
   System.out.println("��ȡ�ļ����ݳ���");
   e1.printStackTrace();
}
//System.out.println(ba);

db.text=ba.toString();
db.zairu();
		
	}

}
