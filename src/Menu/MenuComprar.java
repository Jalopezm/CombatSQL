package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.MySql_Implementation.TiendaDaoMySql;
import DAO.PersonajeDao;
import DAO.TiendaDao;
import domain.Objeto;
import domain.Personaje;
import domain.Tienda;

import java.util.List;

public class MenuComprar extends Menu{
    public MenuComprar(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() {
        TiendaDao tiendaDao = new TiendaDaoMySql(ClaseSingleton.getConnection());
        List<Tienda> tienda = tiendaDao.showTienda();
        for (Tienda itemTienda : tienda) {
            System.out.println(itemTienda);
        }
    }
}