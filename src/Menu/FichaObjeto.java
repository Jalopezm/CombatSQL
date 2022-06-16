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
        String ficha = "\u001B[33m"+"+---------------------------------------+"+"\u001B[0m"+"\n";
        ficha += "\u001B[33m"+"|          "+this.nombre+" "+this.calidad+"          |"+"\n";
        ficha += "\u001B[33m"+"|"+"\u001B[0m"+" Vida : "+"\u001B[0m"+this.vida+"\u001B[33m"+"                               |"+"\u001B[0m"+"\n";
        ficha += "\u001B[33m"+"|"+"\u001B[0m"+" Ataque : "+"\u001B[0m"+this.ataque+"\u001B[33m"+"                            |"+"\u001B[0m"+"\n";
        ficha += "\u001B[33m"+"|"+"\u001B[0m"+" Evasion : "+"\u001B[0m"+this.evasion+"\u001B[33m"+"                         |"+"\u001B[0m"+"\n";
        ficha += "\u001B[33m"+"|"+"\u001B[0m"+" Habilidad : "+"\u001B[0m"+this.habilidad+"\u001B[33m"+"                         |"+"\u001B[0m"+"\n";
        ficha += "\u001B[33m"+"+---------------------------------------+"+"\u001B[0m"+"\n";
        return ficha;
    }

    private String fichaEpico() {
        String ficha = "\u001B[35m"+"+---------------------------------------+"+"\u001B[0m"+"\n";
        ficha += "\u001B[35m"+"|          "+this.nombre+" "+this.calidad+"          |"+"\n";
        ficha += "\u001B[35m"+"|"+"\u001B[0m"+" Vida : "+"\u001B[0m"+this.vida+"\u001B[35m"+"                               |"+"\u001B[0m"+"\n";
        ficha += "\u001B[35m"+"|"+"\u001B[0m"+" Ataque : "+"\u001B[0m"+this.ataque+"\u001B[35m"+"                            |"+"\u001B[0m"+"\n";
        ficha += "\u001B[35m"+"|"+"\u001B[0m"+" Evasion : "+"\u001B[0m"+this.evasion+"\u001B[35m"+"                         |"+"\u001B[0m"+"\n";
        ficha += "\u001B[35m"+"|"+"\u001B[0m"+" Habilidad : "+"\u001B[0m"+this.habilidad+"\u001B[35m"+"                         |"+"\u001B[0m"+"\n";
        ficha += "\u001B[35m"+"+---------------------------------------+"+"\u001B[0m"+"\n";
        return ficha;
    }

    private String fichaNormal() {
        String ficha = "\u001B[37m"+"+---------------------------------------+"+"\u001B[0m"+"\n";
        ficha += "\u001B[37m"+"|          "+this.nombre+" "+this.calidad+"          |"+"\n";
        ficha += "\u001B[37m"+"|"+"\u001B[0m"+" Vida : "+"\u001B[0m"+this.vida+"\u001B[37m"+"                               |"+"\u001B[0m"+"\n";
        ficha += "\u001B[37m"+"|"+"\u001B[0m"+" Ataque : "+"\u001B[0m"+this.ataque+"\u001B[37m"+"                            |"+"\u001B[0m"+"\n";
        ficha += "\u001B[37m"+"|"+"\u001B[0m"+" Evasion : "+"\u001B[0m"+this.evasion+"\u001B[37m"+"                         |"+"\u001B[0m"+"\n";
        ficha += "\u001B[37m"+"|"+"\u001B[0m"+" Habilidad : "+"\u001B[0m"+this.habilidad+"\u001B[37m"+"                         |"+"\u001B[0m"+"\n";
        ficha += "\u001B[37m"+"+---------------------------------------+"+"\u001B[0m"+"\n";
        return ficha;
    }

}
