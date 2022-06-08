package DAO.MySql_Implementation;

import DAO.ClaseDao;

import java.sql.*;

public class ClaseDaoMySql implements ClaseDao {

    private Connection con;

    public ClaseDaoMySql(Connection con) {
        this.con = con;
    }

//    @Override
//    public int[] getAtributes(String nombre) {
//        try {
//            //Preparación de la consulta
//            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM CLASE WHERE nombreClase = ?");
//
//            //Sustitución de los ?
//            getAllStmnt.setString(1, nombre);
//
//            //Ejecución y guardado de la info de la query
//            ResultSet result = getAllStmnt.executeQuery();
//
//            if (result.next()) {
//                return new int[]{
//                        result.getInt("ataque"),
//                        result.getInt("evasion"),
//                        result.getInt("habilidad"),
//                        result.getInt("salud")
//                };
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public int getAtk(String nombreClase) {
        return 0;
    }

    @Override
    public int getEv(String nombreClase) {
        return 0;
    }

    @Override
    public int getHab(String nombreClase) {
        return 0;
    }

    @Override
    public int getVidaMax(String nombreClase) {
        return 0;
    }
}