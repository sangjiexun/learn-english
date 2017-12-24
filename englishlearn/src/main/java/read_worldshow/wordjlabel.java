package read_worldshow;
//阅读的单词由标签构成
//标签类的设计
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import read_Lis.Emouselistener;
import read_english_reader.window;
import read_menu.EJPopupMenu;

public class wordjlabel extends JLabel{
	
	private static final long serialVersionUID = 1L;
	public EJPopupMenu ejm;
	public window widd;
	public String name;
	public boolean  ifknow ,ifnow;
	public wordjlabel(int i,int j,int l,String name,
			Font z,window widd,boolean g,boolean g1){
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
//			System.out.println(name);//查1号bug区
			}
		
		ejm=new EJPopupMenu(this,widd);
		this.add(ejm);
		this.addMouseListener(new Emouselistener(this));
		
	}

}
