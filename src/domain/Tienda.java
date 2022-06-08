package domain;

public class Tienda {
    int tiendaID;
    int objetoID;
    int personajeID;
    int precio;

    public Tienda(int tiendaID, int objetoID, int personajeID, int precio) {
        this.tiendaID = tiendaID;
        this.objetoID = objetoID;
        this.personajeID = personajeID;
        this.precio = precio;
    }

    public Tienda(int objetoID, int personajeID, int precio) {
        this.objetoID = objetoID;
        this.personajeID = personajeID;
        this.precio = precio;
    }
}
