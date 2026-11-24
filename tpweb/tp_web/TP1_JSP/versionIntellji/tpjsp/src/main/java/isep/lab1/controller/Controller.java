package isep.lab1.controller;

import isep.lab1.bean.Person;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// L'URL de la servlet sera /Controller
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupérer les données du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        // 2. Créer le bean Person
        Person person = new Person(firstName, lastName, birthDay, sex);

        // 3. Mettre le bean dans la requête
        request.setAttribute("personne", person);

        // 4. Rediriger vers la bonne page JSP selon l'année de naissance
        // On extrait l'année (le format est mm/dd/yyyy)
        String yearStr = birthDay.substring(birthDay.length() - 4);
        int year = Integer.parseInt(yearStr);

        if (year < 1990) {
            request.getRequestDispatcher("/old.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/young.jsp").forward(request, response);
        }
    }
}