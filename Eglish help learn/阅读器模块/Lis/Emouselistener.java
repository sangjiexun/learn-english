package Lis;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
