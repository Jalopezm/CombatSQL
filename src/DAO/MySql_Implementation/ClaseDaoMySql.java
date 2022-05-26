package DAO.MySql_Implementation;

import DAO.ClaseDao;

import java.sql.*;

public class ClaseDaoMySql implements ClaseDao {

    private Connection con;

    public ClaseDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public int[] getAtributes(String nombre) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM CLASE WHERE nombre = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombre);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();


            if (result.next()) {
                return new int[]{
                        result.getInt("vidaMaxima"),
                        result.getInt("ataque"),
                        result.getInt("precision"),
                        result.getInt("evasion"),
                };
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}
