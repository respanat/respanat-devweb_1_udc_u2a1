<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Usuario</title>
</head>
<body>
    <h1>Agregar Nuevo Usuario</h1>
    <form action="<%= request.getContextPath() %>/usuarios/agregar" method="post">
        <label for="username">Nombre de Usuario:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <label for="nombre">Nombre Completo:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="email">Correo Electrónico:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="Guardar Usuario">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios/listar">Ver Lista de Usuarios</a>
</body>
</html>
