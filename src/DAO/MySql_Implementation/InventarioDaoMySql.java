package DAO.MySql_Implementation;

import DAO.InventarioDao;
import domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDaoMySql implements InventarioDao {
    private Connection con;

    public InventarioDaoMySql(Connection con) {
        this.con = con;
    }

    @Override
    public List<Inventario> getPersonajeInventario(int personajeID) {
        try {
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("SELECT * FROM INVENTARIO WHERE personajeID = ?");

            //Sustitución de los ?
            getAllStmnt.setInt(1, personajeID);

            //Ejecución y guardado de la info de la query
            ResultSet result = getAllStmnt.executeQuery();
            List<Inventario> inventario = new ArrayList<>();

            while (result.next()) {
                inventario.add(new Inventario(
                        result.getInt("inventarioID"),
                        result.getInt("objetoID"),
                        result.getInt("personajeID"))
                );
            }
            return inventario;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean addObjecto(Objeto objeto) {
        return false;
    }

    // todo Inventario?

    @Override
    public boolean deleteObjeto(Inventario inventario) {
        try{
            //Preparación de la consulta
            PreparedStatement getAllStmnt = con.prepareStatement("DELETE FROM INVENTARIO where inventarioID = ?");

            getAllStmnt.setInt(1, inventario.getInventarioID());

            //Ejecución y guardado de la info de la query
            int delete = getAllStmnt.executeUpdate();

            if (delete == 1) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean inventarioContainsObjeto(Objeto objeto) {
        return false;
    }



}
