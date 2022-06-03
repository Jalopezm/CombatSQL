package DAO.MySql_Implementation;

import Conection.ClaseSingleton;
import DAO.PersonajeDao;
import domain.Clase;
import domain.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM PERSONAJE WHERE nombreUsuario = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombreUsuario);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();
            List<Personaje> personajes = new ArrayList<>();

            while (result.next()) {
                personajes.add(new Personaje(
                        result.getString("nombrePersonaje"),
                        new Clase(result.getString("nombreClase")),
                        result.getInt("saludActual"),
                        result.getInt("nivel"),
                        result.getInt("experiencia"),
                        result.getInt("monedas"))
                );
            }
            return personajes;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public boolean findIfPersonajeExists(String nombre) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM PERSONAJE WHERE nombre = ?");

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
            PreparedStatement getAllStmnt = con.prepareStatement("INSERT INTO `PERSONAJE` " +
                    "(`nombrePersonaje`, `nivel`, `experiencia`, `monedas`, `nombreClase`, `saludActual`, `nombreUsuario`) VALUES (?, ?, ?, ?, ?, ?, ?);");

            //Sustitución de los ?
            getAllStmnt.setString(1, personaje.getNombre());
            getAllStmnt.setInt(2, 1);
            getAllStmnt.setInt(3, 0);
            getAllStmnt.setInt(4, 0);
            getAllStmnt.setString(5, personaje.getClase().getNombre());
            getAllStmnt.setInt(6, personaje.getSaludActual());
            getAllStmnt.setString(7, ClaseSingleton.getNombreUsuario());

            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }
}
