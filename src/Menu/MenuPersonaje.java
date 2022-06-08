package Menu;

public class MenuPersonaje extends Menu{

    public MenuPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                Menu crearPersonaje = new MenuCreacionPersonaje("Crear personaje");

                crearPersonaje.start();
            }

            @Override
            public String getOptionName() {
                return ") Crear Personaje";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                Menu seleccionPersonaje = new MenuSeleccionPersonaje("Selecciona personaje");
                seleccionPersonaje.start();
            }

            @Override
            public String getOptionName() {
                return ") Seleccionar Personaje";
            }
        });
        addOption("S", new MenuAction() {
            @Override
            public void execute() {
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
