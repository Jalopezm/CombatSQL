package DAO.MySql_Implementation;

import Conection.ClaseSingleton;
import DAO.EnemigoDao;
import DAO.PersonajeDao;
import domain.Enemigo;
import domain.Objeto;
import domain.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnemigoDaoMySql implements EnemigoDao {
    private Connection con;

    public EnemigoDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public Enemigo getEnemigoByID(int enemigoID) {
        try {
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM ENEMIGO WHERE enemigoID = ?");
            getAllStmnt.setInt(1, enemigoID);

            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return new Enemigo(
                        result.getInt("enemigoID"),
                        result.getString("nombreEnemigo"),
                        result.getInt("ataque"),
                        result.getInt("habilidad"),
                        result.getInt("salud"),
                        result.getInt("evasion"));
            }


        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }

    @Override
    public int getHealth(int enemigoID) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT salud FROM ENEMIGO where enemigoID = ?");

            //Sustitución de los ?
            getAllStmnt.setInt(1,enemigoID);


            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return result.getInt("salud");
            }


        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    @Override
    public boolean takeHealth(int enemigoID, int restarSalud) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("UPDATE ENEMIGO SET salud = ? where enemigoID = ?");

            EnemigoDao enemigoDao = new EnemigoDaoMySql(con);

            int salud = enemigoDao.getHealth(enemigoID);
            int total = salud - restarSalud;


            //Sustitución de los ?
            getAllStmnt.setInt(1, total);
            getAllStmnt.setInt(2, enemigoID);


            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public void dropExperience() {
        Connection con = ClaseSingleton.getConnection();
        Personaje personaje = ClaseSingleton.getPersonaje();

        PersonajeDaoMySql pj = new PersonajeDaoMySql(con);

        pj.addLevel(personaje);

    }

    @Override
    public void dropGold(int monedas) {
        Connection con = ClaseSingleton.getConnection();
        Personaje personaje = ClaseSingleton.getPersonaje();

        PersonajeDaoMySql pj = new PersonajeDaoMySql(con);

//        pj.addGold(monedas);
    }
}
