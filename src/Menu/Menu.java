package Menu;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu {

    private static String CLEAR;
    private boolean running;
    protected String title;

    private Map<String, MenuAction> actions;

    public Menu(String title) {
        this.title = title;
        running = true;
        actions = new HashMap<String, MenuAction>();

        for (int i = 0; i < 30; i++)  CLEAR += '\n';
        CLEAR += "\"\\033[H\\033[2J\"";

        actions.put("x", new MenuAction() {
            @Override
            public void execute() { running = false; }
            @Override
            public String getOptionName() { return "Atrás"; }

        });
    }

    private void addOption(String choiceInput, MenuAction callback){
        this.actions.put(choiceInput, callback);
    }

    private void printOptions() {
        for (var key: actions.keySet()) {
            System.out.println(key+") " + actions.get(key).getOptionName());
        }
    }

    private void clearActions() {
        this.actions.clear();
    }


    /**
     * Override this method adding the corresponding menu options
     */
    protected abstract void initActions();

    /**
     * This method will be called before printing the menu options
     */
    protected abstract void onPreOptions();

    public void start() {
        initActions();

        while (running) {
            clear();
            printTitle();
            onPreOptions();
            printOptions();

            String input = Input.readString("==> Opción");
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
        System.out.println("** " + title);
        System.out.println("*****************************************");
    }
}
