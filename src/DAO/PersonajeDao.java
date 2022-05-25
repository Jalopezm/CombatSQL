package DAO;

import domain.Personaje;
import domain.Usuario;

import java.util.List;

public interface PersonajeDao {
    List<Personaje> showCharacters(Usuario usuario);

    boolean findByNombre(String nombre);

    boolean insertNewCharaceter(Personaje personaje);

}
