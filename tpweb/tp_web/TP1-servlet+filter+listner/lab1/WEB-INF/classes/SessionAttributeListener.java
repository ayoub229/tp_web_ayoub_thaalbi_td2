import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener
        implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        System.out.println("Session attribute added!");

        System.out.println("Name: " + event.getName());
        System.out.println("Value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

        System.out.println("Session attribute removed!");

        System.out.println("Name: " + event.getName());
        System.out.println("Value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

        System.out.println("Session attribute replaced!");

        System.out.println("Name: " + event.getName());

        // Attention : getValue() donne ici l'ancienne valeur.
        System.out.println("Old value: " + event.getValue());
    }
}