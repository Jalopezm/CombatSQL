package Menu;

public class UserMenu extends Menu{

    public UserMenu(String title) {
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

            }

            @Override
            public String getOptionName() {
                //Nombre de la Accion
                return "Login";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        //Se ejecuta antes de la Opciones
        //Texto...
        System.out.println("hola");
    }
}
