package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.PersonajeDao;
import domain.Personaje;
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
                public void execute() {
                    ClaseSingleton.setPersonaje(personajes.get(idx));
                    MenuJuego menuJuego = new MenuJuego("Elige una opción");
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
            public void execute() {
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
