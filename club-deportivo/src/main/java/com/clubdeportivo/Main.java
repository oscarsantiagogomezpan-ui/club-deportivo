package com.clubdeportivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando pruebas del módulo de Clubes (CRUD con JDBC)...\n");

        ClubesDAO clubesDAO = new ClubesDAO();

        // 1. Probar Inserción
        // clubesDAO.insertarClub("Club Los Leones", "Calle 123", "Fútbol");
        
        // 2. Probar Consulta
        clubesDAO.listarClubes();

        // 3. Probar Actualización (Asegúrate de poner un ID que exista en tu BD)
        // clubesDAO.actualizarClub(1, "Club Los Leones F.C.", "Avenida 456", "Fútbol y Natación");
        
        // 4. Probar Eliminación (Descomenta para probar con un ID válido)
        // clubesDAO.eliminarClub(2);
    }
}