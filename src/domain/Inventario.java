package domain;

public class Inventario {
    int objetoID;
    int personajeID;

    public Inventario(int objetoID, int personajeID) {
        this.objetoID = objetoID;
        this.personajeID = personajeID;
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
}

