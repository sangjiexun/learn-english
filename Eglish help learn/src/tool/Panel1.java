package tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//������Ĺ�����
public class Panel1 extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public Panel1(){
	setLayout(null);
	setPreferredSize(new Dimension(800, 50));//�������Ŀ�ȣ�
	setBackground(new Color(0,174,239));
	
	
	
    JButton MB1=new JButton("�Ķ���");
    MB1.setBounds(250,100, 300, 60);
	MB1.setBorder(new LineBorder(new Color(28,134,238)));
	MB1.setBackground( new Color(0,166,80));
	MB1.addActionListener(new ActionListener(){

		
		@Override
		public void actionPerformed(ActionEvent e) {
			

			
		}
		
		
		
	});
	
	
	 JButton MB2=new JButton("������");
	    MB2.setBounds(250,200, 300, 60);
//		MB2.setBorder(new LineBorder(Color.CYAN));
		MB2.setBackground( new Color(220,50,238));
		MB2.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				
			}
			
			
			
		});
	
		
		 JButton MB3=new JButton("��̨����");
		    MB3.setBounds(250,300, 300, 60);
//			MB3.setBorder(new LineBorder(Color.CYAN));
			MB3.setBackground( new Color(28,134,238));
			MB3.addActionListener(new ActionListener(){

				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					
				}
				
				
				
			});
		
	
	
	
	
    add(MB1);
    add(MB2);
    add(MB3);
}
}