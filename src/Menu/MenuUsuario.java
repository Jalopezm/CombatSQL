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
                Menu menuRegistro = new MenuRegistro("    ____             _      __           \n" +
                        "   / __ \\___  ____ _(_)____/ /__________ \n" +
                        "  / /_/ / _ \\/ __ `/ / ___/ __/ ___/ __ \\\n" +
                        " / _, _/  __/ /_/ / (__  ) /_/ /  / /_/ /\n" +
                        "/_/ |_|\\___/\\__, /_/____/\\__/_/   \\____/ \n" +
                        "           /____/                        ");
                menuRegistro.start();
            }

            @Override
            public String getOptionName() {
                //Nombre de la Accion
                return ") Registro";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() {
            Menu menuLogin = new MenuLogin("" +
                    "    __                _     \n" +
                    "   / /   ____  ____ _(_)___ \n" +
                    "  / /   / __ \\/ __ `/ / __ \\\n" +
                    " / /___/ /_/ / /_/ / / / / /\n" +
                    "/_____/\\____/\\__, /_/_/ /_/ \n" +
                    "            /____/          ");
            menuLogin.start();
            }


            @Override
            public String getOptionName() {
                return ") Login";
            }
        });
        addOption("0", new MenuAction() {
            @Override
            public void execute() {
                System.exit(1);
            }

            @Override
            public String getOptionName() {
                return ") Salir";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        //Se ejecuta antes de la Opciones
        //Texto...
    }
}
