package domain;

public class Enemigo {

    int enemigoID;
    String nombreEnemigo;
    int ataque;
    int habilidad;
    int salud;
    int evasion;

    public Enemigo(int enemigoID, String nombreEnemigo, int ataque, int habilidad, int salud, int evasion) {
        this.enemigoID = enemigoID;
        this.nombreEnemigo = nombreEnemigo;
        this.ataque = ataque;
        this.habilidad = habilidad;
        this.salud = salud;
        this.evasion = evasion;
    }

    public int getEnemigoID() {
        return enemigoID;
    }

    public void setEnemigoID(int enemigoID) {
        this.enemigoID = enemigoID;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }
}
