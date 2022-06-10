package DAO;

import domain.Inventario;
import domain.Objeto;
import domain.Tienda;

import java.sql.SQLException;
import java.util.List;

public interface TiendaDao {
    List<Tienda> showTienda();
    boolean addObjeto(Tienda tienda);
    int getObjeto(int tiendaID);
    boolean deleteObjeto(int objetoID);
    boolean sellObjeto(Tienda tienda, Inventario inventario) throws SQLException;
}
