<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %> <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado del Registro</title>
</head>
<body>

    <h2>¡Registro Exitoso!</h2>

    <%-- Scriptlet JSP: Código Java incrustado para obtener la fecha actual --%>
    <% 
        Date fechaRegistro = new Date(); 
        String nombreClub = (String) request.getAttribute("nombre");
        String direccionClub = (String) request.getAttribute("direccion");
        String deporteClub = (String) request.getAttribute("deporte");
    %>

    <p>Los datos del club han sido procesados correctamente por el servidor.</p>

    <ul>
        <%-- Expresiones JSP para imprimir variables en el HTML --%>
        <li><strong>Nombre:</strong> <%= nombreClub %></li>
        <li><strong>Dirección:</strong> <%= direccionClub %></li>
        <li><strong>Deporte:</strong> <%= deporteClub %></li>
    </ul>

    <p><em>Fecha de operación: <%= fechaRegistro.toString() %></em></p>

    <br>
    <a href="index.jsp">Volver al inicio</a>

</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %> <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado del Registro</title>
</head>
<body>

    <h2>¡Registro Exitoso!</h2>

    <%-- Scriptlet JSP: Código Java incrustado para obtener la fecha actual --%>
    <% 
        Date fechaRegistro = new Date(); 
        String nombreClub = (String) request.getAttribute("nombre");
        String direccionClub = (String) request.getAttribute("direccion");
        String deporteClub = (String) request.getAttribute("deporte");
    %>

    <p>Los datos del club han sido procesados correctamente por el servidor.</p>

    <ul>
        <%-- Expresiones JSP para imprimir variables en el HTML --%>
        <li><strong>Nombre:</strong> <%= nombreClub %></li>
        <li><strong>Dirección:</strong> <%= direccionClub %></li>
        <li><strong>Deporte:</strong> <%= deporteClub %></li>
    </ul>

    <p><em>Fecha de operación: <%= fechaRegistro.toString() %></em></p>

    <br>
    <a href="index.jsp">Volver al inicio</a>

</body>
>>>>>>> cdbfaf589c4e9a8f008c0834dad45af30f805abb
</html>