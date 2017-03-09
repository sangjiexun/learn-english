package worldshow;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Lis.Emouselistener;
import english_learn.window;
import menu.EJPopupMenu;

public class wordjlabel extends JLabel{
	private static final long serialVersionUID = 1L;
	
	public EJPopupMenu ejm;
	public window widd;
	public String name;
	public boolean  ifknow;
	public wordjlabel(int i,int j,int l,String name,Font z,window widd,boolean g,boolean g1){
		super(name);
		ifknow=g;
		this.name=name;
		this.widd =widd;
		this.setFont(z);
		this.setLayout(null);
		this.setBounds(i,j,l,15);
		this.setBackground(Color.lightGray);
		if(g1){
		this.setBackground(Color.yellow );
		}
		

		if(!g){
		setOpaque(true);}
		ejm=new EJPopupMenu(this,widd);
		this.add(ejm);
		this.addMouseListener(new Emouselistener(this));
	}
	

}
