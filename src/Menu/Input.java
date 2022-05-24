package Menu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Prompts the user an Integer number
     * @param preMsg
     * @return
     */
    public static Integer readInt(String preMsg) {
        System.out.print(preMsg+": ");
        try {
            String result = br.readLine();
            return Integer.parseInt(result);

        } catch (IOException e) {
        } catch (NumberFormatException nex) {}

        return null;
    }

    /**
     * Prompts until the user's input is an Integer number.
     * @param preMsg
     * @return
     */
    public static Integer readIntUntilSuccess(String preMsg) {

        Integer id = null;
        while (id == null){
            id = Input.readInt("Introduce el id");
            if (id == null) {
                System.out.println("Número incorrecto, vuelve a intentar");
            }
        }
        return id;
    }


    public static String readString(String preMsg) {
        System.out.print(preMsg+": ");
        String result = null;
        try {
            result = br.readLine();
        } catch (IOException e) {
        }

        return result;
    }

}