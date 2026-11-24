import jakarta.servlet.ServletException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");

        out.println("<h2>Nombre de visites : " + visitCount + "</h2>");

        String fullName = (String) session.getAttribute("fullname");
        String db = (String) session.getAttribute("db");

        if (fullName == null || db == null) {

            out.println("<h1>Welcome on my site</h1>");

            out.println("<form method='POST' action='ShowSession'>");

            out.println("Nom complet : ");
            out.println("<input type='text' name='fullname' required/>");
            out.println("<br/><br/>");

            out.println("Date de naissance (MM/dd/yyyy) : ");
            out.println("<input type='text' name='db' required/>");
            out.println("<br/><br/>");

            out.println("<input type='submit' value='Envoyer'/>");

            out.println("</form>");

        } else {

            LocalDate date = LocalDate.parse(db);

            LocalDate td = LocalDate.now();

            LocalDate nextdb = date.withYear(td.getYear());

            if (td.isAfter(nextdb) || td.isEqual(nextdb)) {
                nextdb = nextdb.plusYears(1);
            }

            long days = ChronoUnit.DAYS.between(td, nextdb);

            out.println("<h1>Welcome back, " + fullName + "!</h1>");

            out.println("<p>There are <strong>"
                    + days
                    + "</strong> days to your birthday.</p>");
        }


        ServletContext context = getServletContext();

        AtomicInteger counter =
                (AtomicInteger) context.getAttribute("activeSessions");

        int activeSessions = (counter == null) ? 0 : counter.get();

        out.println("<h2>Active sessions: " + activeSessions + "</h2>");

        out.println("</body></html>");
    }


    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String fullname = req.getParameter("fullname");
        String db = req.getParameter("db");

        DateTimeFormatter fm = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate d = LocalDate.parse(db, fm);

        session.setAttribute("fullname", fullname);
        session.setAttribute("db", d.toString());

        doGet(req, resp);
    }
}