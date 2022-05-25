package DAO;

import domain.Usuario;

public interface UsuarioDao {
    boolean insertNewUser(Usuario usuario);

    Usuario login(String NombreUsuario, String contraseña);

    boolean findByNombreUsuario(String NombreUsuario);

    boolean validarContraseña(String contraseña);

}
