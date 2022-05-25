import Menu.Menu;
import Menu.MenuUsuario;

public class App {
    public static void main(String[] args) {
        Menu menu = new MenuUsuario("" +
                "    ____  _                            _     __    \n" +
                "   / __ )(_)__  ____ _   _____  ____  (_)___/ /___ \n" +
                "  / __  / / _ \\/ __ \\ | / / _ \\/ __ \\/ / __  / __ \\\n" +
                " / /_/ / /  __/ / / / |/ /  __/ / / / / /_/ / /_/ /\n" +
                "/_____/_/\\___/_/ /_/|___/\\___/_/ /_/_/\\__,_/\\____/ \n" +
                "                                                   ");
        menu.start();//Inicar Menu
    }
}
