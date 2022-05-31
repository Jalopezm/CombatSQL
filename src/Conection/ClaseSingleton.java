package Conection;

import java.sql.Connection;

public class ClaseSingleton {

    private static ClaseSingleton instance;
    private static Connection con;
    // Constructor has private access so no one except this class
    // can create a new SingletonClass object
    private ClaseSingleton() {
        Connection con = DBUtil.createConnectionFromProperties("res/connection.properties");
        this.con  = con;
    }


    public static ClaseSingleton getInstance() {
        if (instance == null) {
            instance = new ClaseSingleton();
        }
        return instance;
    }
    public static Connection getConnection(){
        return con;
    }
}
