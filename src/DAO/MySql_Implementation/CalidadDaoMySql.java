package DAO.MySql_Implementation;

import DAO.CalidadDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalidadDaoMySql implements CalidadDao {
    private Connection con;

    public CalidadDaoMySql(Connection con) {
        this.con = con;}


    @Override
    public int[] getAtributes(String tipo) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM CALIDAD WHERE tipo = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, tipo);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return new int[]{
                        result.getInt("modAtaque"),
                        result.getInt("modEvasion"),
                        result.getInt("modHabilidad"),
                        result.getInt("modSalud")
                };
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}
