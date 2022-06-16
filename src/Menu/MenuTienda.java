package Menu;

import java.sql.SQLException;

public class MenuTienda extends Menu{
    public MenuTienda(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() throws SQLException {
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
            public void execute() throws SQLException {
                Menu menuVender = new MenuVender("Vender");
                menuVender.start();
            }

            @Override
            public String getOptionName() {
                return ") Vender";
            }
        });
        addOption("S", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuJuego = new MenuJuego("Atras");
                menuJuego.start();
            }

            @Override
            public String getOptionName() {
                return ") Atras";
            }
        });


    }

    @Override
    protected void onPreOptions() {

    }
}
