package Button;
//工具栏
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Lis.openact;
import english_reader.window;
import test.T1;
import worldshow.wordjlabel;


public  class Tool_panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	private window widd;
	public wordshuxing fy,fy1,wordnumber,unknow,unknowl,learning;
	public JTextField t1,t2;
	
	
	public Tool_panel(window window){
		//添加操作按钮
		this.widd=window;
		
		{
		setLayout(null);
		setPreferredSize(new Dimension(200, 50));//�������Ŀ�ȣ�
		setBackground(new Color(60,60,60));
	
		}//工具栏的基本属性
		
		fy=new wordshuxing(10, 10, 40,"我是翻译:");
		fy1=new wordshuxing(10, 60, 40,"我是备注:");
		unknow=new wordshuxing(10, 110,30, " 未知单词数：");
		unknowl=new wordshuxing(10, 150,30, " 未知：");
		add(new wordshuxing(10, 190,30, " 陌生率："));
		wordnumber=new wordshuxing(10, 230,30, " 总单词数：");
		learning=new wordshuxing(10, 270,60, " 空白备用区域");
		
		t1 =new Etextfield(10 , 450 ,150 ,20);
		t2=new Etextfield(10 , 490 ,150 ,20);

		
		add(unknow);
		add(unknowl);
		add(fy);
		add(fy1);
		add(wordnumber);
		add(learning);	
		add(t1);
		add(t2);
	
		
		JButton OT=new JButton(" open");
		OT.setBackground(new Color(20,20,20));
		OT.setForeground(Color.white);
		OT.setBorder(new LineBorder(new Color(40,40,40)));
		OT.setBounds(10,370, 70, 60);
		
		JButton OT2=new JButton(" 刷新");
		OT2.setBounds(90,370, 70, 30);
		OT2.setBackground(new Color(20,20,20));
		OT2.setForeground(Color.white);
		OT2.setBorder(new LineBorder(new Color(40,40,40)));
		
		JButton OT3=new JButton(" 自留按钮");
		OT3.setBounds(20,580, 120, 30);
		OT3.setBorder(new LineBorder(Color.CYAN));
		
		JButton FT=new JButton(" 添加翻译");
		FT.setBackground(new Color(0,166,80));
		FT.setBounds(20,540, 120, 30);
		FT.setBorder(new LineBorder(Color.CYAN));
		
		OT.addActionListener(new openact(widd));
		OT2.addActionListener(new sopenact(widd));
		FT.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				T1 tt1=new T1();
				if(!(t1.getText()==""||t2.getText()=="")){
				
				try {
					tt1.insertdictionary(t1.getText(), t2.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				WriteDate(t1.getText()+"  "+t2.getText());

				t1.setText("");
				t2.setText("");
				}
			}
			
		}
				);

		add(FT);
		add(OT);//open text button;
		add(OT2);
		add(OT3);
		
	}

}
