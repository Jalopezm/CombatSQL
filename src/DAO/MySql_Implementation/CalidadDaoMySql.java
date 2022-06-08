package DAO.MySql_Implementation;

import DAO.CalidadDao;
import domain.Calidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalidadDaoMySql implements CalidadDao {
    private Connection con;

    public CalidadDaoMySql(Connection con) {
        this.con = con;}


    @Override
    public Calidad getCalidad(String tipo) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM CALIDAD WHERE tipo = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, tipo);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return new Calidad(
                    result.getString("tipo"),
                        result.getFloat("ataque"),
                        result.getFloat("evasion"),
                        result.getFloat("habilidad"),
                        result.getFloat("salud")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
