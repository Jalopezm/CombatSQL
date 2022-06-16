package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import domain.Personaje;
import domain.Tienda;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.SQLException;

public class MenuCombate extends Menu {
    public MenuCombate(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuMazmorra = new MenuMazmorra("Mazmorra");
                menuMazmorra.start();
            }

            @Override
            public String getOptionName() {
                return ") Combate";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Connection con = ClaseSingleton.getConnection();
                PersonajeDaoMySql personajeDao = new PersonajeDaoMySql(con);
                Personaje personaje = ClaseSingleton.getPersonaje();
                Tienda pocion = new Tienda(0, 0, 50);
                if (personaje.getSaludActual() < personajeDao.getVidaMaxima(personaje)) {
                    int curacion = (int) (personajeDao.getVidaMaxima(personaje) * 0.2);
                    if (personajeDao.takeGold(pocion, personaje)) {
                        personajeDao.heal(personaje, curacion);
                        System.out.println("Has restaurado " + curacion + " puntos de vida.");
                    } else System.out.println("No tienes suficientes monedas para curarte");
                } else System.out.println("Tu salud ya esta al máximo");
                Input.readString("Pulsa intro para continuar");
                Menu menuCombate = new MenuCombate("Atras");
                menuCombate.start();
            }

            @Override
            public String getOptionName() {
                return ") Curar (restaura un 20% de tu vida máxima por 50 monedas de oro)";
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

    }
}
