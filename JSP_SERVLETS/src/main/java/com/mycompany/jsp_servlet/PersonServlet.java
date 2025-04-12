package com.mycompany.jsp_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet(name = "PersonServlet", urlPatterns = {"/PersonServlet"})
public class PersonServlet extends HttpServlet {

    private PersonService personService = new PersonService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String personID = request.getParameter("id");
        if (personID != null) {
            int id = Integer.parseInt(personID);
            request.setAttribute("personRecord", personService.getPerson(id));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/person.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
