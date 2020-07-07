package com.testautomation.reusableComponents;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.testautomation.Config.ReusableData;


public class Email 
{

      
      //String to = defs.email_to;
      
      static String email_to= ReusableData.email_to;
      static String email_from= ReusableData.email_from;
      //static String email_CC= defs.email_cc;
      static String username = ReusableData.email_username;//change accordingly
      static String password = ReusableData.email_password;
      static String email_host = ReusableData.email_host;
      static String email_port = ReusableData.email_port;
      static Session session;
      static Properties props;
      //final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
      
      public static void main(String args[])
      {
    	  Email email=new Email();
    	  email.sendSubjectMail("Test Mail From GWCC Automation Team");
      }
      
      public Email()
      {
            //Set the default mail
            Email.email_to=ReusableData.email_to;
            Email.email_from=ReusableData.email_from;
            //Email.email_CC=defs.email_cc;
            Email.username=ReusableData.email_username;
            Email.password=ReusableData.email_password;
            //this.email_to=email_to;
            props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", ReusableData.email_host);
            props.put("mail.smtp.EnableSSL.enable","false"); 
            props.put("mail.smtp.port", ReusableData.email_port);
      }
      public Email(String email_to,String email_from,final String username,final String password)
      {
            //Set the para e-mail
//    	  String email_CC,
            Email.email_to=email_to;
            Email.email_from=email_from;
            //Email.email_CC=email_CC;
            Email.username=username;
            Email.password=password;
            email_host=ReusableData.email_host;
            email_port=ReusableData.email_port;
            //this.email_to=email_to;
            props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", email_host);
            props.put("mail.smtp.EnableSSL.enable","true"); 
            props.put("mail.smtp.port", email_port);
            /*props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", "465");*/
            // Get the Session object.
     
            
      }

      public static void sendSubjectMail(String subject)
      {
            try {
            	 session = Session.getInstance(props,
            	            new javax.mail.Authenticator() {
            	            protected PasswordAuthentication getPasswordAuthentication() {
            	            return new PasswordAuthentication(username, password);
            	            }
            	            });
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email_from));
                  message.setRecipients(Message.RecipientType.TO,
                  InternetAddress.parse(email_to));
//                  message.setRecipients(Message.RecipientType.CC,
//                  InternetAddress.parse(email_CC));
                  message.setSubject(subject);
                  message.setText("This is Test case execution status");

                 // BodyPart messageBodyPart = new MimeBodyPart();
                  //messageBodyPart.setContent("");
                  //Multipart multipart = new MimeMultipart("related");
                  //multipart.addBodyPart(messageBodyPart);
                 // message.setContent(multipart);

                  //
                  // Send message
                        try {
							try{
							Transport.send(message);
							System.out.println("Sent Mail successfully....");
							//String Result="Mail Sent Successfully....";
							}
							      catch (MessagingException e) {
							                  throw new RuntimeException(e);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        
                  //return Result;
      }catch(Exception e){
            e.printStackTrace();
      }
            
      }
      
