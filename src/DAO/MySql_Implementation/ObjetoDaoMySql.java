package DAO.MySql_Implementation;

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
    public Objeto getAtributes(String objetoID) {
        try {
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM OBJETO WHERE objetoID = ?");
            getAllStmnt.setString(1, objetoID);

            ResultSet result = getAllStmnt.executeQuery();


            return new Objeto(
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
