package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.PersonajeDao;
import domain.Personaje;

import java.sql.SQLException;
import java.util.List;

public class MenuSeleccionPersonaje extends Menu{
    public MenuSeleccionPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        PersonajeDao personajeDao = new PersonajeDaoMySql(ClaseSingleton.getConnection());
        List<Personaje> personajes = personajeDao.showPersonajes(ClaseSingleton.getNombreUsuario());
        for (int i = 0; i < personajes.size() ; i++) {
            final int idx = i;
            addOption(String.valueOf(i), new MenuAction() {
                @Override
                public void execute() throws SQLException {
                    ClaseSingleton.setPersonaje(personajes.get(idx));
                    MenuJuego menuJuego = new MenuJuego("                                                               \n" +
                            " _____ _ _            _____            _____         _         \n" +
                            "|   __| |_|___ ___   |  |  |___ ___   |     |___ ___|_|___ ___ \n" +
                            "|   __| | | . | -_|  |  |  |   | .'|  |  |  | . |  _| | . |   |\n" +
                            "|_____|_|_|_  |___|  |_____|_|_|__,|  |_____|  _|___|_|___|_|_|\n" +
                            "          |___|                             |_|                ");
                    menuJuego.start();
                }

                @Override
                public String getOptionName() {
                    return FichaPersonaje.getValoresFicha(personajes.get(idx)).toString();
                }
            });
        }

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
                return ") Salir";
            }
        });
    }

    @Override
    protected void onPreOptions() {
    }
}
