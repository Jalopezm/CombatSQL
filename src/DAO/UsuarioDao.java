package DAO;

import domain.Usuario;

public interface UsuarioDao {

    Usuario buscarPorNombre(String nombre);

    Usuario validarContraseña(String contraseña);

    boolean crearUsuario(String nombre, String apellido, String nombreUsuario, String email, String contraseña);
}
