package DAO;

import domain.Personaje;
import domain.Usuario;

import java.util.List;

public interface PersonajeDao {
    List<Personaje> showPersonajes(Usuario usuario);

    boolean findIfPersonajeExists(String nombre);

    boolean insertNuevoPersonaje(Personaje personaje);

}
