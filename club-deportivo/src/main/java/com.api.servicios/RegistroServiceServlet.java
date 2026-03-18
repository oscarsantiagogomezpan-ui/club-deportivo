package com.api.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Definimos la ruta de la API para el registro
@WebServlet("/api/registro")
public class RegistroServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Configuramos la respuesta como texto plano/JSON
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 1. Recibimos los parámetros del usuario
        String usuarioReq = request.getParameter("usuario");
        String contrasenaReq = request.getParameter("contrasena");

        // 2. Validaciones básicas (que no estén vacíos)
        if (usuarioReq == null || usuarioReq.isEmpty() || contrasenaReq == null || contrasenaReq.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Error 400
            out.print("Error: Faltan datos para el registro.");
            return;
        }

        // 3. Procesamos el registro en nuestra BD simulada
        boolean registrado = BaseDatosUsuarios.registrarUsuario(usuarioReq, contrasenaReq);

        // 4. Devolvemos la respuesta
        if (registrado) {
            response.setStatus(HttpServletResponse.SC_CREATED); // Éxito 201
            out.print("Usuario registrado correctamente.");
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT); // Error 409
            out.print("Error: El usuario ya existe en el sistema.");
        }
    }
}
