package Menu;

import DAO.MySql_Implementation.UsuarioDaoMySql;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import Conection.ClaseSingleton;
import DAO.UsuarioDao;

public class MenuLogin extends Menu {
    public MenuLogin(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("S", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menu = new MenuUsuario("" +
                        "    ____  _                            _     __    \n" +
                        "   / __ )(_)__  ____ _   _____  ____  (_)___/ /___ \n" +
                        "  / __  / / _ \\/ __ \\ | / / _ \\/ __ \\/ / __  / __ \\\n" +
                        " / /_/ / /  __/ / / / |/ /  __/ / / / / /_/ / /_/ /\n" +
                        "/_____/_/\\___/_/ /_/|___/\\___/_/ /_/_/\\__,_/\\____/ \n" +
                        "                                                   ");
                menu.start();//Inicar Menu
            }

            @Override
            public String getOptionName() {
                return ") Salir";
            }
        });
    }

    @Override
    protected void onPreOptions() throws SQLException {
        Connection con = ClaseSingleton.getConnection();

        String nombreUsuario = Input.readString("Introduce el Nombre del Usuario");
        String contraseña = MenuRegistro.createHash(Input.readString("Introduce una Contraseña"));

        //Hash Contraseña

        UsuarioDao usuarioDao = new UsuarioDaoMySql(ClaseSingleton.getConnection());
        if (!usuarioDao.login(nombreUsuario, contraseña)) {
            System.out.println("Usuario y/o contraseña incorrecto/s");
        } else {
            System.out.println("Acceso autorizado. Bienvenido " + nombreUsuario + "!");
            ClaseSingleton.setNombreUsuario(nombreUsuario);

            Menu menuPersonaje = new MenuPersonaje("\u001B[31m" + "   _____                                                         \n" +
                    "  /     \\   ____   ____  __ __                                   \n" +
                    " /  \\ /  \\_/ __ \\ /    \\|  |  \\                                  \n" +
                    "/    Y    \\  ___/|   |  \\  |  /                                  \n" +
                    "\\____|__  /\\___  >___|  /____/                                   \n" +
                    "        \\/     \\/     \\/                                         \n" + "\u001B[0m" + "\u001B[35m" +
                    "__________                                             __        \n" +
                    "\\______   \\ ___________  __________   ____ _____      |__| ____  \n" +
                    " |     ___// __ \\_  __ \\/  ___/  _ \\ /    \\\\__  \\     |  |/ __ \\ \n" +
                    " |    |   \\  ___/|  | \\/\\___ (  <_> )   |  \\/ __ \\_   |  \\  ___/ \n" +
                    " |____|    \\___  >__|  /____  >____/|___|  (____  /\\__|  |\\___  >\n" +
                    "               \\/           \\/           \\/     \\/\\______|    \\/ " + "\u001B[0m");
            menuPersonaje.start();
        }

    }
}
