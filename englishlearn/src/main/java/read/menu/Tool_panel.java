package read.menu;
/**右边的工具栏*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import read.english_reader.readWindow;
import tool.T1;
import tool.T4;


/**
 * 工具栏
 */
public  class Tool_panel extends JPanel{


	private static final long serialVersionUID = 2L;
	
	
	private readWindow widd;
	public wordshuxing fy,fy1,wordnumber,unknow,unknowl,learning;
	public JTextField t1,t2;
	
	
	public Tool_panel(readWindow window){
		//添加操作按钮
		this.widd=window;
		
		{
		setLayout(null);
		setPreferredSize(new Dimension(200, 50));//�������Ŀ�ȣ�
		setBackground(new Color(60,60,60));
	
		}//工具栏的基本属性
		
		fy=new wordshuxing(1,"我是翻译:");
		fy1=new wordshuxing(2,"我是备注:");
		unknow=new wordshuxing(3, " 未知单词数：");
		unknowl=new wordshuxing(4, " 未知：");
		add(new wordshuxing(5, " 陌生率："));
		wordnumber=new wordshuxing(6, " 总单词数：");
		learning=new wordshuxing(7, " 空白备用区域");
		
		t1 =new JTextField();
		t1.setBounds(10 , 450 ,150 ,20);
		t2=new JTextField();
		t2.setBounds(10 , 490 ,150 ,20);

		
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
		
		JButton OT3=new JButton(" 备用按钮");
		OT3.setBounds(20,580, 120, 30);
		OT3.setBorder(new LineBorder(Color.CYAN));

		
		JButton FT=new JButton(" 添加翻译");
		FT.setBackground(new Color(0,166,80));
		FT.setBounds(20,540, 120, 30);
		FT.setBorder(new LineBorder(Color.CYAN));
		
		OT.addActionListener(new openact(widd));
		OT2.addActionListener(new refurbish(widd));
		FT.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				T1 tt1=new T1();
				if(!(t1.getText()==""||t2.getText()=="")){
				
				try {
					tt1.insertdictionary(t1.getText(), t2.getText());
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
//				WriteDate(t1.getText()+"  "+t2.getText());

				t1.setText("");
				t2.setText("");
				}
			}
			
		}
				);

		OT3.addActionListener(
				new ActionListener(){
				public void actionPerformed(ActionEvent e){
			    widd.setVisible(false);
			    String text=null;
//			    for(String text1 )			    
			    T1.WriteData("jdkfjh");
				}});

		add(FT);
		add(OT);//open text button;
		add(OT2);
		add(OT3);
		
	}
	
	public class wordshuxing extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		int x=10;
		int y;
		int w=200;
		int h=40;
		public wordshuxing (int num,String name){
			super(name);
			y=50*num-40;
			setBounds(x,y,w,h);
			setForeground(Color.white);
			setBackground(new Color(60,160,60));
			setOpaque(true);
		}

	}
	
	public class openact implements ActionListener{
	     readWindow db;
		 public openact(readWindow Drb){
			 db=Drb;
		 }
	

	public void actionPerformed(ActionEvent arg0) {
		StringBuffer ba=new StringBuffer();
		FileDialog my=new FileDialog(db);
       my.setVisible(true);
       String t=my.getDirectory()+my.getFile();
       db.t=t;
       ba=T4.getWordStringBuffer(t);
		db.text=ba.toString();
		db.zairu();
	}


}
	
	public class  refurbish implements ActionListener {
		readWindow db;
		public  refurbish(readWindow Drb){
			 db=Drb; 
		 }

		public void actionPerformed(ActionEvent e) {
			StringBuffer ba=new StringBuffer();
	        db.qingkong();
	        String  t=db.t;    
	        ba=T4.getWordStringBuffer(t);
			db.text=ba.toString();
			db.zairu();

		}

	}
	
	
	

}
