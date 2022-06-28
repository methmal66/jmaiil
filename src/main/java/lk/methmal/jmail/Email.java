package lk.methmal.jmail;

import javax.mail.*;
import javax.mail.internet.*;

public class Email {
    private MimeMessage msg;

    public Email(Session ses) {
        this.msg = new MimeMessage(ses);
    }

    public MimeMessage set(String from, String to, String body) throws MessagingException {
        this.msg.setFrom(from);
        this.msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        this.msg.setContent(body, "text/plain");
        return this.msg;
    }
}
