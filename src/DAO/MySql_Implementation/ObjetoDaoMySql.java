package DAO.MySql_Implementation;

import Conection.ClaseSingleton;
import DAO.CalidadDao;
import DAO.ObjetoDao;
import domain.Calidad;
import domain.Objeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjetoDaoMySql implements ObjetoDao {
    private Connection con;

    public ObjetoDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public Objeto getAtributes(int objetoID) {
        try {
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM OBJETO WHERE objetoID = ?");
            getAllStmnt.setInt(1, objetoID);

            ResultSet result = getAllStmnt.executeQuery();


            return new Objeto(
                    result.getInt("objetoID"),
                    result.getString("nombreObjeto"),
                    new Calidad(result.getString("tipo")),
                    result.getInt("modSalud"),
                    result.getInt("modAtaque"),
                    result.getInt("modHabilidad"),
                    result.getInt("modEvasion"));


        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
}
