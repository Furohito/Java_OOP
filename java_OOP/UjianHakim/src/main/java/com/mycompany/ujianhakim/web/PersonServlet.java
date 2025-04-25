package com.mycompany.ujianhakim.web;

import com.mycompany.ujianhakim.dao.PersonDAO;
import com.mycompany.ujianhakim.model.Person;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonDAO personDAO = new PersonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Person> persons = personDAO.getAllPersons();
        request.setAttribute("persons", persons);
        RequestDispatcher dispatcher = request.getRequestDispatcher("person.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cek apakah ini request untuk delete
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                try {
                    int id = Integer.parseInt(idStr);
                    personDAO.deletePerson(id);
                } catch (NumberFormatException e) {
                    // bisa log error di sini jika diperlukan
                }
            }
            response.sendRedirect("persons");
            return;
        }

        // Proses tambah data seperti biasa
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthYearStr = request.getParameter("birthYear");

        String error = null;
        int birthYear = 0;
        if (firstName == null || firstName.isEmpty() ||
            lastName == null || lastName.isEmpty() ||
            birthYearStr == null || birthYearStr.isEmpty()) {
            error = "Semua field harus diisi!";
        } else {
            try {
                birthYear = Integer.parseInt(birthYearStr);
            } catch (NumberFormatException e) {
                error = "Tahun lahir harus angka!";
            }
        }

        if (error == null) {
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setBirthYear(birthYear);
            personDAO.savePerson(person);
            response.sendRedirect("persons");
        } else {
            request.setAttribute("error", error);
            doGet(request, response);
        }
    }
}