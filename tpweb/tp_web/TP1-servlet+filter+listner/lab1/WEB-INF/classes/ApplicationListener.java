package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[ApplicationListener] >>> Application STARTED");
        sce.getServletContext().setAttribute("appName", "ING1 Web Application");
        System.out.println("[ApplicationListener] appName attribute set.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[ApplicationListener] <<< Application STOPPED");
    }  
}