package DAO;

import domain.Objeto;

import java.util.List;

public interface ObjetoDao {
    Objeto getObjetoByID(int objetoID);

    List<Objeto> getAllObjetos();
}
