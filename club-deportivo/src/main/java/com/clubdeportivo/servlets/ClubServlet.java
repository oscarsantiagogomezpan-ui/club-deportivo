<<<<<<< HEAD
package com.clubdeportivo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Anotación para definir la ruta del Servlet
@WebServlet("/ClubServlet")
public class ClubServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Método GET: Se ejecuta cuando se accede por URL directa o un enlace (<a>)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Consulta GET</title></head><body>");
            
            if ("listar".equals(accion)) {
                out.println("<h2>Has accedido mediante el método GET</h2>");
                out.println("<p>Aquí se mostraría la lista de clubes consultada desde la base de datos.</p>");
            } else {
                out.println("<h2>Petición GET recibida</h2>");
            }
            
            out.println("<a href='index.jsp'>Volver al formulario</a>");
            out.println("</body></html>");
        }
    }

    // Método POST: Se ejecuta cuando se envía el formulario HTML
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibir los parámetros del formulario HTML
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String deporte = request.getParameter("deporte");

        // 2. Preparar los datos para enviarlos a la vista (JSP)
        request.setAttribute("nombre", nombre);
        request.setAttribute("direccion", direccion);
        request.setAttribute("deporte", deporte);

        // 3. Redirigir (Forward) a la página resultado.jsp
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}
=======
package com.clubdeportivo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Anotación para definir la ruta del Servlet
@WebServlet("/ClubServlet")
public class ClubServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Método GET: Se ejecuta cuando se accede por URL directa o un enlace (<a>)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Consulta GET</title></head><body>");
            
            if ("listar".equals(accion)) {
                out.println("<h2>Has accedido mediante el método GET</h2>");
                out.println("<p>Aquí se mostraría la lista de clubes consultada desde la base de datos.</p>");
            } else {
                out.println("<h2>Petición GET recibida</h2>");
            }
            
            out.println("<a href='index.jsp'>Volver al formulario</a>");
            out.println("</body></html>");
        }
    }

    // Método POST: Se ejecuta cuando se envía el formulario HTML
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibir los parámetros del formulario HTML
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String deporte = request.getParameter("deporte");

        // 2. Preparar los datos para enviarlos a la vista (JSP)
        request.setAttribute("nombre", nombre);
        request.setAttribute("direccion", direccion);
        request.setAttribute("deporte", deporte);

        // 3. Redirigir (Forward) a la página resultado.jsp
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}
>>>>>>> cdbfaf589c4e9a8f008c0834dad45af30f805abb
