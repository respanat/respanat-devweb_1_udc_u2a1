<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Computador</title>
</head>
<body>
    <h1>Agregar Nuevo Computador</h1>
    <form action="<%= request.getContextPath() %>/computadores/agregar" method="post">
        <label for="marca">Marca:</label><br>
        <input type="text" id="marca" name="marca" required><br><br>

        <label for="categoria">Categoría:</label><br>
        <input type="text" id="categoria" name="categoria"><br><br>

        <label for="marcaCpu">Marca CPU:</label><br>
        <input type="text" id="marcaCpu" name="marcaCpu"><br><br>

        <label for="velocidadCpu">Velocidad CPU:</label><br>
        <input type="text" id="velocidadCpu" name="velocidadCpu"><br><br>

        <label for="tecnologiaRam">Tecnología RAM:</label><br>
        <input type="text" id="tecnologiaRam" name="tecnologiaRam"><br><br>

        <label for="capacidadRam">Capacidad RAM:</label><br>
        <input type="text" id="capacidadRam" name="capacidadRam"><br><br>

        <label for="tecnologiaDisco">Tecnología Disco:</label><br>
        <input type="text" id="tecnologiaDisco" name="tecnologiaDisco"><br><br>

        <label for="capacidadDisco">Capacidad Disco:</label><br>
        <input type="text" id="capacidadDisco" name="capacidadDisco"><br><br>

        <label for="numPuertosUSB">Número Puertos USB:</label><br>
        <input type="number" id="numPuertosUSB" name="numPuertosUSB"><br><br>

        <label for="numPuertosHDMI">Número Puertos HDMI:</label><br>
        <input type="number" id="numPuertosHDMI" name="numPuertosHDMI"><br><br>

        <label for="MarcaMonitor">Marca Monitor:</label><br>
        <input type="text" id="MarcaMonitor" name="MarcaMonitor"><br><br>

        <label for="pulgadas">Pulgadas Monitor:</label><br>
        <input type="text" id="pulgadas" name="pulgadas"><br><br>

        <label for="precio">Precio:</label><br>
        <input type="text" id="precio" name="precio"><br><br>

        <input type="submit" value="Guardar Computador">
    </form>
    <br>
    <a href="<%= request.getContextPath() %>/computadores/listar">Ver Lista de Computadores</a>
</body>
</html>
