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

    public FichaObjeto(String nombre,int ataque, int habilidad, int vida, int evasion,String calidad) {
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
        return new FichaObjeto(nombre,ataque, habilidad, vidaMaxima, evasion, calidad);
    }

    @Override
    public String toString() {
        System.out.println(this.calidad);
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
        String ficha = "+---------------------------------------+";
        ficha += "|                 "+this.nombre+this.calidad+"                |";
        ficha += "| Vida : "+this.vida+"                     |";
        ficha += "| Ataque : "+this.ataque+"                     |";
        ficha += "| Evasion : "+this.evasion+"                     |";
        ficha += "| Habilidad : "+this.habilidad+"                     |";
        ficha += "+---------------------------------------+";
        return ficha;
    }

    private String fichaEpico() {
        String ficha = "+---------------------------------------+";
        ficha += "|                 "+this.nombre+this.calidad+"                |";
        ficha += "| Vida : "+this.vida+"                     |";
        ficha += "| Ataque : "+this.ataque+"                     |";
        ficha += "| Evasion : "+this.evasion+"                     |";
        ficha += "| Habilidad : "+this.habilidad+"                     |";
        ficha += "+---------------------------------------+";
        return ficha;
    }

    private String fichaNormal() {
        String ficha = "+---------------------------------------+";
        ficha += "|                 "+this.nombre+this.calidad+"                |";
        ficha += "| Vida : "+this.vida+"                     |";
        ficha += "| Ataque : "+this.ataque+"                     |";
        ficha += "| Evasion : "+this.evasion+"                     |";
        ficha += "| Habilidad : "+this.habilidad+"                     |";
        ficha += "+---------------------------------------+";
        return ficha;
    }
}
