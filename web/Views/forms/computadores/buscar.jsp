<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Computador</title>
</head>
<body>
    <h1>Buscar Computador</h1>
    <form action="#" method="get"> <label for="id">ID del Computador:</label><br>
        <input type="number" id="id" name="id"><br><br>
        <input type="submit" value="Buscar">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/computadores/listar">Ver Lista de Computadores</a>
</body>
</html>
