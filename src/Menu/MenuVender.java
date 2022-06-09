package Menu;

import Conection.ClaseSingleton;
import DAO.InventarioDao;
import DAO.MySql_Implementation.InventarioDaoMySql;
import DAO.MySql_Implementation.TiendaDaoMySql;
import DAO.TiendaDao;
import domain.Inventario;
import domain.Tienda;

import java.sql.Connection;
import java.util.List;

public class MenuVender extends Menu {
    public MenuVender(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() {
        Connection con = ClaseSingleton.getConnection();
        InventarioDao inventarioDao = new InventarioDaoMySql(con);
        int personajeID = ClaseSingleton.getPersonaje().getPersonajeID();
        List<Inventario> inventario = inventarioDao.getPersonajeInventario(personajeID);
        for (Inventario objetoInventario : inventario) {
            System.out.println(objetoInventario);
        }
//       todo while

        int indice = Integer.parseInt(Input.readString("Introduce un objeto"));

        Inventario seleccionado = inventario.get(indice);


        int precio = Integer.parseInt(Input.readString("¿A que precio?"));

        TiendaDao tiendaDao = new TiendaDaoMySql(con);
        tiendaDao.addObjeto(new Tienda(seleccionado.getObjetoID(), personajeID, precio));

        inventarioDao.deleteObjeto(seleccionado);

    }
}
