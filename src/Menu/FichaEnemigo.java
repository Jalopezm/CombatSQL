package Menu;

import Conection.ClaseSingleton;
import DAO.InventarioDao;
import DAO.MySql_Implementation.InventarioDaoMySql;
import DAO.MySql_Implementation.ObjetoDaoMySql;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.ObjetoDao;
import DAO.PersonajeDao;
import domain.Enemigo;
import domain.Inventario;
import domain.Objeto;
import domain.Personaje;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

public class FichaEnemigo {
    int ataque;
    int habilidad;
    int vidaMaxima;
    int evasion;
    String nombreEnemigo;
    Enemigo enemigo;
    int vidaActual;

    public FichaEnemigo(int ataque, int habilidad, int vidaMaxima, int evasion, String nombreEnemigo,Enemigo enemigo,int vidaActual) {
        this.ataque = ataque;
        this.habilidad = habilidad;
        this.vidaMaxima = vidaMaxima;
        this.evasion = evasion;
        this.nombreEnemigo = nombreEnemigo;
        this.enemigo = enemigo;
        this.vidaActual = vidaActual;

    }

    public static FichaEnemigo getValoresFicha(Enemigo enemigo) {
        Personaje personaje = ClaseSingleton.getPersonaje();

        int ataque = enemigo.getAtaque() * personaje.getNivel();
        int habilidad = enemigo.getHabilidad()* personaje.getNivel();
        int vidaMaxima = enemigo.getSalud() * personaje.getNivel();
        int evasion = enemigo.getEvasion() * personaje.getNivel();
        int vidaActual = vidaMaxima;

        String nombreEnemigo = enemigo.getNombreEnemigo();

        return new FichaEnemigo(ataque, habilidad, vidaMaxima, evasion,nombreEnemigo,enemigo,vidaActual);
    }

    public String toString() {
        if (Objects.equals(this.nombreEnemigo, "Goblin")) {
            return fichaGoblin();
        } else if (Objects.equals(this.nombreEnemigo, "Esqueleto")) {
            return fichaEsqueleto();
        } else if (Objects.equals(this.nombreEnemigo, "Sr Mojon")) {
            return fichaSrMojon();
        }else if (Objects.equals(this.nombreEnemigo, "Orco")) {
            return fichaOrco();
        }else if (Objects.equals(this.nombreEnemigo, "Troll")) {
            return fichaTroll();
        }else if (Objects.equals(this.nombreEnemigo, "Lobo")) {
            return fichaLobo();
        }else if (Objects.equals(this.nombreEnemigo, "Arpia")) {
            return fichaArpia();
        }else if (Objects.equals(this.nombreEnemigo, "Hipogrifo")) {
            return fichaHipogrifo();
        }else if (Objects.equals(this.nombreEnemigo, "Liche")) {
            return fichaLiche();
        } else {
            return "";
        }
    }

    private String fichaLiche() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaHipogrifo() {  String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;

    }

    private String fichaArpia() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaLobo() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaTroll() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaOrco() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaSrMojon() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaGoblin() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
    }

    private String fichaEsqueleto() {
        String vidaMaxima = reformatVidaMaxima();
        String ataque = reformatAtaque();
        String precision = reformatPrecision();
        String evasion = reformatEvasion();
        String vidaActual = reformatVidaActual();

        String ficha = "+--------------------------------------+"+"\n";
        ficha += "|" +this.nombreEnemigo+"|"+"\n";
        ficha += "\u001B[32m" + "|--------------" + "Estadisticas" + "------------|" + "\n" + "\u001B[0m";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "SaludActual: " + vidaActual + "/" + vidaMaxima + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Ataque: " + ataque + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Precision: " + precision + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "|" + "\u001B[0m" + "Evasion: " + evasion + "\u001B[32m" + "|" + "\u001B[0m" + "\n";
        ficha += "\u001B[32m" + "+--------------------------------------+\n" + "\u001B[0m";
        return ficha;
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
        String vidaActual = String.valueOf(this.vidaActual);
        if (this.vidaActual < 100) {
            vidaActual = "0" + this.vidaActual;
            if (this.vidaActual < 10) {
                vidaActual = "00" + this.vidaActual;
            }
        }
        return vidaActual;
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
        return nombreEnemigo;
    }

    public void setClase(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
}
