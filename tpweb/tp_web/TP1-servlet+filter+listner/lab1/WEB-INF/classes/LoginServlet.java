import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        SessionUser user = new SessionUser(username);
        session.setAttribute("user", user);

        out.println("<!DOCTYPE html><html><body>");
        out.println("<h1>Bienvenue, " + username + " !</h1>");
        out.println("<p>Vous êtes maintenant connecté.</p>");
        out.println("<a href='items.html'>Aller à la page des items</a>");
        out.println("</body></html>");

        request.setAttribute("nom", "Ayoub");
        request.setAttribute("nom", "Ali");
        request.removeAttribute("nom");
    }
}