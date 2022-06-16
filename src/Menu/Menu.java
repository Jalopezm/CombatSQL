package Menu;

import java.sql.SQLException;
import java.util.*;

public abstract class Menu {

    private static String CLEAR;
    protected boolean running;
    protected String title;

    protected Map<String, MenuAction> actions;

    public Menu(String title) {
        this.title = title;
        running = true;
        actions = new HashMap<String, MenuAction>();

        for (int i = 0; i < 30; i++)  CLEAR += '\n';
        CLEAR += "\"\\033[H\\033[2J\"";
    }

    public void addOption(String choiceInput, MenuAction callback){
        this.actions.put(choiceInput, callback);
    }

    private void printOptions() {
        var keySet = actions.keySet();
        var keys = new ArrayList<>(keySet);
        Collections.sort(keys);

        for (var key: keys) {
                System.out.println(key + actions.get(key).getOptionName());

        }
    }

    protected void clearActions() {
        this.actions.clear();
    }


    /**
     * Override this method adding the corresponding menu options
     */
    protected abstract void initActions() throws SQLException;

    /**
     * This method will be called before printing the menu options
     */
    protected abstract void onPreOptions() throws SQLException;

    public void start() throws SQLException {
        initActions();

        while (running) {
            clear();
            printTitle();
            onPreOptions();
            printOptions();

            String input = Input.readString("==> Opción").toUpperCase(Locale.ROOT);
            if (actions.containsKey(input)) {
                actions.get(input).execute();
            } else {
                System.out.println("Opción inválida");
                sleep(500);
            }
        }
    }



    public void sleep(float ms) {
        try {
            Thread.sleep((long) ms);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    private void clear() {
        System.out.print(CLEAR);
        System.out.flush();
    }

    private void printTitle() {
        System.out.println("*****************************************");
        System.out.println("\u001B[32m" + title + "\u001B[0m");
        System.out.println("*****************************************");
    }
}
