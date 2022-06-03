package domain;

public class Objeto {
    int objetoID;
    String nombreObjeto;
    Calidad tipo;
    int modSalud;
    int modAtaque;
    int modHabilidad;
    int modEvasion;

    public Objeto(String nombreObjeto, Calidad tipo, int modSalud, int modAtaque, int modHabilidad, int modEvasion) {
//        this.objetoID = objetoID;
        this.nombreObjeto = nombreObjeto;
        this.tipo = tipo;
        this.modSalud = modSalud;
        this.modAtaque = modAtaque;
        this.modHabilidad = modHabilidad;
        this.modEvasion = modEvasion;
    }

    public int getObjetoID() {
        return objetoID;
    }

    public void setObjetoID(int objetoID) {
        this.objetoID = objetoID;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public Calidad getTipo() {
        return tipo;
    }

    public void setTipo(Calidad tipo) {
        this.tipo = tipo;
    }

    public int getModSalud() {
        return modSalud;
    }

    public void setModSalud(int modSalud) {
        this.modSalud = modSalud;
    }

    public int getModAtaque() {
        return modAtaque;
    }

    public void setModAtaque(int modAtaque) {
        this.modAtaque = modAtaque;
    }

    public int getModHabilidad() {
        return modHabilidad;
    }

    public void setModHabilidad(int modHabilidad) {
        this.modHabilidad = modHabilidad;
    }

    public int getModEvasion() {
        return modEvasion;
    }

    public void setModEvasion(int modEvasion) {
        this.modEvasion = modEvasion;
    }
}