      public static void sendMailWithbody(String subject, String htmlmessage)
      {
    	  
    	  try {
         	 session = Session.getInstance(props,
         	            new javax.mail.Authenticator() {
         	            protected PasswordAuthentication getPasswordAuthentication() {
         	            return new PasswordAuthentication(username, password);
         	            }
         	            });
         	 
         	 	MimeBodyPart mbp = new MimeBodyPart(); 
         	 	mbp.setContent(htmlmessage, "text/html"); 
         	 	MimeMultipart multipart = new MimeMultipart(); 
         	 	multipart.addBodyPart(mbp);
         	 
         	 	MimeMessage message = new MimeMessage(session);
         	 	
               //Message message = new MimeMessage(session);
               message.setFrom(new InternetAddress(email_from));
               message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(email_to));
//               message.setRecipients(Message.RecipientType.CC,
//               InternetAddress.parse(email_CC));
               message.setContent(multipart);
               message.setSubject(subject);
               message.setText(htmlmessage, "UTF-8", "html");
               
               // BodyPart messageBodyPart = new MimeBodyPart();
               //messageBodyPart.setContent("");
               //Multipart multipart = new MimeMultipart("related");
               //multipart.addBodyPart(messageBodyPart);
              // message.setContent(multipart);

               //
               // Send message
                     try {
							try{
							Transport.send(message);
							System.out.println("Sent Mail successfully....");
							//String Result="Mail Sent Successfully....";
							}
							      catch (MessagingException e) {
							                  throw new RuntimeException(e);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                     
               //return Result;
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }
    	  
                 
      }
      
      public static void sendBasicMail(String subject, String body)
      {
            String Result;
            
            try {
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email_from));
                  message.setRecipients(Message.RecipientType.TO,
                  InternetAddress.parse(email_to));
//                  message.setRecipients(Message.RecipientType.CC,
//                  InternetAddress.parse(email_CC));
            
                  
                  message.setSubject(subject);
                  // Create the message part
                  BodyPart messageBodyPart = new MimeBodyPart();
                  // Now set the actual message
                  messageBodyPart.setText(body);
                  // Create a multipart message
                  Multipart multipart = new MimeMultipart("related");
                  // Set text message part
                  multipart.addBodyPart(messageBodyPart);
                  // Part two is attachment
                  //TC Attachment
                  MimeBodyPart mb1 = new MimeBodyPart();
//                      String filename = "D:/OFFICE/Selinium/CPG_Product_Automation/Automation_TC_WEB_V1.xls";
                  //String filename = "D:\\Data\\f1\\f1\\test-output\\emailable-report.html";
                  //DataSource source = new FileDataSource(filename);
                  //mb1.setDataHandler(new DataHandler(source));
                  //mb1.setFileName(filename);
                  //multipart.addBodyPart(mb1);
                  
                  message.setContent(multipart);
                  // Send message
                        try {
							try{
							Transport.send(message);
							System.out.println("Sent Mail successfully....");
							//String Result="Mail Sent Successfully....";
							}
							      catch (MessagingException e) {
							                  throw new RuntimeException(e);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        
                  //return Result;
      }catch(Exception e){
            e.printStackTrace();
      }
            //return Result;
      }
      
      public static void sendMailWithAtt(String subject, String body,String filePath)
      {
            String Result;
            
            try {
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email_from));
                  message.setRecipients(Message.RecipientType.TO,
                  InternetAddress.parse(email_to));
//                  message.setRecipients(Message.RecipientType.CC,
//                  InternetAddress.parse(email_CC));
            
                  
                  message.setSubject(subject);
                  // Create the message part
                  BodyPart messageBodyPart = new MimeBodyPart();
                  // Now set the actual message
                  messageBodyPart.setText(body);
                  // Create a multipart message
                  Multipart multipart = new MimeMultipart("related");
                  // Set text message part
                  multipart.addBodyPart(messageBodyPart);
                  // Part two is attachment
                  //TC Attachment
                  MimeBodyPart mb1 = new MimeBodyPart();
                //String filename = "D:/OFFICE/Selinium/CPG_Product_Automation/Automation_TC_WEB_V1.xls";
                  //String filename = "D:\\Data\\f1\\f1\\test-output\\emailable-report.html";
                  String filename=filePath;
                  DataSource source = new FileDataSource(filename);
                  mb1.setDataHandler(new DataHandler(source));
                  mb1.setFileName(filename);
                  multipart.addBodyPart(mb1);
                  
                  message.setContent(multipart);
                  // Send message
                        try {
							try{
							Transport.send(message);
							System.out.println("Sent Mail successfully....");
							//String Result="Mail Sent Successfully....";
							}
							      catch (MessagingException e) {
							                  throw new RuntimeException(e);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        
                  //return Result;
      }catch(Exception e){
            e.printStackTrace();
      }
            //return Result;
      }
      
      
      public static String sendBHTMLBodyMail()
      {
            
            
            return "Send Successfully";
      }
                  
}
