package Button;
//������
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

import Lis.openact;
import english_learn.window;
import worldshow.wordjlabel;


public  class Tool_panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	private window widd;
	public wordshuxing fy,wordnumber,unknow,unknowl,learning;
	public JTextField t1,t2;
	
	
	public Tool_panel(window window){
		//��Ӳ�����ť
		this.widd=window;
		
		{
		setLayout(null);
		setPreferredSize(new Dimension(200, 50));//�������Ŀ�ȣ�
		setBackground(Color.CYAN);
		
		}//�������Ļ�������
		
		fy=new wordshuxing(10, 10, 60,"�����Ƿ���");
		unknow=new wordshuxing(10, 80,40, "δ֪��������");
		unknowl=new wordshuxing(10, 140,40, "δ֪��");
		add(new wordshuxing(10, 200,40, "İ���ʣ�"));
		wordnumber=new wordshuxing(10, 260,40, "�ܵ�������");
		learning=new wordshuxing(10, 320,40, "����2");
		
		t1 =new Etextfield(10 , 450 ,150 ,20);
		t2=new Etextfield(10 , 490 ,150 ,20);

		
		add(unknow);
		add(unknowl);
		add(fy);
		add(wordnumber);
		add(learning);	
		add(t1);
		add(t2);
	
		
		JButton OT=new JButton("open");
		OT.setBounds(10,370, 70, 60);

		JButton OT2=new JButton("ˢ��");
		OT2.setBounds(90,370, 70, 30);
	
		JButton FT=new JButton("��ӷ���");
		FT.setBounds(20,540, 120, 30);
	
		
		OT.addActionListener(new openact(widd));
		OT2.addActionListener(new sopenact(widd));
		FT.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(!(t1.getText()==""||t1.getText()=="")){
				WriteDate(t1.getText()+"  "+t2.getText());
				t1.setText("");
				t2.setText("");
				}
			}
			
		}

				);
		
		
		add(FT);
		add(OT);//open text button;
		add(OT2);
		
	}
	
	
	
	
	public static void WriteDate(String nfile) {

		try{


		FileReader read = new FileReader(new File("C:/Users/Administrator/Desktop/�����յĻ�����/dictionary.txt"));//��txt

		StringBuffer sb = new StringBuffer();

		char ch[] = new char[1024];

		int d = read.read(ch);

		while(d!=-1){

		String str = new String(ch,0,d);

		sb.append(str);

		d = read.read(ch);

		}

		System.out.println("����˷��룺 "+sb.toString());

		BufferedWriter output = new BufferedWriter(new FileWriter("C:/Users/Administrator/Desktop/�����յĻ�����/dictionary.txt"));//����TXTλ��

		output.write(String.valueOf(sb.toString()));


		output.write(String.valueOf(nfile)+"\r\n");


		output.close();

		} catch (Exception ex) {

		System.out.println(ex);

		}

		}

	

}
