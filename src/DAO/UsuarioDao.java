package DAO;

import domain.Usuario;

public interface UsuarioDao {
    boolean insertNuevoUsuario(Usuario USUARIO);

    boolean login(String NombreUsuario, String contraseña);

    boolean findIfUsuarioExists(String NombreUsuario);

}
