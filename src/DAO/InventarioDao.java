package DAO;

import domain.Inventario;
import domain.Objeto;

import java.util.List;

public interface InventarioDao {
    public List<Inventario> getPersonajeInventario (int personajeID);

    public boolean addObjecto (Objeto objeto);

    public boolean deleteObjeto(Inventario inventario);

    public boolean inventarioContainsObjeto(Objeto objeto);


}
