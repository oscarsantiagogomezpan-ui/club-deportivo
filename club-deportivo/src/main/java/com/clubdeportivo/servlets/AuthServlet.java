package com.clubdeportivo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/api/*")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (path.equals("/registro")) {

            // Simulación registro (luego lo conectamos a BD)
            out.println("Usuario registrado correctamente.");
            response.setStatus(HttpServletResponse.SC_CREATED);

        } else if (path.equals("/login")) {

            if ("oscar".equals(usuario) && "12345".equals(contrasena)) {
                out.println("autenticación satisfactoria");
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                out.println("error en la autenticación");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}