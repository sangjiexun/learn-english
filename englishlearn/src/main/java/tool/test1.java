package tool;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

public class test1 {
	
	 static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 static final String DB_URL="jdbc:mysql://localhost:3306/english?"
	 		+ "characterEncoding=utf8&useSSL=false&useCursorFetch=true";
	 static final String USER="root";
	 static final String PASSWORD="123qwe";
	

	 public static void dbpoolInit(){
		 BasicDataSource ds = new BasicDataSource();
		 ds.setUrl(DB_URL);
		 ds.setDriverClassName(JDBC_DRIVER);
		 ds.setUsername(USER);
		 ds.setPassword(PASSWORD);
	 
	 }
	 
		public static void insertword (String english ,String chinese) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
//			ResultSet rs=null; 
			
			//1.װ����������
			Class.forName(JDBC_DRIVER);
			//2.��������
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3��ִ��sql���
				ptmt=conn.prepareStatement("insert into dictionary (english,chinese,time) values (?,?,0)");	
//				System.out.println();
				ptmt.setString(1, english);
				ptmt.setString(2, chinese);
//				ptmt.setFetchSize(2);
//				rs=ptmt.executeQuery();
				 ptmt.execute();
				 conn.commit(); 
				
				
				//4��ִ�н��
//				while (rs.next()){
//				System.out.println(rs.getString("UserName")+": "+rs.getString("CourseName"));
//			}
			} catch (SQLException e) {
				//�쳣����
				e.printStackTrace();
			}finally{
				//5 ����
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
	 

	 


	public static ArrayList<String> inword(){
    	
    	ArrayList<String> w1 = null;
    	try {
			ObjectInputStream in=new ObjectInputStream(
	new FileInputStream("C:/Users/Administrator/Desktop/����ϼ�/obj.txt"));
			
			w1=(ArrayList<String>) in.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	return w1;
    	
    }

//	public static ArrayList<String> innowword(){
//    	
//    	ArrayList<String> w1 = null;
//    	try {
//			ObjectInputStream in=new ObjectInputStream(
//	new FileInputStream("C:/Users/Administrator/Desktop/����ϼ�/now.txt"));
//			
//			w1=(ArrayList<String>) in.readObject();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//    	
//    	return w1;
//    	
//    }
	
	

	 
		public static String setinWord (ArrayList<String> w1) throws ClassNotFoundException{
			
	    Connection conn=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null; 
		String word1 =new String();//�ѻᵥ��
		
		//1.װ����������
		Class.forName(JDBC_DRIVER);
		//2.��������
		try { 	
			conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//3��ִ��sql���
			
			for (String word:w1){
				ptmt=conn.prepareStatement("update dictionary set inword=1 where english=?");	
				ptmt.setString(1, word);
				ptmt.execute();
			}
			
			
//			ptmt=conn.prepareStatement("select * from dictionary where english=?");	
//			ptmt.setString(1, word1);
			ptmt.setFetchSize(2);
//			rs=ptmt.executeQuery();
//			//4��ִ�н��
//
//			while (rs.next()){
//			word1=rs.getString("chinese");
//			}
		   if(word1.length()==0){
			   word1="��ѯ����";
		   }

		} catch (SQLException e) {
			//�쳣����
			e.printStackTrace();
		}finally{
			//5 ����
			try {
			if(conn!=null)
				conn.close();
			if(ptmt!=null)
				ptmt.close();
			if(rs!=null)
				rs.close();
			} catch (SQLException e) {
		
			}
			
		}
		return word1;
		}
	
		public static String searchWords (String english) throws ClassNotFoundException{
			
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			String word1 =new String();//�ѻᵥ��
			
			//1.װ����������
			Class.forName(JDBC_DRIVER);
			//2.��������
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3��ִ��sql���
				ptmt=conn.prepareStatement("select * from dictionary where english=?");	
				ptmt.setString(1, english);
				ptmt.setFetchSize(2);
				rs=ptmt.executeQuery();
				//4��ִ�н��

				while (rs.next()){
				word1=rs.getString("chinese");
				}
			   if(word1.length()==0){
				   word1="��ѯ����";
			   }

			} catch (SQLException e) {
				//�쳣����
				e.printStackTrace();
			}finally{
				//5 ����
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				if(rs!=null)
					rs.close();
				} catch (SQLException e) {
			
				}
				
			}
			return word1;
			}	
		
		
		public static String setnowWord (ArrayList<String> w1) throws ClassNotFoundException{
			
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			String word1 =new String();//�ѻᵥ��
			
			//1.װ����������
			Class.forName(JDBC_DRIVER);
			//2.��������
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3��ִ��sql���
				
				for (String word:w1){
					ptmt=conn.prepareStatement("update dictionary set nowword=1 where english=?");	
					ptmt.setString(1, word);
					ptmt.execute();
				}
				
				
//				ptmt=conn.prepareStatement("select * from dictionary where english=?");	
//				ptmt.setString(1, word1);
				ptmt.setFetchSize(2);
//				rs=ptmt.executeQuery();
//				//4��ִ�н��
	//
//				while (rs.next()){
//				word1=rs.getString("chinese");
//				}
			   if(word1.length()==0){
				   word1="��ѯ����";
			   }

			} catch (SQLException e) {
				//�쳣����
				e.printStackTrace();
			}finally{
				//5 ����
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				if(rs!=null)
					rs.close();
				} catch (SQLException e) {
			
				}
				
			}
			return word1;
			}
		
		
		
	 
	public static void main(String[] args) throws ClassNotFoundException {
		dbpoolInit();

//		ArrayList<String> wordin = inword();
//		ArrayList<String> wordnow = innowword();
//		for (String nowword :wordnow){
//			insertword(nowword);
//		}
//		System.out.println(wordnow.size());
		
//		System.out.println(searchWords("sb"));
		
//		ArrayList<String> wordin = inword();
	
		T1 tt1=new T1();
		ArrayList<String> wordnow = tt1.getnowworld();
		setnowWord(wordnow);
	
	
	}
	
}
