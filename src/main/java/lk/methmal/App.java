package lk.methmal;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws MessagingException {
        Properties props = new DefaultProperties("smtp.mail.yahoo.com").config();
        Session ses = new AuthenticatableSession(props).auth("methmal66@yahoo.com", "klfslwvounsasekd");
        MimeMessage email = new Email(ses)
                .set("methmal66@yahoo.com",
                        "methmal66@gmail.com",
                        "This is a test");
        EasyTransport port = new EasyTransport(ses);
        port.sendMessage(email);
    }
}