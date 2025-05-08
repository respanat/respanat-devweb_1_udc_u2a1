<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login de Usuario</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <c:if test="${not empty errorLogin}">
        <p style="color: red;">${errorLogin}</p>
    </c:if>
    <form action="<%= request.getContextPath() %>/usuarios/login" method="post">
        <label for="username">Nombre de Usuario:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Iniciar Sesión">
    </form>
    <br>
    <a href="#">¿Olvidó su contraseña?</a> </body>
</html>
