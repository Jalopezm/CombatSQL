package DAO.MySql_Implementation;

import DAO.ClaseDao;
import domain.Clase;

import java.sql.*;

public class ClaseDaoMySql implements ClaseDao {

    private Connection con;

    public ClaseDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public Clase getClase(String nombreClase) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM CLASE WHERE nombreClase = ?");

            //Sustitución de los ?
            getAllStmnt.setString(1, nombreClase);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();

            if (result.next()) {
                return new Clase(
                        result.getString("nombreClase"),
                        result.getInt("ataque"),
                        result.getInt("evasion"),
                        result.getInt("habilidad"),
                        result.getInt("salud"));
            }
        }
     catch(SQLException e){
        e.printStackTrace();
    }
        return null;
}
}