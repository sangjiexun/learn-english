package Lis;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import test.T1;
import worldshow.wordjlabel;

public class Emouselistener implements MouseListener{
	private wordjlabel wj;
	
	public  Emouselistener(wordjlabel wj) {
		this.wj=wj;		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		  int mods = e.getModifiers();
          if ((mods& InputEvent.BUTTON3_MASK)!=0){
        	  System.out.println("右击成功");
        	  System.out.println("认识"+wj.ifknow);
        	  System.out.println("正在学习"+wj.ifnow);
        	  T1 tt1=new T1();
        	  try {
				wj.widd.tp.fy.setText(tt1.searchWords(wj.name.toLowerCase()));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
//        	  searchWords(wj.name.toLowerCase());
        	 
        	  wj.ejm.show(wj, e.getX(), e.getY());
          }
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
