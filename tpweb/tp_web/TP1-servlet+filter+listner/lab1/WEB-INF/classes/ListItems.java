import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ListItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        afficherListe(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
            HttpSession session=request.getSession();
            Map<String,Integer> items=(Map<String,Integer>)session.getAttribute("items");
            if(items == null ){
                items=new HashMap<String,Integer>();
                session.setAttribute("items",items);
            }           

            String nvelem=request.getParameter("newItem");
            if (nvelem != null && !nvelem.trim().isEmpty()){
                int value = items.getOrDefault(nvelem.trim(),0);
                items.put(nvelem.trim(),value+1);

            }

            afficherListe(request, response);
}

 private void afficherListe(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {


                HttpSession session=request.getSession();
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                Map<String,Integer> items=(Map<String,Integer>) session.getAttribute("items");
                if(items == null || items.isEmpty()){
                     out.println("<p>Aucun item pour le moment.</p>");
                }
                else{
                    out.println("<ul>");
                    for(Map.Entry<String,Integer> entry :items.entrySet()){
                        out.println("<li>"+entry.getKey() +" (x"+entry.getValue() +")</li>");

                    }
                    out.println("</ul>");

                }
                out.println("<br/><a href='items.html'>Retour au formulaire</a>");
        out.println("</body></html>");

            }

}