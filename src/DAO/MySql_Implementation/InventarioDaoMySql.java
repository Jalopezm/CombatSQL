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
                        result.getInt("invetarioID"),
                        result.getInt("objetoID"),
                        result.getInt("personajeID"))
                );
            }
            return inventario;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }


    @Override
    public boolean addObjecto(Objeto objeto) {
        return false;
    }

    @Override
    public boolean deleteObjeto(Inventario inventario) {
        return false;
    }

    @Override
    public boolean inventarioContainsObjeto(Objeto objeto) {
        return false;
    }


}
