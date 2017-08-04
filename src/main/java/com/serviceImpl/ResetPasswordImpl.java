package com.serviceImpl;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.Controller;
import com.dao.ResetPasswordDAO;
import com.daoImpl.ResetPasswordDAOImpl;
import com.entity.Register;
//import com.entity.User;
import com.general.Status;
import com.inputs.Email;
import com.service.ResetPassword;

@Service
public class ResetPasswordImpl implements ResetPassword{
		
	String hashocde;
	String link;
	Status status = new Status();
	
	@Autowired
	private ResetPasswordDAO resetPasswordDAOImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(ResetPasswordImpl.class); 
	
	public Status resetPassword(Email email){
				if (checkUserExists(email.getEmail())!=null){
					hashocde = prepareRandomString();
					sendResetPasswordLink(hashocde,email.getEmail());
					//status.setStatus("Email Sent to User");
				}else {
					//status.setStatus("User not registered");
				}
				return status;
	}
	
	public Register checkUserExists(String email){
		
		return resetPasswordDAOImpl.checkUserExists(email);
	}
	
	String prepareRandomString(){
		char [] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i=0; i<20; i++){
			sb.append(chars[random.nextInt(chars.length)]);			
		}
		return sb.toString();
	}
	
	void sendResetPasswordLink(String hashcode, String email){
		String to = email;
   	  
	     //Get the session object  
	      Properties props = new Properties();
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.socketFactory.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.port", "465");
	      
	      Session session = Session.getInstance(props,new javax.mail.Authenticator(){
		      protected PasswordAuthentication getPasswordAuthentication(){
		    	  return new PasswordAuthentication("create.demo.user@gmail.com","create.demo.user7");
		      }
		      });
	      
	      //link ="http://localhost:8080/demo/resources/Reset%20Password.html?token="+hashcode;
	      link="http://localhost:8080/demo/resources/ResetPasswordPage.jsp?token="+hashcode;
	      StringBuilder bodyText = new StringBuilder(); 
          bodyText.append("<div>")
               .append("  Dear User<br/><br/>")
               .append("  You recently requested for a password reset.")
               .append("  Please click <a href=\""+link+"\">here</a> or open below link in browser<br/>")
               .append("  <a href=\""+link+"\">"+link+"</a>")
               .append("  <br/><br/>")
               .append("  Thanks,<br/>")
               .append("  Safe2Pay Team")
               .append("</div>");
	      
          resetPasswordDAOImpl.saveToken(hashcode,email);
	  
	      //Compose the message  
	      try{  
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("create.demo.user@gmail.com"));
	        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	        message.setSubject("Reset Password");
	        message.setContent(bodyText.toString(), "text/html; charset=utf-8");
	        
	       //Transport the message
	        Transport.send(message); // MIME type is a type of message
	        logger.debug("Message Sent succeessfully");
	      }catch (MessagingException mex) {
	    	  mex.printStackTrace();}  
	   }
	
		public void updateForgetPassword(String newPassword, String confirmNewPassword,String token){
			if(newPassword.equals(confirmNewPassword)){
				String tokenWithoutSlash =removeSpecialCharacters(token);
				String email = resetPasswordDAOImpl.retrieveEmail(tokenWithoutSlash);
				resetPasswordDAOImpl.updatePassword(newPassword,email);
			}
				
		}
		
		String  removeSpecialCharacters(String token){
			return token.replace("/", "");
		}
	}
