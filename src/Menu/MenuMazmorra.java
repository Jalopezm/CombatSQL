package Menu;

import Conection.ClaseSingleton;
import DAO.EnemigoDao;
import DAO.MySql_Implementation.EnemigoDaoMySql;
import domain.Enemigo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

public class MenuMazmorra extends Menu{

    public MenuMazmorra(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        Connection con = ClaseSingleton.getConnection();
        int enemigoID = (int) (Math.random()*10);
        EnemigoDao enemigoDao = new EnemigoDaoMySql(con);
        Enemigo enemigo = enemigoDao.getEnemigoByID(enemigoID);

        System.out.println("Vas a enfrentarte a " + enemigo.getNombreEnemigo() + "!");
        sleep(1000);
    }

    @Override
    protected void onPreOptions() throws SQLException {

    }
}
