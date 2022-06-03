package domain;

import Conection.ClaseSingleton;
import DAO.CalidadDao;
import DAO.MySql_Implementation.CalidadDaoMySql;

public class Calidad {
    String tipo;
    float modSalud;
    float modAtaque;
    float modHabilidad;
    float modEvasion;

    public Calidad(String tipo) {
        this.tipo = tipo;
        CalidadDao calidadDao = new CalidadDaoMySql(ClaseSingleton.getConnection());

        int [] atributes = calidadDao.getAtributes(tipo);
        this.modSalud = atributes[0];
        this.modAtaque = atributes[1];
        this.modHabilidad = atributes[2];
        this.modEvasion = atributes[3];
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getModSalud() {
        return modSalud;
    }

    public void setModSalud(float modSalud) {
        this.modSalud = modSalud;
    }

    public float getModAtaque() {
        return modAtaque;
    }

    public void setModAtaque(float modAtaque) {
        this.modAtaque = modAtaque;
    }

    public float getModHabilidad() {
        return modHabilidad;
    }

    public void setModHabilidad(float modHabilidad) {
        this.modHabilidad = modHabilidad;
    }

    public float getModEvasion() {
        return modEvasion;
    }

    public void setModEvasion(float modEvasion) {
        this.modEvasion = modEvasion;
    }
}
