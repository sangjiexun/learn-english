package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import mian.Mianwindow;

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
	ArrayList<String> word1 =new ArrayList<String>();//�ѻᵥ��
	
	//1.装载驱动程序
	Class.forName(JDBC_DRIVER);
	//2.建立链接
	try { 	
		conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
		//3、执行sql语句

		ptmt=conn.prepareStatement("select * from dictionary where inword=1");	
		ptmt.setFetchSize(2);
		rs=ptmt.executeQuery();
	
		while (rs.next()){		
		word1.add(rs.getString("english"));
		}

	} catch (SQLException e) {
		
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
		ArrayList<String> word1 =new ArrayList<String>();//�ѻᵥ��
		
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
			//执行结果

			while (rs.next()){
//			System.out.println(rs.getString("id")+": "+rs.getString("inword"));
			
//			word1.add(rs.getString("nowword"));
		    word1.add(rs.getString("english"));
			}	   

		} catch (SQLException e) {
			
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
		String word1 =new String();//�ѻᵥ��
		
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
			//执行结果

			while (rs.next()){
			word1=rs.getString("chinese");
			}
		   if(word1.length()==0){
			   word1="没有查到";
		   }

		} catch (SQLException e) {
			
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

				//执行结果
//				while (rs.next()){
//				System.out.println(rs.getString("UserName")+": "+rs.getString("CourseName"));
//			}
			} catch (SQLException e) {
				
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
		
		
		public  void insertinword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
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
		
				//执行结果

			} catch (SQLException e) {
				
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
		
				//执行结果
//				while (rs.next()){
//				System.out.println(rs.getString("UserName")+": "+rs.getString("CourseName"));
//			}
			} catch (SQLException e) {
				
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
		
		
		public  void insertnowword (String word) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
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
			
				//执行结果

				 
			} catch (SQLException e) {
				
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
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set inword=1 where english=?");	
				ptmt.setString(1, word);

				 ptmt.execute();
//				 conn.commit(); 
				
				//执行结果

				 
			} catch (SQLException e) {
				
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
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句		
				ptmt=conn.prepareStatement("update  dictionary set inword=0 where english=?");	
				ptmt.setString(1, word);

				 ptmt.execute();
//				 conn.commit(); 
		
				//执行结果
	 
			} catch (SQLException e) {
				
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
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set nowword=1 where english=?");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
//				 conn.commit(); 
				
				
				//执行结果

				 
			} catch (SQLException e) {
				
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
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set time=time+1 where english=?");	
				ptmt.setString(1, word);
				

				 ptmt.execute();
//				 conn.commit(); 
								
				//执行结果

				 
			} catch (SQLException e) {
				
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
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				
				ptmt=conn.prepareStatement("update  dictionary set nowword=0 where english=?");	
				ptmt.setString(1, word);
				
				 ptmt.execute();
//				 conn.commit(); 
								
				//执行结果
				 
			} catch (SQLException e) {
				
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
		
		
		public  void insertdictionary (String english,String chinese) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("insert into dictionary (english,chinese,time,inword,nowword,lasttime,lianxiang) values (?,?,0,0,0,'2013-06-20 08:52:47','没有')");	
				
				ptmt.setString(1, english);
				ptmt.setString(2, chinese);
				 ptmt.execute();
//				 conn.commit(); 
				
				//执行结果
				 
			} catch (SQLException e) {
				
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
	
		public  Timestamp getlasttime (String english) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			Timestamp Lt=null;
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("select * from dictionary where english=?");	
				
				ptmt.setString(1, english);
				ptmt.execute();
				rs=ptmt.executeQuery();
//				conn.commit(); 
				
				//执行结果
				
				while (rs.next()){		
					System.out.println((rs.getString("lasttime")));
					Lt=rs.getTimestamp("lasttime");
					}
				
				 
			} catch (SQLException e) {
				
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
			return Lt;
			}
		
		
		public  void setlasttime (String english) throws ClassNotFoundException{
		    Connection conn=null;
			PreparedStatement ptmt=null;
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句
				ptmt=conn.prepareStatement("update dictionary set lasttime =? where english=?");	
				Timestamp date=new Timestamp(System.currentTimeMillis());
				String Dates=date.toString();
				ptmt.setString(1, Dates);
				ptmt.setString(2, english);

				 ptmt.execute();
//				 conn.commit(); 
				
				//执行结果
				 
			} catch (SQLException e) {
				
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
		
		public int  passtime(Timestamp t1){
			int pt =0;
			long lpt=0;
			Timestamp date=new Timestamp(System.currentTimeMillis());
			lpt=date.getTime()-t1.getTime();
			pt=(int) (lpt/86400000);
			return pt;
		}
		
		/*
		*
		*获取最近学过的单词
		*/
		public   ArrayList<String>  getnearinworld() throws ClassNotFoundException{
			
	    Connection conn=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null; 
		ArrayList<String> word =new ArrayList<String>();
//		lst=this.
		//1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.建立链接
		try { 	
			conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//3、执行sql语句
			Timestamp date=new Timestamp(System.currentTimeMillis());
			System.out.println(date.getTime());
			long time1=date.getTime();
//			System.out.println(time1);
			long adv= (time1-2*86400000);
//			System.out.println(adv);
			Timestamp date1=new Timestamp(adv);
//			System.out.println(date1);
			String d2=date1.toString();
			System.out.println(d2);
			ptmt=conn.prepareStatement("select * from dictionary where inword=1&&lasttime>?");	
			
			ptmt.setString(1, d2);
			ptmt.setFetchSize(2);
			
			rs=ptmt.executeQuery();
		
			while (rs.next()){		
			word.add(rs.getString("english"));
			}

		} catch (SQLException e) {
			
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
		return word;
		}
	
		
		public   ArrayList<String>  getduonowworld () throws ClassNotFoundException{
			
		    Connection conn=null;
			PreparedStatement ptmt=null;
			ResultSet rs=null; 
			ArrayList<String> word =new ArrayList<String>();
//			lst=this.
			//1.装载驱动程序
			Class.forName(JDBC_DRIVER);
			//2.建立链接
			try { 	
				conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
				//3、执行sql语句

				ptmt=conn.prepareStatement("select * from dictionary where nowword=1&&time>10");	
				
//				ptmt.setString(1, "");
				ptmt.setFetchSize(2);
				
				rs=ptmt.executeQuery();
			
				while (rs.next()){		
				word.add(rs.getString("english"));
				}

			} catch (SQLException e) {
				
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
			return word;
			}
				
		
		
		 public  Logger getMyLog(Class<?> c){
		        Logger logger = Logger.getLogger(c);
		        PropertyConfigurator.configure(setLogProperty());
		        return logger;
		    }
		
			public static  Properties setLogProperty(){
		        Properties p = new Properties();
		        String ip = null;
		        try {
		            p.load(Mylog.class.getResourceAsStream("log4j.properties"));
		            InetAddress addr = InetAddress.getLocalHost();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        
		        return p;
		    }
		 
			public  void initmain(){
				T1 tt1=new T1();//创建工具类
				ArrayList<String> wordin = null;
				ArrayList<String> wordnow = null;
				try {
					wordin = tt1.getinworld();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					wordnow = tt1.getnowworld();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				Mianwindow widm = new Mianwindow(wordin,wordnow);
				 Logger logger = tt1.getMyLog(Mylog.class);
				 logger.debug("主窗口打开成功");
			}
			
			
			
			 public  void WriteData(String nfile) {

					try{

					BufferedWriter output = new BufferedWriter(new FileWriter
							("C:/Users/Administrator/Desktop/文档/新建文件夹 (2)/test.txt"));

					output.write(String.valueOf(nfile)+"\r\n");


					output.close();

					} catch (Exception ex) {

					System.out.println(ex);

					}

					}
			
		 
				public  String searchlianxiang (String english) throws ClassNotFoundException{
					
				    Connection conn=null;
					PreparedStatement ptmt=null;
					ResultSet rs=null; 
					String word1 =new String();
					
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
						//执行结果

						while (rs.next()){
						word1=rs.getString("lianxiang");
						}
					   if(word1.length()==0){
						   word1="没有查到";
					   }

					} catch (SQLException e) {
						
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
			 
				
				public  void setlianxiang (String english,String lianxiang) throws ClassNotFoundException{
				    Connection conn=null;
					PreparedStatement ptmt=null;
					//1.装载驱动程序
					Class.forName(JDBC_DRIVER);
					//2.建立链接
					try { 	
						conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
						//3、执行sql语句
						ptmt=conn.prepareStatement("update dictionary set lianxiang =? where english=?");	
						Timestamp date=new Timestamp(System.currentTimeMillis());
						ptmt.setString(1, lianxiang);
						ptmt.setString(2, english);

						 ptmt.execute();
						
						//执行结果
						 
					} catch (SQLException e) {
						
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
System.out.println(tt1.searchlianxiang("hello"));
	
}
}
