<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Computadores</title>
</head>
<body>
    <h1>Lista de Computadores</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Categoría</th>
                <th>Marca CPU</th>
                <th>Velocidad CPU</th>
                <th>RAM</th>
                <th>Disco</th>
                <th>USB</th>
                <th>HDMI</th>
                <th>Monitor</th>
                <th>Pulgadas</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="computador" items="${computadores}">
                <tr>
                    <td>${computador.id}</td>
                    <td>${computador.marca}</td>
                    <td>${computador.categoria}</td>
                    <td>${computador.marcaCpu}</td>
                    <td>${computador.velocidadCpu}</td>
                    <td>${computador.tecnologiaRam} ${computador.capacidadRam}</td>
                    <td>${computador.tecnologiaDisco} ${computador.capacidadDisco}</td>
                    <td>${computador.numPuertosUSB}</td>
                    <td>${computador.numPuertosHDMI}</td>
                    <td>${computador.marcaMonitor}</td>
                    <td>${computador.pulgadas}</td>
                    <td>${computador.precio}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<%= request.getContextPath() %>/computadores/agregar">Agregar Nuevo Computador</a>
</body>
</html>
