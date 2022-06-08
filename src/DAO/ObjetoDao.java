package DAO;

import domain.Objeto;

public interface ObjetoDao {
    Objeto getAtributes(int objetoID);
    Objeto getObjetoByID(int objetoID);
}
