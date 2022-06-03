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
}
