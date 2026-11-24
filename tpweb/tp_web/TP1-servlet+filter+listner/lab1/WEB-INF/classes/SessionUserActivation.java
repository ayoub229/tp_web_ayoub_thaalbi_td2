import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class SessionUserActivation
        implements HttpSessionActivationListener, Serializable {

    private String username;

    public SessionUserActivation(String username) {
        this.username = username;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent event) {

        System.out.println(username + " session is passivating!");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent event) {

        System.out.println(username + " session is activating!");
    }
}