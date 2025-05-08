<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuarios</title>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Nombre</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.username}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios/agregar">Agregar Nuevo Usuario</a>
</body>
</html>
