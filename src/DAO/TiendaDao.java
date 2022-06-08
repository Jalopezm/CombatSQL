package DAO;

import domain.Objeto;
import domain.Tienda;

import java.util.List;

public interface TiendaDao {
    List<Tienda> showTienda();
    void addObjeto(Tienda tienda);
    int getObjeto(int tiendaID);
    void deleteObjeto(int objetoID);

}
