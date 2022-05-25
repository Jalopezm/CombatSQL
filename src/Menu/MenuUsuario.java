package Menu;

public class MenuUsuario extends Menu{

    public MenuUsuario(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        //Llamar a la funcion addOption(String inputUser,new MenuAction())
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                //Que pasa Cuando se pulsa la Opcion
                //Codigo...
                Menu menuLogin = new MenuRegistro("    ____             _      __           \n" +
                        "   / __ \\___  ____ _(_)____/ /__________ \n" +
                        "  / /_/ / _ \\/ __ `/ / ___/ __/ ___/ __ \\\n" +
                        " / _, _/  __/ /_/ / (__  ) /_/ /  / /_/ /\n" +
                        "/_/ |_|\\___/\\__, /_/____/\\__/_/   \\____/ \n" +
                        "           /____/                        ");
                menuLogin.start();
            }

            @Override
            public String getOptionName() {
                //Nombre de la Accion
                return "Registro";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        //Se ejecuta antes de la Opciones
        //Texto...
    }
}
