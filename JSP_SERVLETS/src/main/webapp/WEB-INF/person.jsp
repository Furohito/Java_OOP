<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.jsp_servlet.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Hello World!</h1>

    <%
        if (request.getAttribute("personRecord") != null) {
            Person person = (Person) request.getAttribute("personRecord");
    %>

    <h1>Person Record</h1>
    <div>ID: <%= person.getId() %></div>
    <div>Name: <%= person.getName() %></div>
    <div>Age: <%= person.getAge() %></div>

    <%
        } else {
    %>

    <h1>No person found.</h1>

    <%
        }
    %>
</body>
</html>
