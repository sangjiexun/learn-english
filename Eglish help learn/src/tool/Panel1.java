package tool;
//主界面的窗口

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import english_reader.window;
import mian.Mianwindow;
import reciteenlish.recitewindow;

//主界面的工具栏
public class Panel1 extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public Panel1(Mianwindow w1){
	setLayout(null);
	setPreferredSize(new Dimension(800, 50));//主界面的宽度；
	setBackground(new Color(0,174,239));
	
	
	
    JButton MB1=new JButton("阅读器");
    MB1.setBounds(250,100, 300, 60);
	MB1.setBorder(new LineBorder(new Color(28,134,238)));
	MB1.setBackground(new Color(0,166,80));
	MB1.addActionListener(new ActionListener(){

		
		@Override
		public void actionPerformed(ActionEvent e) {
			englishreader();//执行函数，打开阅读器。
            w1.setVisible(false);
			
		}
		
		
		
	});
	MB1.addMouseListener(new MouseListener(){



		@Override
		public void mouseEntered(MouseEvent e) {
			
			
			MB1.setBounds(250,80, 300, 100);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			

			MB1.setBounds(250,100, 300, 60);
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
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
		
	});
	
	
	
	
	
	
	 JButton MB2=new JButton("背单词");
	    MB2.setBounds(250,250, 300, 60);
//		MB2.setBorder(new LineBorder(Color.CYAN));
		MB2.setBackground( new Color(220,50,238));
		MB2.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				
			}
			
			
			
		});
	
		
		MB2.addMouseListener(new MouseListener(){



			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				MB2.setBounds(250,230, 300, 100);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				

				MB2.setBounds(250,250, 300, 60);
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				reciteword();
				w1.setVisible(false);
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		
		
		 JButton MB3=new JButton("英认中");
		    MB3.setBounds(250,400, 300, 60);
//			MB3.setBorder(new LineBorder(Color.CYAN));
			MB3.setBackground( new Color(28,134,238));
			MB3.addActionListener(new ActionListener(){

				
				@Override
				public void actionPerformed(ActionEvent e) {
					

					
				}
				
				
				
			});
		
	
			
			MB3.addMouseListener(new MouseListener(){



				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
					MB3.setBounds(250,380, 300, 100);
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					

					MB3.setBounds(250,400, 300, 60);
					
				}

				@Override
				public void mouseClicked(MouseEvent e) {
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
				
			});
			
			
	
	
	
    add(MB1);
    add(MB2);
    add(MB3);
    
    
    
    

    
    
    
    
}

//函数调用下
public void englishreader(){
	@SuppressWarnings("unused")
	
	window wid = new window();

}

public void reciteword(){
	@SuppressWarnings("unused")
	recitewindow Win=new recitewindow();
	
}


}