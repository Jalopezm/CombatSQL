import Menu.Menu;
import Menu.UserMenu;

public class App {
    public static void main(String[] args) {
        Menu menu = new UserMenu("Hola");
        menu.start();//Inicar Menu
    }
}
