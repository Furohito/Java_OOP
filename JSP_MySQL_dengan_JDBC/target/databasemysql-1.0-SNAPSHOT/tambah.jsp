<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tambah Data</title>
</head>
<body>
    <h1>Hello World!</h1>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="com.latihan.hibernate.Person" %>


    <%
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

            Person p1 = new Person("John", 35);
            Person p2 = new Person("Tina", 30);

            Session sf = sessionFactory.openSession();
            sf.beginTransaction();
            sf.save(p1);
            sf.save(p2);
            sf.getTransaction().commit();
            sf.close();

        } catch (Exception e) {
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            e.printStackTrace(pw);
            out.println("<pre>" + sw.toString() + "</pre>");
        }
    %>

    <p>Cek Tabel <b>MySQL</b></p>
</body>
</html>
