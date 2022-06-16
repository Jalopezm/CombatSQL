package Menu;

import Conection.ClaseSingleton;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import domain.Personaje;

import java.sql.Connection;

public class MenuCombate extends Menu{
    public MenuCombate(String title) {
        super(title);
    }

    @Override
    protected void initActions() {

        Connection con = ClaseSingleton.getConnection();
        PersonajeDaoMySql personaje = new PersonajeDaoMySql(con);
        Personaje pj = ClaseSingleton.getPersonaje();

        personaje.addLevel(pj);
    }

    @Override
    protected void onPreOptions() {

    }
}
