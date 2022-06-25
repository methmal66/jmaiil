package lk.methmal;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class App {

    private static final String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
    private static final String SMTP_AUTH_USER = "methmal66@yahoo.com";
    private static final String SMTP_AUTH_PWD = "mhsvibhwhwofvynq";

    public static void main(String[] args) throws MessagingException {
        App app = new App();
        Properties props = app.getManagedProperties();
        Session ses = app.createAuthenticatedSession(props);
        Transport transport = ses.getTransport("smtp");
        MimeMessage email = app.buildEmail(ses);
        app.transferMessage(transport, email);
    }

    public Properties getManagedProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl", "true");
        props.put("mail.smtp.auth", "true");
        return props;
    }

    public Session createAuthenticatedSession(Properties props) {
        return Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
                    }
                });
    }

    public MimeMessage buildEmail(Session ses) throws MessagingException {
        MimeMessage msg = new MimeMessage(ses);
        msg.setContent("This is a test", "text/plain");
        msg.setFrom(new InternetAddress(SMTP_AUTH_USER));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("methmal66@gmail.com"));
        return msg;
    }

    public void transferMessage(Transport port, MimeMessage msg) throws MessagingException {
        port.connect();
        port.sendMessage(msg,
                msg.getRecipients(Message.RecipientType.TO));
        port.close();
    }
}