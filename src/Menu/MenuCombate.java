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
                if (ClaseSingleton.getPersonaje().getSaludActual() > 0) {
                    Menu menuMazmorra = new MenuMazmorra("                                                                      \n" +
                            " /'\\_/`\\                                                              \n" +
                            "/\\      \\     __     ____     ___ ___     ___   _ __   _ __    __     \n" +
                            "\\ \\ \\__\\ \\  /'__`\\  /\\_ ,`\\ /' __` __`\\  / __`\\/\\`'__\\/\\`'__\\/'__`\\   \n" +
                            " \\ \\ \\_/\\ \\/\\ \\L\\.\\_\\/_/  /_/\\ \\/\\ \\/\\ \\/\\ \\L\\ \\ \\ \\/ \\ \\ \\//\\ \\L\\.\\_ \n" +
                            "  \\ \\_\\\\ \\_\\ \\__/.\\_\\ /\\____\\ \\_\\ \\_\\ \\_\\ \\____/\\ \\_\\  \\ \\_\\\\ \\__/.\\_\\\n" +
                            "   \\/_/ \\/_/\\/__/\\/_/ \\/____/\\/_/\\/_/\\/_/\\/___/  \\/_/   \\/_/ \\/__/\\/_/\n" +
                            "                                                                      ");
                    menuMazmorra.start();
                } else {
                    System.out.println("No puedes combatir, estás herido de gravedad");
                    System.out.println("Cúrate antes de combatir, melón");
                    Input.readString("pulsa intro para continuar");
                }

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
                        if (personajeDao.heal(personaje, curacion)){
                            System.out.println("Has restaurado " + curacion + " puntos de vida.");
                            ClaseSingleton.getPersonaje().setSaludActual(personajeDao.getHealth(personaje.getPersonajeID()));
                            ClaseSingleton.getPersonaje().setMonedas(personajeDao.getGold(personaje.getPersonajeID()));
                        }
                    } else System.out.println("No tienes suficientes monedas para curarte");
                } else System.out.println("Tu salud ya esta al máximo");
                Input.readString("Pulsa intro para continuar");
                Menu menuCombate = new MenuCombate(FichaPersonaje.getValoresFicha(personaje).toString());
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
                Menu menuPersonaje = new MenuPersonaje("\u001B[31m"+"   _____                                                         \n" +
                        "  /     \\   ____   ____  __ __                                   \n" +
                        " /  \\ /  \\_/ __ \\ /    \\|  |  \\                                  \n" +
                        "/    Y    \\  ___/|   |  \\  |  /                                  \n" +
                        "\\____|__  /\\___  >___|  /____/                                   \n" +
                        "        \\/     \\/     \\/                                         \n" +"\u001B[0m"+"\u001B[35m"+
                        "__________                                             __        \n" +
                        "\\______   \\ ___________  __________   ____ _____      |__| ____  \n" +
                        " |     ___// __ \\_  __ \\/  ___/  _ \\ /    \\\\__  \\     |  |/ __ \\ \n" +
                        " |    |   \\  ___/|  | \\/\\___ (  <_> )   |  \\/ __ \\_   |  \\  ___/ \n" +
                        " |____|    \\___  >__|  /____  >____/|___|  (____  /\\__|  |\\___  >\n" +
                        "               \\/           \\/           \\/     \\/\\______|    \\/ "+"\u001B[0m");
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
