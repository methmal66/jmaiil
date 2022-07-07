package lk.methmal.jmail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws MessagingException {
        Properties props = new DefaultProperties("smtp.mail.yahoo.com").config();
        Session ses = new AuthenticatableSession(props).auth("methmal66@yahoo.com", System.getenv("JMAIL_PASSWORD"));
        MimeMessage email = new Email(ses)
                .set("methmal66@yahoo.com",
                        "methmal66@gmail.com",
                        "This is a test");

        Transport port = ses.getTransport("smtp");
        port.connect();
        port.sendMessage(email, email.getRecipients(Message.RecipientType.TO));
        port.close();
    }
}