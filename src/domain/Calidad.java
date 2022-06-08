package domain;

public class Calidad {
    String tipo;
    float modSalud;
    float modAtaque;
    float modHabilidad;
    float modEvasion;

    public Calidad(String tipo, float modAtaque, float modEvasion, float modHabilidad, float modSalud) {
        this.tipo = tipo;
        this.modAtaque = modAtaque;
        this.modEvasion = modEvasion;
        this.modHabilidad = modHabilidad;
        this.modSalud = modSalud;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getModSalud() {
        return modSalud;
    }

    public void setModSalud(float modSalud) {
        this.modSalud = modSalud;
    }

    public float getModAtaque() {
        return modAtaque;
    }

    public void setModAtaque(float modAtaque) {
        this.modAtaque = modAtaque;
    }

    public float getModHabilidad() {
        return modHabilidad;
    }

    public void setModHabilidad(float modHabilidad) {
        this.modHabilidad = modHabilidad;
    }

    public float getModEvasion() {
        return modEvasion;
    }

    public void setModEvasion(float modEvasion) {
        this.modEvasion = modEvasion;
    }
}
