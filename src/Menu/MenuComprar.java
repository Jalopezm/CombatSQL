package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.MySql_Implementation.TiendaDaoMySql;
import DAO.PersonajeDao;
import DAO.TiendaDao;
import domain.Inventario;
import domain.Objeto;
import domain.Personaje;
import domain.Tienda;

import java.sql.SQLException;
import java.util.List;

public class MenuComprar extends Menu{
    public MenuComprar(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() throws SQLException {
        TiendaDao tiendaDao = new TiendaDaoMySql(ClaseSingleton.getConnection());
        List<Tienda> tienda = tiendaDao.showTienda();
        if (tienda.size() == 0){
            Input.readString("No hay articulos a la venta, vuelve más tarde. Pulsa intro para continuar.");
        }
        else {
            for (Tienda itemTienda : tienda) {
                System.out.println(itemTienda);
            }

            int indice = Integer.parseInt(Input.readString("Introduce un objeto:"));
            while (indice > tienda.size()) {
                indice = Integer.parseInt(Input.readString("Valor no valido, introduce otro."));
            }
            Tienda seleccionado = tienda.get(indice);

            if(tiendaDao.buyObjeto(seleccionado)){
                Input.readString("Se ha añadido el objeto a tu inventario. Pulsa intro para continuar.");
            }
        }
        Menu menuTienda = new MenuTienda("");
        menuTienda.start();
    }
}