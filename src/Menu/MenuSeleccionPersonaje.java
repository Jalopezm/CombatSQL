package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.PersonajeDao;
import domain.Personaje;

import java.util.List;

public class MenuSeleccionPersonaje extends Menu{
    public MenuSeleccionPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() {
        PersonajeDao personajeDao = new PersonajeDaoMySql(ClaseSingleton.getConnection());
        List<Personaje> personajes = personajeDao.showPersonajes(ClaseSingleton.getNombreUsuario());
        for (Personaje personaje : personajes) {
            System.out.println(personaje);
        }
    }
}
