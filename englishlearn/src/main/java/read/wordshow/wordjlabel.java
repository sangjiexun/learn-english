package read.wordshow;
//阅读的单词由标签构成
//标签类的设计
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import read.english_reader.readWindow;
import read.menu.ReadMenu;
import tool.T1;

public class wordjlabel extends JLabel{
	
	private static final long serialVersionUID = 1L;
	public ReadMenu ejm;
	public readWindow widd;
	public String name;
	public boolean  ifknow ,ifnow;
	public wordjlabel(int i,int j,int l,String name,
			Font z,readWindow widd,boolean g,boolean g1){
		super(name);//	起始位置，长度，单词，标签高，是否是不会的单词，是否是正在学习的单词

		ifknow=g;
		ifnow=g1;
		this.name=name;
		this.widd =widd;
		this.setFont(z);
		this.setLayout(null);
		this.setBounds(i,j,l,15);
		setForeground(Color.white);
		this.setBackground(Color.lightGray);

		if(!(ifknow)){
//		setOpaque(true);
		setForeground(Color.lightGray);
		}
		
		if(ifnow){
//			this.setBackground(Color.yellow );
			setForeground(Color.yellow);
			}
		ejm=new ReadMenu(this,widd);
		this.add(ejm);
		this.addMouseListener(new Emouselistener(this));
		
	}
	
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
	
	

}
