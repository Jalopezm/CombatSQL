package Menu;

import Conection.ClaseSingleton;
import DAO.InventarioDao;
import DAO.MySql_Implementation.InventarioDaoMySql;
import DAO.MySql_Implementation.TiendaDaoMySql;
import DAO.TiendaDao;
import domain.Inventario;
import domain.Tienda;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class MenuVender extends Menu {
    public MenuVender(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() throws SQLException {
        Connection con = ClaseSingleton.getConnection();
        InventarioDao inventarioDao = new InventarioDaoMySql(con);
        int personajeID = ClaseSingleton.getPersonaje().getPersonajeID();
        List<Inventario> inventario = inventarioDao.getPersonajeInventario(personajeID);
        Menu menuTienda = new MenuTienda("");

        if (inventario.size() == 0) Input.readString("Tu inventario esta vacio. Pulsa intro para continuar");
        else {
            for (int i = 0; i < inventario.size() ; i++) {
                final int idx = i;
                addOption(String.valueOf(i), new MenuAction() {
                    @Override
                    public void execute() throws SQLException {
                    }

                    @Override
                    public String getOptionName() {
                        return FichaObjeto.getValoresFicha(inventario.get(idx).getObjetoID()).toString();

                    }
                });
            }
            String indice = Input.readString("Introduce un objeto");
            if (Objects.equals(indice, "")){
                menuTienda.start();
            }
            while (Integer.parseInt(indice) > inventario.size()) {
                indice = Input.readString("Valor no valido, introduce otro");
            }

            Inventario seleccionado = inventario.get(Integer.parseInt(indice));

            int precio = Integer.parseInt(Input.readString("¿A que precio?"));

            TiendaDao tiendaDao = new TiendaDaoMySql(con);

            if (tiendaDao.sellObjeto(new Tienda(seleccionado.getObjetoID(), personajeID, precio), seleccionado)) {
                Input.readString("Objeto puesto con exito a la venta. Cuando se venda recibirás tu dinero. Pulsa Intro para continuar.");
            }
        }

        menuTienda.start();
    }
}
