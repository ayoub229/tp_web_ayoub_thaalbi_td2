import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {

        ServletContext context = event.getSession().getServletContext();

        AtomicInteger counter =
                (AtomicInteger) context.getAttribute("activeSessions");

        if (counter == null) {
            counter = new AtomicInteger(0);
            context.setAttribute("activeSessions", counter);
        }

        int value = counter.incrementAndGet();

        System.out.println("Session created. Active sessions = " + value);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        ServletContext context = event.getSession().getServletContext();

        AtomicInteger counter =
                (AtomicInteger) context.getAttribute("activeSessions");

        if (counter != null) {
            int value = counter.decrementAndGet();

            System.out.println("Session destroyed. Active sessions = " + value);
        }
    }
}