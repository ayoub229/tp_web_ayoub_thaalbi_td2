import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener
        implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {

        System.out.println("Request attribute added!");
        System.out.println("Name: " + event.getName());
        System.out.println("Value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {

        System.out.println("Request attribute removed!");
        System.out.println("Name: " + event.getName());
        System.out.println("Value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {

        System.out.println("Request attribute replaced!");
        System.out.println("Name: " + event.getName());
        System.out.println("Old value: " + event.getValue());
    }
}