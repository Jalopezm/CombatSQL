package domain;

public class Personaje {
    private int idPersonaje;
    private String nombre;
    private String clase;
    private int salud;
    private int saludMaxima;
    private int ataque;
    private int precision;
    private int evasion;
    private int nivel;
    private int experiencia;
    private int monedas;

    public Personaje(int idPersonaje, String nombre, String clase, int salud, int saludMaxima, int ataque, int precision, int evasion, int nivel, int experiencia, int monedas) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.clase = clase;
        this.salud = salud;
        this.saludMaxima = saludMaxima;
        this.ataque = ataque;
        this.precision = precision;
        this.evasion = evasion;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.monedas = monedas;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getSaludMaxima() {
        return saludMaxima;
    }

    public void setSaludMaxima(int saludMaxima) {
        this.saludMaxima = saludMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
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
