package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import domain.Personaje;

import java.sql.Connection;
import java.sql.SQLException;

public class MenuJuego extends Menu{
    public MenuJuego(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuTienda = new MenuTienda("tienda");
                menuTienda.start();
            }

            @Override
            public String getOptionName() {
                return ") Tienda";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuCombate = new MenuCombate("Combate");
                menuCombate.start();
            }

            @Override
            public String getOptionName() {
                return ") Combate";
            }
        });
        addOption("S", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuPersonaje = new MenuPersonaje("Atras");
                menuPersonaje.start();
            }

            @Override
            public String getOptionName() {
                return ") Atras";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        Personaje personaje = ClaseSingleton.getPersonaje();
    FichaPersonaje fichaPersonaje = FichaPersonaje.getValoresFicha(personaje);
        System.out.println(fichaPersonaje);
    }
}
