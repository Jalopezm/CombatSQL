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
}
