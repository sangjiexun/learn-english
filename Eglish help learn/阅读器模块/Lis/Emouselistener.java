package Lis;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import worldshow.wordjlabel;

public class Emouselistener implements MouseListener{
	private wordjlabel wj;
	
	public  Emouselistener(wordjlabel wj) {
		this.wj=wj;		

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
     int hz=0;
     while (hz<=3){
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
            	String sword=in.next();//in.next()ʹ�ú���Զ�����
//            	if(sword.equals(inputWord.substring(0,inputWord.length()-2))){

                if(sword.equals(inputWord.substring(0,inputWord.length()-hz))){

                    int offset = inputWord.length();
                    wj.widd.tp.fy.setText(line.substring(offset));
                    wj.widd.tp.fy1.setText("��"+hz+"����׺");
                    wj.widd.tp.repaint();
                    System.out.println(wj.widd.tp.fy.getText());
                    isFound = true;
                    break;

                }  

                }

     if (isFound){
  	   break;}
     hz++;
		}
            
            
            if(!isFound){
                wj.widd.tp.fy.setText("û�ҵ���Ӧ��>..<");
            }
        

		}
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		  int mods = e.getModifiers();
          if ((mods& InputEvent.BUTTON3_MASK)!=0){
        	  System.out.println("�һ��ɹ�");
        	  System.out.println("��ʶ"+wj.ifknow);
        	  System.out.println("����ѧϰ"+wj.ifnow);
        	  searchWords(wj.name.toLowerCase());
        	  
        	  wj.ejm.show(wj, e.getX(), e.getY());
          }
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
