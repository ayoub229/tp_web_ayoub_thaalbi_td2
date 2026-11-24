import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class CountVisits extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{


        int visits=0;
        Cookie[] cookies=request.getCookies();
        if(cookies != null){
            for(Cookie c :cookies){
                if(c.getName().equals("visits")){
                    try{
                        visits=Integer.parseInt(c.getValue());
                    }
                    catch(NumberFormatException e){
                        visits=0;
                    }


                }
            } 
        }
        visits++;
        Cookie c=new Cookie("visits" , String.valueOf(visits));
        c.setMaxAge(60*60*24*360);
        response.addCookie(c);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
         out.println("<html>");
        out.println("<head><title>Visites</title></head>");
        out.println("<body>");
        if (visits == 1) {
            out.println("<h1>Bienvenue sur le site !</h1>");
            out.println("<p>C'est votre première visite.</p>");
        } else {
            out.println("<h1>Bon retour !</h1>");
            out.println("<p>Vous avez visité cette page <b>" + visits + "</b> fois.</p>");
        }
        out.println("<br><a href='form.html'>Retour au formulaire</a>");
        out.println("</body></html>");

        out.close();

    }
}