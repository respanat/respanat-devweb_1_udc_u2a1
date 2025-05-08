<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recordar Contraseña</title>
</head>
<body>
    <h1>Recordar Contraseña</h1>
    <form action="#" method="post"> <label for="email">Correo Electrónico:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="Enviar Solicitud">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/usuarios/login">Volver al Login</a>
</body>
</html>
