package com.clubdeportivo.dao;

import java.sql.*;

public class ClubesDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/clubdb";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "TU_PASSWORD";

    // Método para listar clubes
    public void listarClubes() {
        String sql = "SELECT * FROM clubes";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== LISTA DE CLUBES ===");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("nombre") + " - " +
                    rs.getString("direccion") + " - " +
                    rs.getString("deporte")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}