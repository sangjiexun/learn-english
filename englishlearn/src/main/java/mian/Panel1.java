package mian;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;

import eforc.englishchinese.select_chinese_window;
import read.english_reader.readWindow;
import recitation.reciteenlish.recitewindow;
import tool.Mylog;
import tool.T1;


//主界面的工具栏
public class Panel1 extends JPanel{
/**主界面的窗口
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Panel1(final Mianwindow w1){

	setLayout(null);
	setPreferredSize(new Dimension(850, 50));//主界面的尺寸；
	
	 JPanel  GImage = new JPanel() {  
  	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {  
            ImageIcon icon = new ImageIcon("C:/Users/Administrator/Desktop/图片素材库/timg.jpg");  
            Image img = icon.getImage();  
            g.drawImage(img, 0, 0, icon.getIconWidth(),  
                    icon.getIconHeight(), icon.getImageObserver());    
        }  
    };  
	
    GImage.setBounds(0,0,900,700);
	
    
    ActionListener a1=new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			try {
				englishreader();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//执行函数，打开阅读器。
			w1.setVisible(false);
			Logger logger = T1.getMyLog(Mylog.class);
			logger.debug("点击了阅读器");
            
		}
	};
	
    final JButton MB1=new MYJButton("阅读器",1,a1);
//    MB1.setBounds(80,80, 130, 90);
	MB1.setBorder(new LineBorder(new Color(28,134,238)));
	MB1.setBackground(new Color(0,166,80));
	


	ActionListener a2=new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			try {
				reciteword();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}//执行函数，打开阅读器。
			w1.setVisible(false);
			Logger logger = T1.getMyLog(Mylog.class);
			logger.debug("背诵");
            
		}
	};
	 final JButton MB2=new MYJButton("背单词",2,a2);
//		MB2.setBorder(new LineBorder(Color.CYAN));
		MB2.setBackground( new Color(0 ,238 ,118));
		MB2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {			
			}
	
		});

		ActionListener a3=new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					selectchinese();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}//执行函数，打开阅读器。
				w1.setVisible(false);
				Logger logger = T1.getMyLog(Mylog.class);
				logger.debug("点击了英认中");  
				
			}		
		};

		 final JButton MB3=new MYJButton("英认中",3,a3);
			MB3.setBackground( new Color(28,134,238));

    add(MB1);
    add(MB2);
    add(MB3);
    add(GImage); 

}

//函数调用下
public void englishreader() throws ClassNotFoundException{
	@SuppressWarnings("unused")
	readWindow wid = new readWindow();
}

public void reciteword() throws ClassNotFoundException{
	@SuppressWarnings("unused")
	recitewindow Win=new recitewindow();	
}

public void selectchinese() throws ClassNotFoundException{
	@SuppressWarnings("unused")
	select_chinese_window Wic=new select_chinese_window();	
}

}