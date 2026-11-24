import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {

        System.out.println("Request started!");

        System.out.println("URL: " +
                event.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {

        System.out.println("Request finished!");
    }
}