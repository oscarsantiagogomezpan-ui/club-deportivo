package com.clubdeportivo.api;

import com.clubdeportivo.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/api/registro")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("usuario");
        String pass = request.getParameter("contrasena");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if (user == null || pass == null || user.isEmpty() || pass.isEmpty()) {
            response.getWriter().write("Error: Datos incompletos");
            return;
        }

        if (dao.registrar(user, pass)) {
            response.getWriter().write("Registro exitoso");
        } else {
            response.getWriter().write("Error: El usuario ya existe");
        }
    }
}