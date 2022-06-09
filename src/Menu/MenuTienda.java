package Menu;

public class MenuTienda extends Menu{
    public MenuTienda(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                Menu menuComprar = new MenuComprar("Comprar");
                menuComprar.start();
            }

            @Override
            public String getOptionName() {
                return ") Comprar";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() {

            }

            @Override
            public String getOptionName() {
                return ") Vender";
            }
        });

    }

    @Override
    protected void onPreOptions() {

    }
}
