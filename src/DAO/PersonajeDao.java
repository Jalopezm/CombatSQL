package DAO;

import domain.Personaje;

import java.util.List;

public interface PersonajeDao {
    List<Personaje> showPersonajes(String nombreUsuario);

    boolean findIfPersonajeExists(String nombre);

    boolean insertNuevoPersonaje(Personaje personaje);

    int getIdPersonaje(Personaje personaje);
}
