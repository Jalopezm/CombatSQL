package Menu;

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

public class FichaObjeto {
    int ataque;
    int habilidad;
    int vida;
    int evasion;
    String calidad;

    public FichaObjeto(int ataque, int habilidad, int vida, int evasion,String calidad) {
        this.ataque = ataque;
        this.habilidad = habilidad;
        this.vida = vida;
        this.evasion = evasion;
        this.calidad = calidad;
    }

    public static FichaObjeto getValoresFicha(int objetoID) {
        Connection con = ClaseSingleton.getConnection();
        InventarioDao inventarioDao = new InventarioDaoMySql(con);
        ObjetoDao objetoDao = new ObjetoDaoMySql(con);

        Objeto objeto = objetoDao.getObjetoByID(objetoID);
        int ataque = objeto.getModAtaque() * (int) objeto.getTipo().getModAtaque();
        int habilidad = objeto.getModHabilidad() * (int) objeto.getTipo().getModHabilidad();
        int vidaMaxima = objeto.getModSalud() * (int) objeto.getTipo().getModSalud();
        int evasion = objeto.getModEvasion() * (int) objeto.getTipo().getModEvasion();
       String calidad = objeto.getTipo().getTipo();
        return new FichaObjeto(ataque, habilidad, vidaMaxima, evasion, calidad);
    }

}
