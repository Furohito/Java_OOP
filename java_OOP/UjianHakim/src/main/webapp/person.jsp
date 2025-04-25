<%-- 
    Document   : person
    Created on : 25 Apr 2025, 20:56:10
    Author     : Hakim
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person List</title>
</head>
<body>
<h2>Tambah Person</h2>
<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>
<form method="post" action="persons">
    Nama Depan: <input type="text" name="firstName" /><br/>
    Nama Belakang: <input type="text" name="lastName" /><br/>
    Tahun Lahir: <input type="text" name="birthYear" /><br/>
    <input type="submit" value="Tambah" />
</form>

<h2>Daftar Person</h2>
<table border="1">
    <tr>
        <th>Nama</th>
        <th>Tahun Lahir</th>
        <th>Aksi</th>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.firstName} ${person.lastName}</td>
            <td>${person.birthYear}</td>
            <td>
                <form action="persons" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${person.id}"/>
                    <input type="submit" value="Delete" onclick="return confirm('Yakin hapus?')"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>