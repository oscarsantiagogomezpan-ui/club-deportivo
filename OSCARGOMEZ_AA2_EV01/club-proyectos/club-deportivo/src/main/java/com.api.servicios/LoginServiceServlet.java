package com.api.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Definimos la ruta de la API para el inicio de sesión
@WebServlet("/api/login")
public class LoginServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Configuramos el tipo de contenido de la respuesta
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 1. Recibimos las credenciales enviadas a la API
        String usuarioReq = request.getParameter("usuario");
        String contrasenaReq = request.getParameter("contrasena");

        // 2. Validaciones para evitar datos nulos
        if (usuarioReq == null || contrasenaReq == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
            out.print("error en la autenticación"); // Mensaje exigido por la guía
            return;
        }

        // 3. Verificación de credenciales
        boolean esValido = BaseDatosUsuarios.validarUsuario(usuarioReq, contrasenaReq);

        // 4. Respuesta según las validaciones exactas de la guía
        if (esValido) {
            response.setStatus(HttpServletResponse.SC_OK); // 200 OK
            out.print("autenticación satisfactoria"); // Mensaje exacto de la guía
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 No autorizado
            out.print("error en la autenticación"); // Mensaje exacto de la guía
        }
    }
}
