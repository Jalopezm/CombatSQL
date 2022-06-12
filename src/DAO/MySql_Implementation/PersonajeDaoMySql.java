package DAO.MySql_Implementation;

import Conection.ClaseSingleton;
import DAO.PersonajeDao;
import domain.*;

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
                        result.getInt("personajeID"),
                        new UsuarioDaoMySql(ClaseSingleton.getConnection()).getUsuario(ClaseSingleton.getNombreUsuario()),
                        result.getString("nombrePersonaje"),
                        new ClaseDaoMySql(con).getClase(result.getString("nombreClase")),
                        result.getInt("saludActual"),
                        result.getInt("nivel"),
                        result.getInt("experiencia"),
                        result.getInt("monedas"))
                );
            }
            return personajes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean findIfPersonajeExists(String nombre) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM PERSONAJE WHERE nombrePersonaje = ?");

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

    @Override
    public int getIdPersonaje(Personaje personaje) {
        try {
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT personajeID FROM PERSONAJE WHERE nombrePersonaje = ?");
            getAllStmnt.setString(1, personaje.getNombre());

            ResultSet result = getAllStmnt.executeQuery();
            if (result.next()) {
                return result.getInt("personajeID");
            }

        } catch (SQLException e) {
            System.err.println(e);

        }
        return 0;
    }

    @Override
    public boolean addGold(Tienda tienda) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("UPDATE PERSONAJE SET MONEDAS = ? where personajeID = ?");

            PersonajeDao personajeDao = new PersonajeDaoMySql(con);

            int monedas = personajeDao.getGold(tienda.getPersonajeID());
            int addmonedas = tienda.getPrecio();
            int total = monedas + addmonedas;


            //Sustitución de los ?
            getAllStmnt.setInt(1, total);
            getAllStmnt.setInt(2, tienda.getPersonajeID());


            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public boolean takeGold(Tienda tienda, Personaje personaje) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("UPDATE PERSONAJE SET MONEDAS = ? where personajeID = ?");

            PersonajeDao personajeDao = new PersonajeDaoMySql(con);

            int monedas = personajeDao.getGold(tienda.getPersonajeID());
            int takemonedas = tienda.getPrecio();

            int total = 0;

            if (takemonedas > monedas) {
                return false;
            } else {
                total = monedas - takemonedas;
            }


            //Sustitución de los ?
            getAllStmnt.setInt(1, total);
            getAllStmnt.setInt(2, personaje.getPersonajeID());


            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public int getGold(int personajeID) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT monedas FROM PERSONAJE where personajeID = ?");

            //Sustitución de los ?
            getAllStmnt.setInt(1,personajeID);


            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return result.getInt("monedas");
            }


        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }
}
