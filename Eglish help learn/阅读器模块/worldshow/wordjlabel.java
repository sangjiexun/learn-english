package worldshow;
//�Ķ��ĵ����ɱ�ǩ����
//��ǩ������
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Lis.Emouselistener;
import english_reader.window;
import menu.EJPopupMenu;

public class wordjlabel extends JLabel{
	
	private static final long serialVersionUID = 1L;
	public EJPopupMenu ejm;
	public window widd;
	public String name;
	public boolean  ifknow ,ifnow;
	public wordjlabel(int i,int j,int l,String name,
			Font z,window widd,boolean g,boolean g1){
		super(name);//	��ʼλ�ã����ȣ����ʣ���ǩ�ߣ��Ƿ��ǲ���ĵ��ʣ��Ƿ�������ѧϰ�ĵ���

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
//			System.out.println(name);//��1��bug��
			}
		
		
		ejm=new EJPopupMenu(this,widd);
		this.add(ejm);
		this.addMouseListener(new Emouselistener(this));
		
	}
	

}
