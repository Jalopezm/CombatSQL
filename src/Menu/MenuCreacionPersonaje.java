package Menu;

import Conection.ClaseSingleton;
import DAO.ClaseDao;
import DAO.MySql_Implementation.ClaseDaoMySql;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.MySql_Implementation.UsuarioDaoMySql;
import DAO.PersonajeDao;
import DAO.UsuarioDao;
import domain.Clase;
import domain.Personaje;

import java.sql.Connection;

public class MenuCreacionPersonaje extends Menu{

    public MenuCreacionPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() {
        Connection con = ClaseSingleton.getConnection();
        String nombrePersonaje = Input.readString("Introduce el nombre de tu personaje");
        ClaseDao claseDao = new ClaseDaoMySql(con);
        String nombreClase = Input.readString("Introduce la clase");
        Clase clase = claseDao.getClase(nombreClase);

        Personaje personaje = new Personaje(
                new UsuarioDaoMySql(con).getUsuario(ClaseSingleton.getNombreUsuario()),
                nombrePersonaje,
                clase,
                clase.getVidaMaxima(),
                1,
                0,
                0);
        PersonajeDao personajeDao = new PersonajeDaoMySql(ClaseSingleton.getConnection());
        while (personajeDao.findIfPersonajeExists(nombrePersonaje)) {
            nombrePersonaje = Input.readString("El nombre del personaje ya existe, introduce otro. Si has cambiado de idea pulsa intro");
            if (!nombrePersonaje.equals("")) {
                personaje.setNombre(nombrePersonaje);
            } else break;
        }
        if (!nombrePersonaje.equals("")){
            personajeDao.insertNuevoPersonaje(personaje);
            System.out.println("Nuevo Usuario Creado: " + nombrePersonaje);
        }
    }
}
