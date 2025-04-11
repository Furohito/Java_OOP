<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tambah Data</title>
</head>
<body>
    <h1>Hello World!</h1>
    <%@ page import = "java.sql.*" %>
    <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3307/hbdb", "root", "1234");
        String query = "INSERT INTO person (name, age) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, "John");
        ps.setInt(2, 45);
        int result = ps.executeUpdate();
    %>
    <p>Hasil eksekusi: <%= result %></p>
</body>
</html>
