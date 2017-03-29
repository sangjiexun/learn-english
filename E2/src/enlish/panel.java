package enlish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import others.grade;
import others.jtable;
import others.mykey;

public class panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public window widd; 
    private jtable j1,j2,j3,j11,j21,j31,j4,j41;
    private TextField t1;
    private JPasswordField t2 ;
    private String w1,w2,w3,w4,w5,w6,w7;
    public ArrayList<String> e;
	public grade grade1;
    public int i1;
    
	public panel(window widd){
	i1=Integer.parseInt(readDate());
	grade1=new grade(i1);
	e=innowword();
	this.widd=widd;
	w1=e.get((int) (Math.random()*e.size()));
	w3=w1;
	setLayout(null);
	setPreferredSize(new Dimension(200, 700));
	setBackground(Color.CYAN);
	
	j4=new jtable(500,20,200,50,"等级");
	j41=new jtable(500,70,200,50,"经验");
	j1=new jtable(20,20,400,50,w1);
	j11=new jtable(20,70,400,50,"starting");
	w7=w1;
	j2=new jtable(20,200,400,100,"中文");
	j21=new jtable(20,300,400,100,"start");
	j3=new jtable(500,200,200,100,"start");
	j31=new jtable(500,300,200,100,"start");
	j1.setFont(new Font("Dialog",2, 25));
	j2.setFont(new Font("Dialog",2, 50));
	j3.setFont(new Font("Dialog",2, 40));
	j11.setFont(new Font("Dialog",2, 25));
	j21.setFont(new Font("Dialog",2, 50));
	j31.setFont(new Font("Dialog",2, 40));
	j4.setFont(new Font("Dialog",2, 40));
	j41.setFont(new Font("Dialog",2, 40));
	t1=new TextField();
	t2 = new JPasswordField();
	t2.setBounds(100, 500, 180, 30);
	t2.setEchoChar((char) 0);
	t2.setFont(new Font("Dialog",2, 20));
	
	System.out.println(e.size());
	
	t2.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent k) {
            
            if(k.getKeyChar()=='\n'){
            if(t2.getText().equals(w7)){
            	j3.setText(w7);
//            	j2.setText(j1.getText());
            	w7=j1.getText();
            	w1=e.get((int) (Math.random()*e.size()));
            	j1.setText(w1);
            	
            	j31.setText(j21.getText());
            	j21.setText(j11.getText());
            	w2=searchWords(w1);
            	j11.setText(w2);
            	
            	grade1.ex++;
            	w5=""+grade1.ex;
            	w6=""+grade1.grade;
            	j4.setText("等级"+w6);
            	j41.setText("经验"+w5);
            	
            	WriteDate(w5);
//            	outg();
            	
            	
            }
            t2.setText("");
            System.out.println(w7);
            }
        }
    });
	
	add(j1);add(j11);
	add(j2);add(j21);
	add(j3);add(j31);
	add(t2);
    add(j4);add(j41);
	
	}
	
	
	

	protected String searchWords(String inputWord) {
		 String w=null;
		try {
            BufferedReader br = new BufferedReader(new FileReader
            		("C:/Users/Administrator/Desktop/许云苏的机器人/dictionary.txt"));
            String line ;
            boolean isFound = false;
             
            System.out.println(inputWord);
       
                         
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
               
                if(in.next().equals(inputWord)){
                    int offset = inputWord.length();
//                    output.setText("\n\n\n\n"+line.substring(offset));
                     w = line.substring(offset);
//                   
                    
                    isFound = true;
                    break;
                }
            }
//             return w;
          
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		return w;
		
		
		
	}
	
	
	
	 public ArrayList<String> innowword(){
     	
     	ArrayList<String> w1 = null;
     	try {
				ObjectInputStream in=new ObjectInputStream(
		new FileInputStream("C:/Users/Administrator/Desktop/许云苏的机器人/now.txt"));
				
				w1=(ArrayList<String>) in.readObject();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     	
     	return w1;
     	
     }
	
	
	 public static void WriteDate(String nfile) {

			try{

			BufferedWriter output = new BufferedWriter(new FileWriter
					("C:/Users/Administrator/Desktop/许云苏的机器人/grade.txt"));//保存TXT位置

			output.write(String.valueOf(nfile)+"\r\n");


			output.close();

			} catch (Exception ex) {

			System.out.println(ex);

			}

			}
	 
	 
	 

		public static String readDate(){
			String sb = new String();
			
			try{
           
            
		    BufferedReader br = new BufferedReader(new FileReader
		    		("C:/Users/Administrator/Desktop/许云苏的机器人/grade.txt"));
			
            sb=br.readLine();

            System.out.println(sb);

			} catch (Exception ex) {

			System.out.println(ex);

			}

			return sb;
			
			}
	 
	 
    
	 
	 
	
}
