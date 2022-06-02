package Menu;

public class MenuJuego extends Menu{
    public MenuJuego(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                Menu menuTienda = new MenuTienda("tienda");
                menuTienda.start();
            }

            @Override
            public String getOptionName() {
                return ") Tienda";
            }
        });
        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                Menu menuCombate = new MenuCombate("Combate");
                menuCombate.start();
            }

            @Override
            public String getOptionName() {
                return ") Combate";
            }
        });
    }

    @Override
    protected void onPreOptions() {

    }
}
