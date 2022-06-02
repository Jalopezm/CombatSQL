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
                Menu crearPersonaje = new MenuSeleccionPersonaje("Crear personaje");
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
            }

            @Override
            public String getOptionName() {
                return ") Seleccionar Personaje";
            }
        });

    }

    @Override
    protected void onPreOptions() {

    }
}
