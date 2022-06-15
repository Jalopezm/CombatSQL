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
import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

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
        Menu menuTienda = new MenuTienda("");
        if (tienda.size() == 0){
            Input.readString("No hay articulos a la venta, vuelve más tarde. Pulsa intro para continuar.");
        }
        else {
            for (int i = 0; i < tienda.size() ; i++) {
                final int idx = i;
                int  indiceObjeto = tienda.get(idx).getObjetoID();
                System.out.println(FichaObjeto.getValoresFicha(indiceObjeto).toString());
            }

            String indice = Input.readString("Introduce un objeto. Pulsa intro sin introducir nada para salir.");
            if (Objects.equals(indice, "")){
                menuTienda.start();
            }

            while (Integer.parseInt(indice) > tienda.size()) {
                indice = Input.readString("Valor no valido, introduce otro.");
            }
            Tienda seleccionado = tienda.get(Integer.parseInt(indice));

            if(tiendaDao.buyObjeto(seleccionado)){
                Input.readString("Se ha añadido el objeto a tu inventario. Pulsa intro para continuar.");
            }
        }
        menuTienda.start();

    }
}