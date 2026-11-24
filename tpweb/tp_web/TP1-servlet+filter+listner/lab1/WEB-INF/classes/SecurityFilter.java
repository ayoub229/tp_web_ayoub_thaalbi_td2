import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=== [SecurityFilter] Initialisé ===");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        boolean isLoggedIn =
                (session != null && session.getAttribute("user") != null);

        if (isLoggedIn) {
            System.out.println("[SecurityFilter] Accès AUTORISÉ pour "
                    + req.getRequestURI());

            chain.doFilter(request, response);

        } else {
            System.out.println("[SecurityFilter] Accès REFUSÉ. Redirection.");

            res.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }
    }

    @Override
    public void destroy() {
        System.out.println("=== [SecurityFilter] Détruit ===");
    }
}