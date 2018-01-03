package com.finessy.web.mailapp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
  
	public static void send(String to) {
		
		final String user = "";
		final String password = "";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(props,
				
				new javax.mail.Authenticator() {
			     protected PasswordAuthentication getPasswordAuthentication() {
			    	 return new PasswordAuthentication(user,password);
			     }
		});
		try {
		
		Transport transport = session.getTransport();	
		 	
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(user));
		msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		msg.setSubject("mail from java");
		msg.setText("HI !!! mail is reached successfully");
		
		transport.connect();
		Transport.send(msg);
		transport.close();
		
		System.out.println("Done");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
