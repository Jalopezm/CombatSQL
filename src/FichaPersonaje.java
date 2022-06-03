// Guerrero rojo, mago azul y picaro Verde

// Normal blanco, bendecido amarillo y épico lila

import Conection.ClaseSingleton;
import DAO.ClaseDao;
import DAO.InventarioDao;
import DAO.MySql_Implementation.ClaseDaoMySql;
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

public class FichaPersonaje {
    public static void main(String[] args) {
        Connection con = ClaseSingleton.getConnection();
        ClaseDao claseDao = new ClaseDaoMySql(con);
        InventarioDao inventarioDao = new InventarioDaoMySql(con);
        PersonajeDao personajeDao = new PersonajeDaoMySql(con);
        ObjetoDao objetoDao = new ObjetoDaoMySql(con);

        Personaje personaje = ClaseSingleton.getPersonaje();
        int[] claseAtributes = claseDao.getAtributes(personaje.getClase().getNombre());
        List<Inventario> inventario = inventarioDao.getPersonajeInventario(personajeDao.getIdPersonaje(personaje));

        int ataque = personaje.getClase().getAtaque();
        int habilidad = personaje.getClase().getHabilidad();
        int vida = personaje.getClase().getVidaMaxima();
        int evasion = personaje.getClase().getEvasion();

        for (int i = 0; i < inventario.size(); i++) {
            int objetoID = inventario.get(i).getObjetoID();
            Objeto objeto = objetoDao.getAtributes(objetoID);
            ataque += objeto.getModAtaque() * objeto.getTipo().getModAtaque();
            habilidad += objeto.getModHabilidad() * objeto.getTipo().getModHabilidad();
            vida += objeto.getModSalud() * objeto.getTipo().getModSalud();
            evasion += objeto.getModEvasion() * objeto.getTipo().getModEvasion();
        }

    }
}
