package Menu;// Guerrero rojo, mago azul y picaro Verde

// Normal blanco, bendecido amarillo y épico lila

import Conection.ClaseSingleton;

import DAO.InventarioDao;
import DAO.MySql_Implementation.InventarioDaoMySql;
import DAO.MySql_Implementation.ObjetoDaoMySql;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.ObjetoDao;
import DAO.PersonajeDao;
import domain.Inventario;
import domain.Objeto;
import domain.Personaje;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

public class FichaPersonaje {
    int ataque;
    int habilidad;
    int vidaMaxima;
    int evasion;
    String clase;
    Personaje personaje;

    public FichaPersonaje(int ataque, int habilidad, int vidaMaxima, int evasion, String clase, Personaje personaje) {
        this.ataque = ataque;
        this.habilidad = habilidad;
        this.vidaMaxima = vidaMaxima;
        this.evasion = evasion;
        this.clase = clase;
        this.personaje = personaje;
    }

    public static FichaPersonaje getValoresFicha(Personaje personaje) {
        Connection con = ClaseSingleton.getConnection();
        InventarioDao inventarioDao = new InventarioDaoMySql(con);
        PersonajeDao personajeDao = new PersonajeDaoMySql(con);
        ObjetoDao objetoDao = new ObjetoDaoMySql(con);

        int ataque = personaje.getClase().getAtaque();
        int habilidad = personaje.getClase().getHabilidad();
        int vidaActual = personaje.getSaludActual();
        int vidaMaxima = personaje.getClase().getVidaMaxima();
        int evasion = personaje.getClase().getEvasion();
        String clase = personaje.getClase().getNombre();

        int idPersonaje = personajeDao.getIdPersonaje(personaje);

        List<Inventario> inventario = inventarioDao.getPersonajeInventario(idPersonaje);
        if (inventario != null){
            for (int i = 0; i < inventario.size(); i++) {
                int objetoID = inventario.get(i).getObjetoID();
                Objeto objeto = objetoDao.getObjetoByID(objetoID);
                ataque += objeto.getModAtaque() * objeto.getTipo().getModAtaque();
                habilidad += objeto.getModHabilidad() * objeto.getTipo().getModHabilidad();
                vidaMaxima += objeto.getModSalud() * objeto.getTipo().getModSalud();
                evasion += objeto.getModEvasion() * objeto.getTipo().getModEvasion();
            }
        }
        return new FichaPersonaje(ataque, habilidad, vidaMaxima, evasion, clase, personaje);
    }


    @Override
    public String toString() {
        if (Objects.equals(this.clase, "Mago")) {
            return fichaMago();
        } else if (Objects.equals(this.clase, "Picaro")) {
            return fichaPicaro();
        } else if (Objects.equals(this.clase, "Guerrero")) {
            return fichaGuerrero();
        } else {
            return "";
        }
    }

    String fichaPicaro() {
        String ficha = "+------------------------------------+\n";
        ficha += "|" + "               " + this.clase + "               " + "|" + "\n";
        ficha += "|" + this.personaje.getNombre() + "nivel" + this.personaje.getNivel() + "                    " + "|" + "\n";
        ficha += "|" + "Monedas" + this.personaje.getMonedas() + "|" + "\n";
        ficha += "|" + "Estadisticas" + "|" + "\n";
        ficha += "|" + "SaludActual" + this.personaje.getSaludActual() +"/"+ this.vidaMaxima+ "|" + "\n";
        ficha += "|" + "Ataque" + this.ataque + "|" + "\n";
        ficha += "|" + "Precision" + this.habilidad + "|" + "\n";
        ficha += "|" + "Evasion" + this.evasion + "|" + "\n";
        ficha += "+------------------------------------+\n";

        return ficha;
    }

    private String fichaGuerrero() {
        String ficha = "+------------------------------------+\n";
        ficha += "|" + "               " + this.clase + "               " + "|" + "\n";
        ficha += "|" + this.personaje.getNombre() + "nivel" + this.personaje.getNivel() + "                    " + "|" + "\n";
        ficha += "|" + "Monedas" + this.personaje.getMonedas() + "|" + "\n";
        ficha += "|" + "Estadisticas" + "|" + "\n";
        ficha += "|" + "SaludActual" + this.personaje.getSaludActual() +"/"+ this.vidaMaxima+ "|" + "\n";
        ficha += "|" + "Ataque" + this.ataque + "|" + "\n";
        ficha += "|" + "Precision" + this.habilidad + "|" + "\n";
        ficha += "|" + "Evasion" + this.evasion + "|" + "\n";
        ficha += "+------------------------------------+\n";

        return ficha;
    }

    private String fichaMago() {
        String ficha = "+------------------------------------+\n";
        ficha += "|" + "               " + this.clase + "               " + "|" + "\n";
        ficha += "|" + this.personaje.getNombre() + "nivel" + this.personaje.getNivel() + "                    " + "|" + "\n";
        ficha += "|" + "Monedas" + this.personaje.getMonedas() + "|" + "\n";
        ficha += "|" + "Estadisticas" + "|" + "\n";
        ficha += "|" + "SaludActual" + this.personaje.getSaludActual() +"/"+ this.vidaMaxima+ "|" + "\n";
        ficha += "|" + "Ataque" + this.ataque + "|" + "\n";
        ficha += "|" + "Precision" + this.habilidad + "|" + "\n";
        ficha += "|" + "Evasion" + this.evasion + "|" + "\n";
        ficha += "+------------------------------------+\n";

        return ficha;
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

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}


