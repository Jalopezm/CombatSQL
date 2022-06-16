package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.ObjetoDaoMySql;
import DAO.ObjetoDao;
import domain.Objeto;

import java.sql.Connection;
import java.util.Objects;

public class FichaObjeto {
    String nombre;
    int ataque;
    int habilidad;
    int vida;
    int evasion;
    String calidad;

    public FichaObjeto(String nombre, int ataque, int habilidad, int vida, int evasion, String calidad) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.habilidad = habilidad;
        this.vida = vida;
        this.evasion = evasion;
        this.calidad = calidad;
    }

    public static FichaObjeto getValoresFicha(int objetoID) {
        Connection con = ClaseSingleton.getConnection();
        ObjetoDao objetoDao = new ObjetoDaoMySql(con);

        Objeto objeto = objetoDao.getObjetoByID(objetoID);
        String nombre = objeto.getNombreObjeto();
        int ataque = objeto.getModAtaque() * (int) objeto.getTipo().getModAtaque();
        int habilidad = objeto.getModHabilidad() * (int) objeto.getTipo().getModHabilidad();
        int vidaMaxima = objeto.getModSalud() * (int) objeto.getTipo().getModSalud();
        int evasion = objeto.getModEvasion() * (int) objeto.getTipo().getModEvasion();
        String calidad = objeto.getTipo().getTipo();
        return new FichaObjeto(nombre, ataque, habilidad, vidaMaxima, evasion, calidad);
    }

    @Override
    public String toString() {
        if (Objects.equals(this.calidad, "Normal")) {
            return fichaNormal();
        } else if (Objects.equals(this.calidad, "Epico/a")) {
            return fichaEpico();
        } else if (Objects.equals(this.calidad, "Bendecido/a")) {
            return fichaBendecido();
        } else {
            return "";
        }
    }

    private String fichaBendecido() {
        String vidaMax = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String evasion = reformatEvasion();
        String habilidad = reformatPrecision();
        String nombre = reformatNombre();
        String calidad = reformatCalidad();


        String ficha = "\u001B[33m" + "+---------------------------------------+" + "\u001B[0m" + "\n";
        ficha += "\u001B[33m" + "|" + nombre + " " + calidad + "|" + "\n";
        ficha += "\u001B[33m" + "|" + "\u001B[0m" + " Vida : " + "\u001B[0m" + vidaMax + "\u001B[33m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[33m" + "|" + "\u001B[0m" + " Ataque : " + "\u001B[0m" + ataque + "\u001B[33m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[33m" + "|" + "\u001B[0m" + " Evasion : " + "\u001B[0m" + evasion + "\u001B[33m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[33m" + "|" + "\u001B[0m" + " Habilidad : " + "\u001B[0m" + habilidad + "\u001B[33m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[33m" + "+---------------------------------------+" + "\u001B[0m" + "\n";
        return ficha;
    }

    private String fichaEpico() {
        String vidaMax = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String evasion = reformatEvasion();
        String habilidad = reformatPrecision();
        String nombre = reformatNombre();
        String calidad = reformatCalidad();


        String ficha = "\u001B[35m" + "+---------------------------------------+" + "\u001B[0m" + "\n";
        ficha += "\u001B[35m" + "|" + nombre + " " + calidad + "|" + "\n";
        ficha += "\u001B[35m" + "|" + "\u001B[0m" + " Vida : " + "\u001B[0m" + vidaMax + "\u001B[35m" +"|"+ "\u001B[0m" + "\n";
        ficha += "\u001B[35m" + "|" + "\u001B[0m" + " Ataque : " + "\u001B[0m" + ataque + "\u001B[35m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[35m" + "|" + "\u001B[0m" + " Evasion : " + "\u001B[0m" + evasion + "\u001B[35m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[35m" + "|" + "\u001B[0m" + " Habilidad : " + "\u001B[0m" + habilidad + "\u001B[35m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[35m" + "+---------------------------------------+" + "\u001B[0m" + "\n";
        return ficha;
    }

    private String fichaNormal() {
        String vidaMax = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String evasion = reformatEvasion();
        String habilidad = reformatPrecision();
        String nombre = reformatNombre();
        String calidad = reformatCalidad();

        String ficha = "\u001B[37m" + "+---------------------------------------+" + "\u001B[0m" + "\n";
        ficha += "\u001B[37m" + "|" + nombre + " " + calidad + "|" + "\n";
        ficha += "\u001B[37m" + "|" + "\u001B[0m" + " Vida : " + "\u001B[0m" + vidaMax + "\u001B[37m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[37m" + "|" + "\u001B[0m" + " Ataque : " + "\u001B[0m" + ataque + "\u001B[37m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[37m" + "|" + "\u001B[0m" + " Evasion : " + "\u001B[0m" + evasion + "\u001B[37m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[37m" + "|" + "\u001B[0m" + " Habilidad : " + "\u001B[0m" + habilidad + "\u001B[37m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[37m" + "+---------------------------------------+" + "\u001B[0m" + "\n";
        return ficha;
    }

    private String reformatCalidad() {
        String calidad = String.valueOf(this.calidad);
        if (this.calidad.equals("Epico/a")) {
            calidad = this.calidad + "             " ;
        }else if (this.calidad.equals("Normal")) {
            calidad = this.calidad + "            " ;
        }else if (this.calidad.equals("Bendecido/a")) {
            calidad =  this.calidad + "           " ;
        }
        return calidad;
    }

    private String reformatNombre() {
        String nombre = String.valueOf(this.nombre);
        if (this.nombre.equals("Espada")) {
            nombre = "            " + this.nombre;
        }else if (this.nombre.equals("Cinturon")) {
            nombre = "            " + this.nombre;
        }else if (this.nombre.equals("Chaleco")) {
            nombre = "         " + this.nombre;
        }
        return nombre;
    }

    private String reformatVidaMaxima() {
        String vidaMaxima = String.valueOf(this.vida);
        if (this.vida < 10) {
            vidaMaxima = "0" + this.vida;
        }
        return vidaMaxima+ "                             ";
    }

    private String reformatAtaque() {
        String ataque = String.valueOf(this.ataque);
        if (this.ataque < 10) {
            ataque = "0" + this.ataque;
        }
        return ataque+ "                           ";
    }

    private String reformatEvasion() {
        String evasion = String.valueOf(this.evasion);
        if (this.evasion < 10) {
            evasion = "0" + this.evasion;
        }
        return evasion+ "                          ";
    }

    private String reformatPrecision() {
        String habilidad = String.valueOf(this.habilidad);
        if (this.habilidad < 10) {
            habilidad = "0" + this.habilidad;
        }
        return habilidad+ "                        ";
    }
}
