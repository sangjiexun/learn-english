package read_Lis;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import test.T1;
import read_worldshow.wordjlabel;

public class Emouselistener implements MouseListener{
	private wordjlabel wj;
	
	public  Emouselistener(wordjlabel wj) {
		this.wj=wj;		

	}

	public void mouseClicked(MouseEvent e) {
		  int mods = e.getModifiers();
          if ((mods& InputEvent.BUTTON3_MASK)!=0){
        	  System.out.println("右击成功");
        	  System.out.println("认识"+wj.ifknow);
        	  System.out.println("正在学习"+wj.ifnow);
        	  try {
				wj.widd.tp.fy.setText(T1.searchWords(wj.name.toLowerCase()));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
//        	  searchWords(wj.name.toLowerCase());
        	 
        	  wj.ejm.show(wj, e.getX(), e.getY());
          }
		

	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
