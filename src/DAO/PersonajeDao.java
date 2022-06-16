package DAO;

import domain.Inventario;
import domain.Personaje;
import domain.Tienda;

import java.util.List;

public interface PersonajeDao {
    List<Personaje> showPersonajes(String nombreUsuario);

    boolean findIfPersonajeExists(String nombre);

    boolean insertNuevoPersonaje(Personaje personaje);

    int getIdPersonaje(Personaje personaje);

    boolean addGold(Tienda tienda);

    boolean takeGold(Tienda tienda, Personaje personaje);

    int getGold(int personajeID);

    int getHealth(int personajeID);

    boolean heal(Personaje personaje, int curar);

    boolean takeHealth(Personaje personaje, int herir);

    int getExperience(int PersonajeID);

    boolean addExperience(Personaje personaje, int sumarExperiencia);

    boolean addLevel(Personaje personaje);

    int getVidaMaxima(Personaje personaje);


}
