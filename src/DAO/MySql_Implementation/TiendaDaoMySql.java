package DAO.MySql_Implementation;

import DAO.TiendaDao;
import domain.Clase;
import domain.Objeto;
import domain.Personaje;
import domain.Tienda;

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
}
