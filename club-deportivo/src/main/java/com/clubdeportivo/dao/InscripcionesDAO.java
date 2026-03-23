package com.clubdeportivo;

import java.sql.*;

public class InscripcionesDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/clubdb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "TU_PASSWORD"; // Cambia por tu contraseña

    // Registrar inscripción
    public void inscribirSocio(int socioId, int actividadId) {

        String sql = "INSERT INTO inscripciones (socio_id, actividad_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, socioId);
            stmt.setInt(2, actividadId);

            int filas = stmt.executeUpdate();

            if (filas > 0) {

                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    System.out.println("Inscripción registrada correctamente. ID: " + idGenerado);
                }

            }

        } catch (SQLException e) {

            System.out.println("Error al registrar la inscripción");
            e.printStackTrace();

        }

    }

    // Listar inscripciones
    public void listarInscripciones() {

        String sql = "SELECT i.id, s.nombre, s.apellido, a.nombre AS actividad " +
                     "FROM inscripciones i " +
                     "JOIN socios s ON i.socio_id = s.id " +
                     "JOIN actividades a ON i.actividad_id = a.id";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hayRegistros = false;

            while (rs.next()) {

                hayRegistros = true;

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String actividad = rs.getString("actividad");

                System.out.println(id + " - " + nombre + " " + apellido + " - " + actividad);

            }

            if (!hayRegistros) {
                System.out.println("No hay inscripciones registradas.");
            }

        } catch (SQLException e) {

            System.out.println("Error al listar las inscripciones");
            e.printStackTrace();

        }

    }

}