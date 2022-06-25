package lk.methmal;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class App {

private static final String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
private static final String SMTP_AUTH_USER = "methmal66@yahoo.com";
private static final String SMTP_AUTH_PWD  = "mhsvibhwhwofvynq";

public static void main(String[] args) throws Exception{
   new App().test();
}

public void test() {
    Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.port", "465");        
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl","true");
        props.put("mail.smtp.auth", "true"); 

        Session session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
                }
              });

        try {

            Transport transport = session.getTransport("smtp");

            MimeMessage message = new MimeMessage(session);
            message.setContent("This is a test", "text/plain");
            message.setFrom(new InternetAddress(SMTP_AUTH_USER));
            message.addRecipient(Message.RecipientType.TO,
                new InternetAddress("methmal66@gmail.com"));
            

            transport.connect();
            transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
            transport.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}