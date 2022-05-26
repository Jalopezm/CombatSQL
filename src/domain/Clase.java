package domain;


public class Clase {
    String nombre;
    int ataque;
    int evasion;
    int precision;
    int vidaMaxima;

    public Clase(String nombre, int ataque, int evasion, int precision, int vidaMaxima) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.evasion = evasion;
        this.precision = precision;
        this.vidaMaxima = vidaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
}
