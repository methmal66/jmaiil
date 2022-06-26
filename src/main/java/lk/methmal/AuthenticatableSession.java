package lk.methmal;

import java.util.Properties;
import javax.mail.*;

public class AuthenticatableSession {
    private Properties props;

    public AuthenticatableSession(Properties props) {
        this.props = props;
    }

    public Session auth(final String username, final String password) {
        Session ses = Session.getInstance(this.props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return ses;
    }
}
