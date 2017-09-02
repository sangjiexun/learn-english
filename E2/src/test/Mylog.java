package test;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Mylog extends Logger{

	protected Mylog(String name) {
		super(name);
	}

	private static Properties setLogProperty(){
        Properties p = new Properties();
        String ip = null;
        try {
            p.load(Mylog.class.getResourceAsStream("log4j.properties"));
            InetAddress addr = InetAddress.getLocalHost();
//            ip = addr.getHostAddress().toString(); //
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if(ip.contains(".19.85")){
//            //�����ڷ�������
//            p.setProperty("log4j.appender.logfile.File","/alidata/server/mycrawllog.log");
//            p.setProperty("log4j.rootLogger","INFO,stdout,logfile");
//            p.setProperty("log4j.appender.logfile.Threshold","ERROR");
//        }else{
//            //�����ڱ���,��־ֻ�����������̨
////            p.setProperty("log4j.rootLogger","INFO,stdout,logfile");
////            p.setProperty("log4j.appender.logfile.Threshold","INFO");
//        }
        
        return p;
    }
	
	 public static Logger getMyLog(Class<?> c){
	        Logger logger = Logger.getLogger(c);
	        PropertyConfigurator.configure(setLogProperty());
	        
	        return logger;
	    }
	
	 public static void main(String[] args){
		 Logger logger = getMyLog(Mylog.class);
		
		 Timestamp date=new Timestamp(System.currentTimeMillis());
//		 Timestamp date1="1970-01-01 08:01:40";
//		  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		  String time=format.format(date);
//		  System.out.println(time);
//		  logger.error(time+"        hello log");
//		 yyyy-mm-dd hh:mm:ss
//		 System.out.println(date1.getTime());
		 System.out.println(date.getTime()-date.getTime());
		 
	 }
	 
	
	
}
