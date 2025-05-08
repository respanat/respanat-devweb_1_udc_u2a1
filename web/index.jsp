<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido</title>
</head>
<body>
    <h1>¡Bienvenido a la actividad 2 de desarrollo web</h1>
    <p>Por favor, inicia sesión.</p>
    <p><a href="<%= request.getContextPath() %>/usuarios/login">Iniciar Sesión</a></p>
</body>
</html>
