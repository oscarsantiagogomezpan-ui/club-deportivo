package com.clubdeportivo;

public class SociosDAO {

    public void insertarSocio(String nombre, String apellido, String email){
        System.out.println("Insertando socio: " + nombre + " " + apellido + " - " + email);
    }

    public void listarSocios(){
        System.out.println("Listando socios...");
    }

    public void actualizarSocio(int id, String nuevoEmail){
        System.out.println("Actualizando socio " + id + " con email " + nuevoEmail);
    }

    public void eliminarSocio(int id){
        System.out.println("Eliminando socio con id " + id);
    }
}