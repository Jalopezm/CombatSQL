package DAO.MySql_Implementation;

import DAO.PersonajeDao;
import domain.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonajeDaoMySql implements PersonajeDao {

    private Connection con;

    public PersonajeDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public List<Personaje> showPersonajes(String nombreUsuario) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM personaje WHERE nombreUsuario = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombreUsuario);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) return (List<Personaje>) result;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public boolean findIfPersonajeExists(String nombre) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM personaje WHERE nombre = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombre);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public boolean insertNuevoPersonaje(Personaje personaje) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("INSERT INTO `personaje` " +
                    "(`nombre`, `nivel`, `experiencia`, `monedas`, `clase`, `saludActual`) VALUES (?, ?, ?, ?, ?, ?);");

            //Sustitución de los ?
            getAllStmnt.setString(1, personaje.getNombre());
            getAllStmnt.setInt(2, 1);
            getAllStmnt.setInt(3, 0);
            getAllStmnt.setInt(4, 0);
            getAllStmnt.setString(5, personaje.getClase().getNombre());
            getAllStmnt.setInt(6, personaje.getClase().getVidaMaxima());

            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }
}
