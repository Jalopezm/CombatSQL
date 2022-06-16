package Menu;

import Conection.ClaseSingleton;
import DAO.EnemigoDao;
import DAO.InventarioDao;
import DAO.MySql_Implementation.EnemigoDaoMySql;
import DAO.MySql_Implementation.InventarioDaoMySql;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.PersonajeDao;
import domain.Enemigo;
import domain.Inventario;
import domain.Objeto;
import domain.Personaje;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

public class MenuMazmorra extends Menu{

    public MenuMazmorra(String title) {
        super(title);
    }

    @Override
    protected void initActions() throws SQLException {
        Connection con = ClaseSingleton.getConnection();
        int enemigoID = (int) (Math.random()*9 + 1);
        Personaje personaje = ClaseSingleton.getPersonaje();
        EnemigoDao enemigoDao = new EnemigoDaoMySql(con);
        Enemigo enemigo = enemigoDao.getEnemigoByID(enemigoID);
        MenuCombate menuCombate = new MenuCombate(FichaPersonaje.getValoresFicha(personaje).toString());
        FichaPersonaje fichaPersonaje = FichaPersonaje.getValoresFicha(personaje);

        System.out.println("Vas a enfrentarte a " + enemigo.getNombreEnemigo() + "!");
        Input.readString("Pulsa intro para iniciar el combate");

        while (true){
            playerAtack(fichaPersonaje, enemigo);
            if (enemigo.getSalud() <= 0){
                playerwin();
                break;
            }
            enemyAtack(enemigo, fichaPersonaje);
            if (ClaseSingleton.getPersonaje().getSaludActual() <= 0){
                System.out.println("Has perdido!");
                break;
            }
        }
        menuCombate.start();
    }

    private void playerwin() {
        Personaje personaje = ClaseSingleton.getPersonaje();
        Connection con = ClaseSingleton.getConnection();
        EnemigoDao enemigoDao = new EnemigoDaoMySql(con);
        InventarioDao inventarioDao = new InventarioDaoMySql(con);

        int gold = (int) ((Math.random() + 1)*100);
        enemigoDao.dropGold(gold);
        System.out.println("Has recibido " + gold + " monedas!");
        enemigoDao.dropExperience();
        System.out.println("Has subido un nivel, ahora eres nivel " + personaje.getNivel() + "!");
        Objeto objeto = enemigoDao.dropObjeto();
        inventarioDao.addObjecto(objeto, personaje);
        System.out.println("Has conseguido el siguiente objeto:");
        System.out.println(FichaObjeto.getValoresFicha(objeto.getObjetoID()));
    }

    private void enemyAtack(Enemigo enemigo, FichaPersonaje fichaPersonaje) {
        //con la formula calcular cuanta salud le quita personaje a enemigo y quitarsela
    }

    private void playerAtack(FichaPersonaje fichaPersonaje, Enemigo enemigo) {
        //con la formula calcular cuanta salud le quita enemigo a personaje y quitarsela
    }

    @Override
    protected void onPreOptions() throws SQLException {

    }
}
