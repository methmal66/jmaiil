package lk.methmal.jmail;

import java.util.Properties;

public class DefaultProperties {
    private Properties props;

    public DefaultProperties(String host) {
        this.props = new Properties();
        this.props.put("mail.smtp.host", host);
    }

    public Properties config() {
        this.props.put("mail.smtp.port", "465");
        this.props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        this.props.put("mail.smtp.ssl", "true");
        this.props.put("mail.smtp.auth", "true");
        return this.props;
    }
}
