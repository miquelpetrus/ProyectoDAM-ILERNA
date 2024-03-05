package controllers;

import clases.Users;

public class UsuarioSesion {
	
    private static UsuarioSesion instancia = new UsuarioSesion();
    private static int idUsuario;
    private static String nombreUsuario;

    private UsuarioSesion() {
    }

    public static UsuarioSesion getInstancia() {
        return instancia;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        UsuarioSesion.idUsuario = idUsuario;
    }
    
	public static String getNombreUsuario() {
		return nombreUsuario;
	}

	public static void setNombreUsuario(String nombreUsuario) {
		UsuarioSesion.nombreUsuario = nombreUsuario;
	}
}
