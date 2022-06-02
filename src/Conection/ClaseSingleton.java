package Conection;

import domain.Personaje;

import java.sql.Connection;

public class ClaseSingleton {
    private static String nombreUsuario;
    private static ClaseSingleton instance;
    private static Connection con;
    private static Personaje personaje;

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

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        ClaseSingleton.nombreUsuario = nombreUsuario;
    }

    public static Personaje getPersonaje() {
        return personaje;
    }

    public static void setPersonaje(Personaje personaje) {
        ClaseSingleton.personaje = personaje;
    }
}
