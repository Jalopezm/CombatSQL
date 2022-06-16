package Menu;

import java.sql.SQLException;

public class MenuPersonaje extends Menu{

    public MenuPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu crearPersonaje = new MenuCreacionPersonaje(" _____                      ______                               _      \n" +
                        "/  __ \\                     | ___ \\                             (_)     \n" +
                        "| /  \\/_ __ ___  __ _ _ __  | |_/ /__ _ __ ___  ___  _ __   __ _ _  ___ \n" +
                        "| |   | '__/ _ \\/ _` | '__| |  __/ _ \\ '__/ __|/ _ \\| '_ \\ / _` | |/ _ \\\n" +
                        "| \\__/\\ | |  __/ (_| | |    | | |  __/ |  \\__ \\ (_) | | | | (_| | |  __/\n" +
                        " \\____/_|  \\___|\\__,_|_|    \\_|  \\___|_|  |___/\\___/|_| |_|\\__,_| |\\___|\n" +
                        "                                                               _/ |     \n" +
                        "                                                              |__/      \n");

                crearPersonaje.start();
            }

            @Override
            public String getOptionName() {
                return ") Crear Personaje";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu seleccionPersonaje = new MenuSeleccionPersonaje(" _____      _               _                   \n" +
                        "/  ___|    | |             (_)                  \n" +
                        "\\ `--.  ___| | ___  ___ ___ _  ___  _ __   __ _ \n" +
                        " `--. \\/ _ \\ |/ _ \\/ __/ __| |/ _ \\| '_ \\ / _` |\n" +
                        "/\\__/ /  __/ |  __/ (_| (__| | (_) | | | | (_| |\n" +
                        "\\____/ \\___|_|\\___|\\___\\___|_|\\___/|_| |_|\\__,_|\n" +
                        "                                                \n" +
                        "                                                \n" +
                        "______                               _      \n" +
                        "| ___ \\                             (_)     \n" +
                        "| |_/ /__ _ __ ___  ___  _ __   __ _ _  ___ \n" +
                        "|  __/ _ \\ '__/ __|/ _ \\| '_ \\ / _` | |/ _ \\\n" +
                        "| | |  __/ |  \\__ \\ (_) | | | | (_| | |  __/\n" +
                        "\\_|  \\___|_|  |___/\\___/|_| |_|\\__,_| |\\___|\n" +
                        "                                   _/ |     \n" +
                        "                                  |__/      \n");
                seleccionPersonaje.start();
            }

            @Override
            public String getOptionName() {
                return ") Seleccionar Personaje";
            }
        });
        addOption("S", new MenuAction() {
            @Override
            public void execute() throws SQLException {
               MenuUsuario menuUsuario = new MenuUsuario("" +
                       "    ____  _                            _     __    \n" +
                       "   / __ )(_)__  ____ _   _____  ____  (_)___/ /___ \n" +
                       "  / __  / / _ \\/ __ \\ | / / _ \\/ __ \\/ / __  / __ \\\n" +
                       " / /_/ / /  __/ / / / |/ /  __/ / / / / /_/ / /_/ /\n" +
                       "/_____/_/\\___/_/ /_/|___/\\___/_/ /_/_/\\__,_/\\____/ \n" +
                       "                                                   ");
               menuUsuario.start();
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
