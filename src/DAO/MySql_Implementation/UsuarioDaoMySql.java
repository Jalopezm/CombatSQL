package DAO.MySql_Implementation;

import DAO.UsuarioDao;
import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDaoMySql implements UsuarioDao {

    private Connection con;

    public UsuarioDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public boolean insertNuevoUsuario(Usuario usuario) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("INSERT INTO `usuario` " +
                    "(`nombreUsuario`, `nombre`, `apellido`, `correo`, `contraseña`) VALUES (?, ?, ?, ?, ?);");

            //Sustitución de los ?
            getAllStmnt.setString(1, usuario.getNombreUsuario());
            getAllStmnt.setString(2, usuario.getNombre());
            getAllStmnt.setString(3, usuario.getApellido());
            getAllStmnt.setString(4, usuario.getEmail());
            getAllStmnt.setString(5, usuario.getPassword());

            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public boolean login(String nombreUsuario, String contraseña) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM usuario WHERE nombreUsuario = ? AND contraseña = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombreUsuario);
            getAllStmnt.setString(2, contraseña);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public boolean findIfUsuarioExists(String nombreUsuario) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM usuario WHERE nombreUsuario = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombreUsuario);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

}
