package AirTicket.Service;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;

import AirTicket.Data.Job;
import AirTicket.Data.User;

@Component
public class Mail {
	public boolean mainto(Job job,User user) throws GeneralSecurityException
	 {
	  boolean flag = true;
	  
	  //建立邮件会话
	  Properties pro = new Properties();
	  pro.put("mail.smtp.host","smtp.qq.com");//存储发送邮件的服务器
	  pro.put("mail.smtp.auth","true");  //通过服务器验证
	  
	  MailSSLSocketFactory sf = new MailSSLSocketFactory();
	  sf.setTrustAllHosts(true);
	  pro.put("mail.smtp.ssl.enable", "true");
	  pro.put("mail.smtp.ssl.socketFactory", sf);
	  
	  Session s =Session.getInstance(pro); //根据属性新建一个邮件会话
	  //s.setDebug(true);
	  
	  //由邮件会话新建一个消息对象
	  MimeMessage message = new MimeMessage(s);
	  
	  //设置邮件
	  InternetAddress fromAddr = null;
	  InternetAddress toAddr = null;
	  
	  try 
	  {
	   fromAddr = new InternetAddress("2134380893@qq.com");   //邮件发送地址
	   message.setFrom(fromAddr);         //设置发送地址
	   
	   toAddr = new InternetAddress(user.getUsername());       //邮件接收地址
	   message.setRecipient(Message.RecipientType.TO, toAddr);  //设置接收地址
	   
	   message.setSubject("机票票价变动");   //设置邮件标题
	   message.setText("您的"+job.getAirdate()+"的机票当前为最低价格："+job.getLmoney()+"\n如有需要请前往去哪儿网购买，当然您也可以接着等。");   //设置邮件正文
	   message.setSentDate(new Date()); //设置邮件日期
	   
	   message.saveChanges();    //保存邮件更改信息

	Transport transport = s.getTransport("smtp");
	   transport.connect("smtp.qq.com", "2134380893", "flhltmtimfnaefhi"); //服务器地址，邮箱账号，邮箱密码flhltmtimfnaefhi---sqqaltpndbhwbcch
	   transport.sendMessage(message, message.getAllRecipients());   //发送邮件
	   transport.close();//关闭
	  } 
	  catch (Exception e) 
	  {
	   e.printStackTrace();
	   flag = false;//发送失败
	  }
	  
	  return flag;
	 }
}
