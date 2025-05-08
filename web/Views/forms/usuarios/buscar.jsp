<%-- web/Views/forms/usuarios/buscar.jsp --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Usuario</title>
</head>
<body>
    <h1>Buscar Usuario</h1>
    <form action="#" method="get"> <label for="id">ID del Usuario:</label><br>
        <input type="number" id="id" name="id"><br><br>
        <input type="submit" value="Buscar">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios/listar">Ver Lista de Usuarios</a>
</body>
</html>
