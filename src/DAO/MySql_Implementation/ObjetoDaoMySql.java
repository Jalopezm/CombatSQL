package DAO.MySql_Implementation;

import Conection.ClaseSingleton;
import DAO.CalidadDao;
import DAO.ObjetoDao;
import domain.Calidad;
import domain.Objeto;
import domain.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDaoMySql implements ObjetoDao {
    private Connection con;

    public ObjetoDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public Objeto getObjetoByID(int objetoID) {
        try {
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM OBJETO WHERE objetoID = ?");
            getAllStmnt.setInt(1, objetoID);

            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return new Objeto(
                        result.getInt("objetoID"),
                        result.getString("nombreObjeto"),
                        new CalidadDaoMySql(con).getCalidad(result.getString("tipo")),
                        result.getInt("ModSalud"),
                        result.getInt("ModAtaque"),
                        result.getInt("ModHabilidad"),
                        result.getInt("ModEvasion"));
            }


        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }

    @Override
    public List<Objeto> getAllObjetos() {
        try {
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM OBJETO");

            ResultSet result = getAllStmnt.executeQuery();

            List<Objeto> objetos = new ArrayList<>();

            while (result.next()) {
                objetos.add(new Objeto(
                        result.getInt("objetoID"),
                        result.getString("nombreObjeto"),
                        new CalidadDaoMySql(con).getCalidad(result.getString("tipo")),
                        result.getInt("modSalud"),
                        result.getInt("modAtaque"),
                        result.getInt("modHabilidad"),
                        result.getInt("modEvasion"))
                );
            }
            return objetos;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
}
