<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Clubes Deportivos</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .formulario { border: 1px solid #ccc; padding: 20px; width: 300px; border-radius: 5px; }
        input[type="text"], input[type="date"] { width: 100%; padding: 8px; margin: 10px 0; }
        button { background-color: #28a745; color: white; padding: 10px; border: none; width: 100%; cursor: pointer;}
    </style>
</head>
<body>

    <h2>Registro de Nuevo Club Deportivo</h2>
    
    <div class="formulario">
        <form action="ClubServlet" method="POST">
            <label for="nombre">Nombre del Club:</label>
            <input type="text" id="nombre" name="nombre" required>

            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" required>

            <label for="deporte">Deporte Principal:</label>
            <input type="text" id="deporte" name="deporte" required>

            <button type="submit">Registrar Club</button>
        </form>
    </div>

    <br>
    <a href="ClubServlet?accion=listar">Ver clubes registrados (Prueba de método GET)</a>

</body>
</html>