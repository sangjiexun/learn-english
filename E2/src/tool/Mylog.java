package tool;

import java.io.IOException;
import java.net.InetAddress;
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
		 logger.error("hello log");
		
		 
	 }
	 
	
	
}
