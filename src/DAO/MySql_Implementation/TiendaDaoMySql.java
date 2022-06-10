package DAO.MySql_Implementation;

import Conection.ClaseSingleton;
import DAO.InventarioDao;
import DAO.TiendaDao;
import domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaDaoMySql implements TiendaDao {
    private Connection con;

    public TiendaDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public List<Tienda> showTienda() {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM TIENDA");

            //Sustitución de los ?

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();
            List<Tienda> tienda = new ArrayList<>();
            while (result.next()) {
                tienda.add(new Tienda(
                        result.getInt("tiendaID"),
                        result.getInt("objetoID"),
                        result.getInt("personajeID"),
                        result.getInt("precio"))
                );
            }
            return tienda;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public boolean addObjeto(Tienda tienda) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("INSERT INTO `TIENDA` " +
                    "(`objetoID`, `personajeID`, `precio`) VALUES (?, ?, ?);");

            //Sustitución de los ?
            getAllStmnt.setInt(1, tienda.getObjetoID());
            getAllStmnt.setInt(2, tienda.getPersonajeID());
            getAllStmnt.setInt(3, tienda.getPrecio());

            //Ejecución y verificación del funcionamiento de la query
            int numberOfInserts = getAllStmnt.executeUpdate();

            if (numberOfInserts == 1) return true;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public int getObjeto(int tiendaID) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT objetoID FROM TIENDA where tiendaID = ?");

            //Sustitución de los ?

            getAllStmnt.setInt(1, tiendaID);
            ResultSet result = getAllStmnt.executeQuery();

            //Ejecución y guardado de la info de la query

            if (result.next()) return result.getInt("objetoID");

        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    @Override
    public boolean deleteObjeto(int objetoID) {
        try{
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("DELETE FROM TIENDA where objetoID = ?");

            getAllStmnt.setInt(1, objetoID);

            //Ejecución y guardado de la info de la query
            int delete = getAllStmnt.executeUpdate();

            if (delete == 1) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean sellObjeto(Tienda tienda, Inventario inventario) throws SQLException {
        try {
            Connection con = ClaseSingleton.getConnection();
            con.setAutoCommit(false);
            TiendaDao tiendaDao = new TiendaDaoMySql(con);
            InventarioDao inventarioDao = new InventarioDaoMySql(con);
            tiendaDao.addObjeto(tienda);
            inventarioDao.deleteObjeto(inventario);
            con.commit();
            return true;
        }catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
