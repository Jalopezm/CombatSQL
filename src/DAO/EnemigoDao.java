package DAO;

import domain.Enemigo;
import domain.Objeto;
import domain.Personaje;

public interface EnemigoDao {
    Enemigo getEnemigoByID(int enemigoID);

    int getHealth(int enemigoID);

    boolean takeHealth(int enemigoID, int restarSalud);

    void dropExperience();

    void dropGold(int monedas);

    Objeto dropObjeto();
}
