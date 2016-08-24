package com.other.email;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmailQQ {
	public static void main(String[] args) throws GeneralSecurityException,
			AddressException, MessagingException {
		// 下载local_policy.jar,US_export_policy.jar包
		// 下载地址
		// http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
		// 替换目录 %JAVA_HOME%\jre\lib\security
		String user = "461092376@qq.com";
		String pwd = "myojvqkqkbymbicj";
		String sendTo = "895921314@qq.com";

		Properties props = new Properties();

		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		msg.setSubject("hello");
		StringBuilder builder = new StringBuilder();
		builder.append("this is content");
		msg.setText(builder.toString());
		msg.setFrom(new InternetAddress(user));

		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", user, pwd);

		transport.sendMessage(msg,
				new Address[] { new InternetAddress(sendTo) });
		transport.close();
	}
}