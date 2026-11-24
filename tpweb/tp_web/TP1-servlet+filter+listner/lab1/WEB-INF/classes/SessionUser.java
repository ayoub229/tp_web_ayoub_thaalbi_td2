import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

public class SessionUser
        implements HttpSessionBindingListener, Serializable {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {

        System.out.println(username + " entered the session!");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

        System.out.println(username + " left the session!");
    }
}