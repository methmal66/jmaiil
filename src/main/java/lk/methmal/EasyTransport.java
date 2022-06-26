package lk.methmal;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Transport;
import javax.mail.Session;

/**
 * EasyTransport
 */
public class EasyTransport {
    private Transport port;

    public EasyTransport(Session ses) throws NoSuchProviderException {
        this.port = ses.getTransport("smtp");
    }

    public void sendMessage(Message msg) throws MessagingException {
        this.port.connect();
        this.port.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
        this.port.close();
    }
}