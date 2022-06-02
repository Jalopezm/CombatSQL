package domain;

import Conection.ClaseSingleton;
import DAO.ClaseDao;
import DAO.MySql_Implementation.ClaseDaoMySql;

import java.util.List;

public class Clase {
    String nombre;
    int ataque;
    int evasion;
    int habilidad;
    int vidaMaxima;

    public Clase(String nombre) {
        this.nombre = nombre;
        ClaseDao claseDao = new ClaseDaoMySql(ClaseSingleton.getConnection());
        int[] atributes = claseDao.getAtributes(nombre);
        this.ataque = atributes[0];
        this.evasion = atributes[1];
        this.habilidad = atributes[2];
        this.vidaMaxima = atributes[3];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int precision) {
        this.habilidad = precision;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
}
