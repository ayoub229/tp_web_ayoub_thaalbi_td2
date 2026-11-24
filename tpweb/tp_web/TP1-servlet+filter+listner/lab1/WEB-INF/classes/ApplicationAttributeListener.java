import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
public class ApplicationAttributeListener
        implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {

        System.out.println("Application attribute added!");
        System.out.println("Name: " + event.getName());
        System.out.println("Value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

        System.out.println("Application attribute removed!");
        System.out.println("Name: " + event.getName());
        System.out.println("Value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

        System.out.println("Application attribute replaced!");
        System.out.println("Name: " + event.getName());
        System.out.println("Old value: " + event.getValue());
    }
}