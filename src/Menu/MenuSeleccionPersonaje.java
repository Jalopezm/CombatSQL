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
        PersonajeDao personajeDao = new PersonajeDaoMySql(ClaseSingleton.getConnection());
        List<Personaje> personajes = personajeDao.showPersonajes(ClaseSingleton.getNombreUsuario());
        for (int i = 0; i < personajes.size() ; i++) {
            final int idx = i;
            addOption(String.valueOf(i), new MenuAction() {
                @Override
                public void execute() {
                    ClaseSingleton.setPersonaje(personajes.get(idx));
                    MenuJuego menuJuego = new MenuJuego("Elige una opción");
                    menuJuego.start();
                }

                @Override
                public String getOptionName() {
                    FichaPersonaje fichaPersonaje = new FichaPersonaje(ClaseSingleton.getPersonaje());
                    return fichaPersonaje.fichaPersonaje;
                }
            });
        }
    }

    @Override
    protected void onPreOptions() {

    }
}
