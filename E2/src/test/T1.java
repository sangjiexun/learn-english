package test;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.jdbc.Statement;
public class T1 {
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
 

 
	public   ArrayList<String>  getinworld () throws ClassNotFoundException{
		
    Connection conn=null;
	PreparedStatement ptmt=null;
	ResultSet rs=null; 
	ArrayList<String> word1 =new ArrayList<String>();//已会单词
	
	//1.装载驱动程序
	Class.forName(JDBC_DRIVER);
	//2.建立链接
	try { 	
		conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
		//3、执行sql语句
//		ptmt=conn.prepareStatement("select * from inword");	
		ptmt=conn.prepareStatement("select * from dictionary where inword=1");	
		ptmt.setFetchSize(2);
		rs=ptmt.executeQuery();
		//4、执行结果

		while (rs.next()){
//		System.out.println(rs.getString("id")+": "+rs.getString("inword"));
		
//		word1.add(rs.getString("inword"));
		word1.add(rs.getString("english"));
		}
	   

	} catch (SQLException e) {
		//异常处理
		e.printStackTrace();
	}finally{
		//5 清理
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
	
	
	public   ArrayList<String>  getnowworld () throws ClassNotFoundException{
		
	    Connection conn=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null; 
		ArrayList<String> word1 =new ArrayList<String>();//已会单词
		
		//1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.建立链接
		try { 	
			conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//3、执行sql语句
//			ptmt=conn.prepareStatement("select * from nowword");	
			ptmt=conn.prepareStatement("select * from dictionary where nowword=1");	
			ptmt.setFetchSize(2);
			rs=ptmt.executeQuery();
			//4、执行结果

			while (rs.next()){
//			System.out.println(rs.getString("id")+": "+rs.getString("inword"));
			
//			word1.add(rs.getString("nowword"));
		    word1.add(rs.getString("english"));
			}
		   

		} catch (SQLException e) {
			//异常处理
			e.printStackTrace();
		}finally{
			//5 清理
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
	
	 
		public  String searchWords (String english) throws ClassNotFoundException{
			
	    Connection conn=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null; 
		String word1 =new String();//已会单词
		
		//1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.建立链接
		try { 	
			conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//3、执行sql语句
			ptmt=conn.prepareStatement("select * from dictionary where english=?");	
			ptmt.setString(1, english);
			ptmt.setFetchSize(2);
			rs=ptmt.executeQuery();
			//4、执行结果

			while (rs.next()){
			word1=rs.getString("chinese");
			}
		   if(word1.length()==0){
			   word1="查询不到";
		   }

		} catch (SQLException e) {
			//异常处理
			e.printStackTrace();
		}finally{
			//5 清理
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

		
		
		@SuppressWarnings("resource")
		public  void removeinword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("select * from inword where inword=? ");	
				ptmt.setString(1, word);
				rs=ptmt.executeQuery();
				int id = -1;
				while (rs.next()){
					id=rs.getInt("id");
					}
				System.out.println(id);
				ptmt=conn.prepareStatement("delete from inword where id=? ");	
				ptmt.setInt(1, id);
				ptmt.execute();
				ptmt=conn.prepareStatement("update inword set id=id-1 where id>=? ", id);
				ptmt.setInt(1, id);
//				ptmt.setFetchSize(2);
//				rs=ptmt.executeQuery();
				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果
//				while (rs.next()){
//				System.out.println(rs.getString("UserName")+": "+rs.getString("CourseName"));
//			}
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		@SuppressWarnings("resource")
		public  void insertinword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("insert into inword (inword,time) values (?,0)");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}

		
		@SuppressWarnings("resource")
		public  void removenowword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("select * from nowword where nowword=? ");	
				ptmt.setString(1, word);
				rs=ptmt.executeQuery();
				int id = -1;
				while (rs.next()){
					id=rs.getInt("id");
					}
				System.out.println(id);
				ptmt=conn.prepareStatement("delete from nowword where id=? ");	
				ptmt.setInt(1, id);
				ptmt.execute();
				ptmt=conn.prepareStatement("update nowword set id=id-1 where id>=? ", id);
				ptmt.setInt(1, id);
//				ptmt.setFetchSize(2);
//				rs=ptmt.executeQuery();
				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果
//				while (rs.next()){
//				System.out.println(rs.getString("UserName")+": "+rs.getString("CourseName"));
//			}
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		@SuppressWarnings("resource")
		public  void insertnowword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("insert into nowword (nowword,time) values (?,0)");	
				ptmt.setString(1, word);
				
				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
	
		
		public  void addinword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set inword=1 where english=?");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		public  void delinword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set inword=0 where english=?");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		
		public  void addnowword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set nowword=1 where english=?");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		public  void increasetime (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set time=time+1 where english=?");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		public  void delnowword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set nowword=0 where english=?");	
				ptmt.setString(1, word);
				
				 ptmt.execute();
				 conn.commit(); 
				
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		@SuppressWarnings("resource")
		public  void insertdictionary (String english,String chinese) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("insert into dictionary (english,chinese,time) values (?,?,0)");	
				
				ptmt.setString(1, english);
				ptmt.setString(1, chinese);
				 ptmt.execute();
				 conn.commit(); 
				
				//4、执行结果

				 
			} catch (SQLException e) {
				//异常处理
				e.printStackTrace();
			}finally{
				//5 清理
				try {
				if(conn!=null)
					conn.close();
				if(ptmt!=null)
					ptmt.close();
				} catch (SQLException e) {
			
				}
			}
			}
		
		
		
		
		
		
		
		
public static void main(String[] args) throws ClassNotFoundException{
	T1 tt1=new T1();
//	tt1.insertinword("gaol");
//	tt1.insertnowword("portable");
//	ArrayList<String> w3=new ArrayList<String>();
//	w3=tt1.getnowworld();
//	for (String word2:w3){
//		System.out.println(word2);	
//	}
	
	tt1.increasetime("sb");
	
}
}
