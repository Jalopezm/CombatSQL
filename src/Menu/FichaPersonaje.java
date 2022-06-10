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
        if (inventario != null) {
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
        String monedas = reformatMonedas();
        String nivel = reformatNivel();
        String vidaActual = reformatVidaActual();
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String nombre = reformatNombre(nivel);

        String ficha = "\n" + "\u001B[32m" + "+--------------------------------------+" + "\n";
        ficha += "|" + "                " + this.clase + "                " + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + nombre + nivel + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "\u001B[33m" + "Monedas: " + monedas + "\u001B[0m" + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";

        return ficha;
    }

    String fichaGuerrero() {
        String monedas = reformatMonedas();
        String nivel = reformatNivel();
        String vidaActual = reformatVidaActual();
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String nombre = reformatNombre(nivel);
        String ficha = "\n" + "\u001B[31m" + "+--------------------------------------+" + "\n";
        ficha += "|" + "               " + this.clase + "               " + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "|" + "\u001B[0m" + nombre + nivel + "\u001B[31m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "|" + "\u001B[0m" + "\u001B[33m" + "Monedas: " + monedas + "\u001B[0m" + "\u001B[31m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[31m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[31m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[31m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[31m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[31m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[31m" + "+--------------------------------------+\n" + "\u001B[0m";

        return ficha;
    }

    String fichaMago() {
        String monedas = reformatMonedas();
        String nivel = reformatNivel();
        String vidaActual = reformatVidaActual();
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String nombre = reformatNombre(nivel);

        String ficha = "\n" + "\u001B[34m" + "+--------------------------------------+" + "\n";
        ficha += "|" + "                  " + this.clase + "                " + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "|" + "\u001B[0m" + nombre + nivel + "\u001B[34m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "|" + "\u001B[0m" + "\u001B[33m" + "Monedas: " + monedas + "\u001B[0m" + "\u001B[34m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[34m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[34m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[34m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[34m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[34m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[34m" + "+--------------------------------------+\n" + "\u001B[0m";

        return ficha;
    }

    private String reformatNombre(String nivel) {
        String nombre = personaje.getNombre();
        int nivelLength = nivel.length();
        int espacios = nombre.length() + nivelLength;
        for (int i = 0; i < (38 - (espacios)); i++) {
            nombre += " ";
        }
        return nombre;
    }

    private String reformatEvasion() {
        String evasion = String.valueOf(this.evasion);
        if (this.evasion < 100) {
            evasion = "0" + this.evasion + "                          ";
            if (this.evasion < 10) {
                evasion = "00" + this.evasion + "                         ";
            }
        }
        return evasion;
    }

    private String reformatPrecision() {
        String precision = String.valueOf(this.habilidad);
        if (this.habilidad < 100) {
            precision = "0" + this.habilidad + "                        ";
            if (this.habilidad < 10) {
                precision = "00" + this.habilidad + "                       ";
            }
        }
        return precision;
    }

    private String reformatAtaque() {
        String ataque = String.valueOf(this.ataque);
        if (this.ataque < 100) {
            ataque = "0" + this.ataque + "                           ";
            if (this.ataque < 10) {
                ataque = "00" + this.ataque + "                           ";
            }
        }
        return ataque;
    }

    private String reformatVidaMaxima() {
        String vidaMaxima = String.valueOf(this.vidaMaxima);
        if (this.vidaMaxima < 100) {
            vidaMaxima = "0" + this.vidaMaxima + "                  ";
            if (this.vidaMaxima < 10) {
                vidaMaxima = "00" + this.vidaMaxima + "                 ";
            }
        }
        return vidaMaxima;
    }

    private String reformatVidaActual() {
        String vidaActual = String.valueOf(this.personaje.getSaludActual());
        if (this.personaje.getSaludActual() < 100) {
            vidaActual = "0" + this.personaje.getSaludActual();
            if (this.personaje.getSaludActual() < 10) {
                vidaActual = "00" + this.personaje.getSaludActual();
            }
        }
        return vidaActual;
    }

    private String reformatNivel() {
        String nivel = this.personaje.getNivel() + "  ";
        if (this.personaje.getNivel() < 100) {
            nivel = this.personaje.getNivel() + "   ";
            if (this.personaje.getNivel() < 10) {
                nivel = this.personaje.getNivel() + "  ";
            }
        }
        return "nivel" + ": " + nivel;
    }

    private String reformatMonedas() {
        String monedas = this.personaje.getMonedas() + "                       ";
        if (this.personaje.getMonedas() < 100_000) {
            monedas = this.personaje.getMonedas() + "                         ";
            if (this.personaje.getMonedas() < 10_000) {
                monedas = this.personaje.getMonedas() + "                         ";
                if (this.personaje.getMonedas() < 1000) {
                    monedas = this.personaje.getMonedas() + "                          ";
                    if (this.personaje.getMonedas() < 100) {
                        monedas = this.personaje.getMonedas() + "                           ";
                        if (this.personaje.getMonedas() < 10) {
                            monedas = this.personaje.getMonedas() + "                            ";
                        }
                    }
                }
            }
        }
        return monedas;
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


