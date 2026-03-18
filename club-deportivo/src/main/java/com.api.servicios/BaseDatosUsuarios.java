package com.api.servicios;

import java.util.HashMap;
import java.util.Map;

// Clase para simular una base de datos en memoria
public class BaseDatosUsuarios {
    // Usamos un Map para guardar "usuario" como llave y "contraseña" como valor
    private static Map<String, String> usuariosRegistrados = new HashMap<>();

    // Método para guardar un nuevo usuario (Registro)
    public static boolean registrarUsuario(String usuario, String contrasena) {
        // Validamos que el usuario no exista ya
        if (usuariosRegistrados.containsKey(usuario)) {
            return false; // El usuario ya existe
        }
        usuariosRegistrados.put(usuario, contrasena);
        return true; // Registro exitoso
    }

    // Método para validar las credenciales (Login)
    public static boolean validarUsuario(String usuario, String contrasena) {
        // Verificamos si el usuario existe y si la contraseña coincide
        if (usuariosRegistrados.containsKey(usuario)) {
            return usuariosRegistrados.get(usuario).equals(contrasena);
        }
        return false; // Usuario no existe o contraseña incorrecta
    }
}