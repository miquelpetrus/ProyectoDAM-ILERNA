package controllers;

import clases.Users;

public class UsuarioSesion {
	
    private static String nombreUsuario;
    // Puedes añadir más atributos según sea necesario

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        UsuarioSesion.nombreUsuario = nombreUsuario;
    }
    
    // Guardo el id del usuario que ha iniciado sesión
    public static void setIdUsuario(String idUsuario) {
    	UsuarioSesion.nombreUsuario = idUsuario;
    }

}
