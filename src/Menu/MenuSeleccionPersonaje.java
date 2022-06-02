package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.PersonajeDao;
import domain.Personaje;

import javax.swing.*;
import java.util.List;

public class MenuSeleccionPersonaje extends Menu{
    public MenuSeleccionPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        //Usuario elige personaje
        //una vez elegido se guarda
        //Personaje personajeSeleccionado = personaje elegido por el usuario
        //ClaseSingleton.setPersonaje(personajeSeleccionado);
        //Ir al menu combate
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
                    return personajes.get(idx).toString();
                }
            });
        }
    }

    @Override
    protected void onPreOptions() {

    }
}
