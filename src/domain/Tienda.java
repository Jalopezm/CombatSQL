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

    public int getTiendaID() {
        return tiendaID;
    }

    public void setTiendaID(int tiendaID) {
        this.tiendaID = tiendaID;
    }

    public int getObjetoID() {
        return objetoID;
    }

    public void setObjetoID(int objetoID) {
        this.objetoID = objetoID;
    }

    public int getPersonajeID() {
        return personajeID;
    }

    public void setPersonajeID(int personajeID) {
        this.personajeID = personajeID;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
