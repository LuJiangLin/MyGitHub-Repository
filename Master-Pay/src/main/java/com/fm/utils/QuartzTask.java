package com.fm.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

/**
 * 对设备进行收费定时器
 * @author Administrator
 *
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class QuartzTask extends QuartzJobBean {
	
	public static QuartzTask quartzTask;
	
	@PostConstruct
	public void init() {
		quartzTask = this;
	}
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		    System.out.println("定时器 =======1====="+new Date());
		    
		    
		    
	}
	
	
	//比较时间
	public int compare_date(Date date) {
        
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//5分钟
		Calendar cal1 = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。
		cal1.setTime(date);    
	    cal1.add(Calendar.MINUTE,5);   //5分钟后的时间
	    //10分钟
	    Calendar cal2 = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。
		cal2.setTime(date);    
	    cal2.add(Calendar.MINUTE,10);   //10分钟后的时间
        try {
        	
        	Date five1 =  df.parse(df.format(cal1.getTime()));
        	Date five2 =  df.parse(df.format(cal2.getTime()));
        	if(five2.getTime() > new Date().getTime()){
        		if(five1.getTime() >= new Date().getTime()){
        			//System.out.println("登陆信息在5分钟内");
                    return 1;
        		} else {
        			//System.out.println("登陆信息在5~10分钟内");
                    return 0;
        		}
        		
        	}else{
        		return -1;
        	}
        	
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return -1;
    }
	
	//TCP关闭卡状态
	public void closeTcpKa(String url, int port, String data){
		
		try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket=new Socket(url, port);
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
            pw.write(data);
            pw.flush();
            //socket.shutdownOutput();//关闭输出流
            //4.关闭资源
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	
}
