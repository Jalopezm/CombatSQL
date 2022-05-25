package DAO;

import domain.Usuario;

public interface UsuarioDao {
    boolean insertNuevoUsuario(Usuario usuario);

    Usuario login(String NombreUsuario, String contraseña);

    boolean findByNombreUsuario(String NombreUsuario);

    boolean validateContraseña(String contraseña);

}
