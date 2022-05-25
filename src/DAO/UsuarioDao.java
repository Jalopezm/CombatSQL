package DAO;

import domain.Usuario;

public interface UsuarioDao {
    boolean insertNuevoUsuario(Usuario usuario);

    boolean login(String NombreUsuario, String contraseña);

    boolean findByNombreUsuario(String NombreUsuario);

}
