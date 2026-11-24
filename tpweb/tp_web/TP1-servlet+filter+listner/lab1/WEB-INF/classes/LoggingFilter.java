import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {
    // On utilise le même nom partout : logPrefix
    private String logPrefix;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.logPrefix = filterConfig.getInitParameter("logPrefix");
        if(this.logPrefix == null) {
            this.logPrefix = "[DEFAULT]";
        }
        System.out.println("=== " + logPrefix + " [LoggingFilter] Initialisé ========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        long debut = System.nanoTime(); // Chrono de départ

        // ICI : logPrefix au lieu de logPrefixe
        System.out.println(logPrefix + " Requête reçue pour l'URL : " + req.getRequestURI());

        chain.doFilter(request, response); // La servlet travaille

        long fin = System.nanoTime(); // Chrono de fin
        long dureeMs = (fin - debut) / 1_000_000; // Conversion en millisecondes

        // ICI : logPrefix au lieu de logPrefixe
        System.out.println(logPrefix + " Terminé pour l'URL : " + req.getRequestURI() 
                           + " | Durée : " + dureeMs + " ms");
    }

    @Override
    public void destroy(){
        System.out.println("=== " + logPrefix + " [LoggingFilter] Détruit ===");
    }
}