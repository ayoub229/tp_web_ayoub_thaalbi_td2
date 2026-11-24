import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.net.URLEncoder;
import jakarta.servlet.ServletContext;

public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pour bien lire les accents envoyés par le formulaire
        request.setCharacterEncoding("UTF-8");

        // Récupération des paramètres (les "name" du formulaire)
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String birthDay  = request.getParameter("birthDay");
        String sexe = request.getParameter("sexe");


        addCookie(response,"firstName",firstName);
        addCookie(response,"lastName",lastName);
        addCookie(response,"birthday",birthDay);
        addCookie(response,"sexe",sexe);
        ServletContext context = getServletContext();

context.setAttribute("message", "Hello");
context.setAttribute("message", "Bonjour");
context.removeAttribute("message");

        // Type de la réponse
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Génération de la page HTML
        out.println("<html>");
        out.println("<head><title>Résultat</title></head>");
        out.println("<body>");
        out.println("<h1>Informations reçues</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Prénom</th><td>" + firstName + "</td></tr>");
        out.println("<tr><th>Nom</th><td>" + lastName + "</td></tr>");
        out.println("<tr><th>Date de naissance</th><td>" + birthDay + "</td></tr>");
        out.println("<tr><th>gender</th><td>" + sexe + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");

        out.close();
    }
private void addCookie(HttpServletResponse response , String name, String value)throws IOException
{
    if (value == null)  value="";
    value=URLEncoder.encode(value,"UTF-8");
    Cookie c=new Cookie(name,value);
    c.setMaxAge(60*24*60);
    response.addCookie(c);
}

}