import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Cookies</title></head>");
        out.println("<body>");
        out.println("<h1>Cookies lus</h1>");
        out.println("<table border='1'>");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                if (name.equals("firstName") || name.equals("lastName")
                        || name.equals("birthDay") || name.equals("sex")) {
                    String value = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
                    out.println("<tr><th>" + name + "</th><td>" + value + "</td></tr>");
                }
            }
        } else {
            out.println("<tr><td>Aucun cookie trouvé</td></tr>");
        }

        out.println("</table>");
        out.println("<br><a href='form.html'>Retour au formulaire</a>");
        out.println("</body></html>");
        out.close();
    }
}