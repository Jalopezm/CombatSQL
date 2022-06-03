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

public class FichaPersonaje {
    String fichaPersonaje;
    FichaPersonaje(Personaje personaje){
        this.fichaPersonaje = getValoresFicha(personaje);
    }

    public String getValoresFicha(Personaje personaje) {
        Connection con = ClaseSingleton.getConnection();
        InventarioDao inventarioDao = new InventarioDaoMySql(con);
        PersonajeDao personajeDao = new PersonajeDaoMySql(con);
        ObjetoDao objetoDao = new ObjetoDaoMySql(con);

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
        if (personaje.getClase().getNombre() == "Mago") {
            return fichaMago(personaje);
        } else if (personaje.getClase().getNombre() == "Picaro") {
            return fichaPicaro(personaje);
        } else if (personaje.getClase().getNombre() == "Guerrero") {
            return fichaGuerrero(personaje);
        } else {
            return "";
        }
    }

    String fichaPicaro(Personaje personaje) {
        String ficha = "+------------------------------------+\n";
        ficha += "|";
        ficha += personaje.getClase().getNombre();
        return ficha;
    }

    private String fichaGuerrero(Personaje personaje) {
        return "";
    }

    private String fichaMago(Personaje personaje) {
        return "";
    }

}
