package domain;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.UsuarioDaoMySql;

import java.util.Locale;

public class Personaje {
    private int personajeID;
    private String nombre;
    private Clase clase;
    private int saludActual;
    private int nivel;
    private int experiencia;
    private int monedas;
    private Usuario usuario;

    public Personaje(Usuario usuario, String nombre, Clase clase, int salud, int nivel, int experiencia, int monedas) {
        this.nombre = nombre;
        this.clase = clase;
        this.saludActual = salud;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.monedas = monedas;
        this.usuario = usuario;
    }
    public Personaje(int personajeID, Usuario usuario, String nombre, Clase clase, int salud, int nivel, int experiencia, int monedas) {
        this.personajeID = personajeID;
        this.nombre = nombre;
        this.clase = clase;
        this.saludActual = salud;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.monedas = monedas;
        this.usuario = usuario;
    }

    public int getPersonajeID() {
        return personajeID;
    }

    public void setPersonajeID(int personajeID) {
        this.personajeID = personajeID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getSaludActual() {
        return saludActual;
    }

    public void setSaludActual(int saludActual) {
        this.saludActual = saludActual;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }
}
