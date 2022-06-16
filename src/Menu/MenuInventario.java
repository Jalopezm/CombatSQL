package Menu;

import Conection.ClaseSingleton;
import DAO.InventarioDao;
import DAO.MySql_Implementation.InventarioDaoMySql;
import domain.Inventario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class MenuInventario extends Menu {
        public MenuInventario(String title) {
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
            Menu menuTienda = new MenuTienda("\n" +
                    "__________________ _______  _        ______   _______ \n" +
                    "\\__   __/\\__   __/(  ____ \\( (    /|(  __  \\ (  ___  )\n" +
                    "   ) (      ) (   | (    \\/|  \\  ( || (  \\  )| (   ) |\n" +
                    "   | |      | |   | (__    |   \\ | || |   ) || (___) |\n" +
                    "   | |      | |   |  __)   | (\\ \\) || |   | ||  ___  |\n" +
                    "   | |      | |   | (      | | \\   || |   ) || (   ) |\n" +
                    "   | |   ___) (___| (____/\\| )  \\  || (__/  )| )   ( |\n" +
                    "   )_(   \\_______/(_______/|/    )_)(______/ |/     \\|\n" +
                    "                                                      ");

            if (inventario.size() == 0) Input.readString("Tu inventario esta vacio. Pulsa intro para continuar");

            else {
                for (int i = 0; i < inventario.size() ; i++) {
                    final int idx = i;
                    int  indiceObjeto = inventario.get(idx).getObjetoID();
                    System.out.println(FichaObjeto.getValoresFicha(indiceObjeto));
                }
                Input.readString("Pulsa intro para volver al menu anterior.");
            }
            menuTienda.start();
        }
    }


