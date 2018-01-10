package tool;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
	
	 public static Logger getMyLog(Class<?> c){
	        Logger logger = Logger.getLogger(c);
	        PropertyConfigurator.configure(setLogProperty());
	        return logger;
	    }
	
	 public static void main(String[] args){
		 Logger logger = getMyLog(Mylog.class);
		 logger.debug("运行成功");
		 Timestamp date=new Timestamp(System.currentTimeMillis());

		 System.out.println(date.getTime()-date.getTime());
		 
	 }
	 
	
	
}
