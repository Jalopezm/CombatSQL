package DAO;

import domain.Calidad;
import domain.Objeto;
import domain.Personaje;

public interface CalidadDao {
    Calidad getCalidad(String tipo);
}
