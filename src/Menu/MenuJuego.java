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
                Menu menuCombate = new MenuCombate(" _______  _______  _______  ______   _______ __________________ _______ \n" +
                        "(  ____ \\(  ___  )(       )(  ___ \\ (  ___  )\\__   __/\\__   __/(  ____ )\n" +
                        "| (    \\/| (   ) || () () || (   ) )| (   ) |   ) (      ) (   | (    )|\n" +
                        "| |      | |   | || || || || (__/ / | (___) |   | |      | |   | (____)|\n" +
                        "| |      | |   | || |(_)| ||  __ (  |  ___  |   | |      | |   |     __)\n" +
                        "| |      | |   | || |   | || (  \\ \\ | (   ) |   | |      | |   | (\\ (   \n" +
                        "| (____/\\| (___) || )   ( || )___) )| )   ( |   | |   ___) (___| ) \\ \\__\n" +
                        "(_______/(_______)|/     \\||/ \\___/ |/     \\|   )_(   \\_______/|/   \\__/\n" +
                        "                                                                        ");
                menuCombate.start();
            }

            @Override
            public String getOptionName() {
                return ") Combate";
            }
        });
        addOption("3", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuInventario = new MenuInventario(" _____                     _             _       \n" +
                        "|_   _|                   | |           (_)      \n" +
                        "  | | _ ____   _____ _ __ | |_ __ _ _ __ _  ___  \n" +
                        "  | || '_ \\ \\ / / _ \\ '_ \\| __/ _` | '__| |/ _ \\ \n" +
                        " _| || | | \\ V /  __/ | | | || (_| | |  | | (_) |\n" +
                        " \\___/_| |_|\\_/ \\___|_| |_|\\__\\__,_|_|  |_|\\___/ ");
                menuInventario.start();
            }

            @Override
            public String getOptionName() {
                return ") Inventario";
            }
        });
        addOption("S", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuPersonaje = new MenuPersonaje("\u001B[31m" + "   _____                                                         \n" +
                        "  /     \\   ____   ____  __ __                                   \n" +
                        " /  \\ /  \\_/ __ \\ /    \\|  |  \\                                  \n" +
                        "/    Y    \\  ___/|   |  \\  |  /                                  \n" +
                        "\\____|__  /\\___  >___|  /____/                                   \n" +
                        "        \\/     \\/     \\/                                         \n" + "\u001B[0m" + "\u001B[35m" +
                        "__________                                             __        \n" +
                        "\\______   \\ ___________  __________   ____ _____      |__| ____  \n" +
                        " |     ___// __ \\_  __ \\/  ___/  _ \\ /    \\\\__  \\     |  |/ __ \\ \n" +
                        " |    |   \\  ___/|  | \\/\\___ (  <_> )   |  \\/ __ \\_   |  \\  ___/ \n" +
                        " |____|    \\___  >__|  /____  >____/|___|  (____  /\\__|  |\\___  >\n" +
                        "               \\/           \\/           \\/     \\/\\______|    \\/ " + "\u001B[0m");
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
