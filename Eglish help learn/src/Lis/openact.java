package Lis;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import english_learn.window;


public class openact implements ActionListener{
	     private TextArea ta;
	     private StringBuffer ba;
	     window db;
		 public openact(window Drb){
			 db=Drb;
		 }
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ta=new TextArea();
		ba=new StringBuffer();
		FileDialog my=new FileDialog(db);
        my.setVisible(true);
        String t=my.getDirectory()+my.getFile();
//        System.out.println(t);
        try {


					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
				                    new FileInputStream(t)));
                   String lineTxt = null;
                   while(  (lineTxt = bufferedReader.readLine())!= null)  
                   { 
//                   ta.append(lineTxt);
                   ba.append(lineTxt+" $ "+"\r\n");
                   }
                   bufferedReader.close();
        }catch (Exception e1) {
           System.out.println("��ȡ�ļ����ݳ���");
           e1.printStackTrace();
       }
//		System.out.println(ba);
		
		db.text=ba.toString();
		db.zairu();
//		db.ta=ta;
//		db.wo.wordshow();
	}

}
