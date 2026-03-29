package com.clubdeportivo.dao;

import java.sql.*;

public class UsuarioDAO {
    // Configuración de la conexión (Ajusta según tu entorno)
    private String url = "jdbc:mysql://localhost:3306/clubdb";
    private String user = "root";
    private String pass = "Santiago2004#";

    // Método para registrar un nuevo usuario
    public boolean registrar(String username, String password) {
        String sql = "INSERT INTO usuarios (nombre_usuario, contrasena) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para validar el inicio de sesión
    public boolean validar(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next(); // Retorna true si encuentra coincidencia
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}