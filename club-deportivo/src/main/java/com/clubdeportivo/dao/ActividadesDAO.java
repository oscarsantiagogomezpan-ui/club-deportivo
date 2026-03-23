package com.clubdeportivo;

import java.sql.*;

public class ActividadesDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/clubdb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "TU_PASSWORD"; // Cambia por tu contraseña

    // Insertar actividad
    public void insertarActividad(String nombre, String fecha, String lugar) {

        String sql = "INSERT INTO actividades (nombre, fecha, lugar) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nombre);

            // Convertir String a Timestamp (formato: YYYY-MM-DD HH:MM:SS)
            stmt.setTimestamp(2, Timestamp.valueOf(fecha));

            stmt.setString(3, lugar);

            int filas = stmt.executeUpdate();

            if (filas > 0) {

                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    System.out.println("Actividad insertada correctamente. ID: " + idGenerado);
                }

            }

        } catch (SQLException e) {

            System.out.println("Error al insertar actividad");
            e.printStackTrace();

        }

    }

    // Listar actividades
    public void listarActividades() {

        String sql = "SELECT * FROM actividades";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hayRegistros = false;

            while (rs.next()) {

                hayRegistros = true;

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Timestamp fecha = rs.getTimestamp("fecha");
                String lugar = rs.getString("lugar");

                System.out.println(id + " - " + nombre + " - " + fecha + " - " + lugar);

            }

            if (!hayRegistros) {
                System.out.println("No hay actividades registradas.");
            }

        } catch (SQLException e) {

            System.out.println("Error al listar actividades");
            e.printStackTrace();

        }

    }

}