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
                Menu menuComprar = new MenuComprar(" _______  _______  _______  _______  _______  _______  _______ \n" +
                        "(  ____ \\(  ___  )(       )(  ____ )(  ____ )(  ___  )(  ____ )\n" +
                        "| (    \\/| (   ) || () () || (    )|| (    )|| (   ) || (    )|\n" +
                        "| |      | |   | || || || || (____)|| (____)|| (___) || (____)|\n" +
                        "| |      | |   | || |(_)| ||  _____)|     __)|  ___  ||     __)\n" +
                        "| |      | |   | || |   | || (      | (\\ (   | (   ) || (\\ (   \n" +
                        "| (____/\\| (___) || )   ( || )      | ) \\ \\__| )   ( || ) \\ \\__\n" +
                        "(_______/(_______)|/     \\||/       |/   \\__/|/     \\||/   \\__/\n" +
                        "                                                               ");
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
                Menu menuVender = new MenuVender("          _______  _        ______   _______  _______ \n" +
                        "|\\     /|(  ____ \\( (    /|(  __  \\ (  ____ \\(  ____ )\n" +
                        "| )   ( || (    \\/|  \\  ( || (  \\  )| (    \\/| (    )|\n" +
                        "| |   | || (__    |   \\ | || |   ) || (__    | (____)|\n" +
                        "( (   ) )|  __)   | (\\ \\) || |   | ||  __)   |     __)\n" +
                        " \\ \\_/ / | (      | | \\   || |   ) || (      | (\\ (   \n" +
                        "  \\   /  | (____/\\| )  \\  || (__/  )| (____/\\| ) \\ \\__\n" +
                        "   \\_/   (_______/|/    )_)(______/ (_______/|/   \\__/\n" +
                        "                                                      ");
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
                Menu menuJuego = new MenuJuego("                                                               \n" +
                        " _____ _ _            _____            _____         _         \n" +
                        "|   __| |_|___ ___   |  |  |___ ___   |     |___ ___|_|___ ___ \n" +
                        "|   __| | | . | -_|  |  |  |   | .'|  |  |  | . |  _| | . |   |\n" +
                        "|_____|_|_|_  |___|  |_____|_|_|__,|  |_____|  _|___|_|___|_|_|\n" +
                        "          |___|                             |_|                ");
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
