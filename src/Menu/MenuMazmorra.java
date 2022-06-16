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

public class MenuMazmorra extends Menu {

    public MenuMazmorra(String title) {
        super(title);
    }

    @Override
    protected void initActions() throws SQLException {
        Connection con = ClaseSingleton.getConnection();
        int enemigoID = (int) (Math.random() * 9 + 1);
        Personaje personaje = ClaseSingleton.getPersonaje();
        EnemigoDao enemigoDao = new EnemigoDaoMySql(con);
        Enemigo enemigo = enemigoDao.getEnemigoByID(enemigoID);
        MenuCombate menuCombate = new MenuCombate(FichaPersonaje.getValoresFicha(personaje).toString());
        FichaPersonaje fichaPersonaje = FichaPersonaje.getValoresFicha(personaje);

        System.out.println("Vas a enfrentarte a " + enemigo.getNombreEnemigo() + "!");
        Input.readString("Pulsa intro para iniciar el combate");

        while (true) {
            sleep(1000);
            playerAtack(fichaPersonaje, FichaEnemigo.getValoresFicha(enemigo));
            if (enemigo.getSalud() <= 0) {
                playerwin();
                break;
            }
            sleep(1000);
            enemyAtack(FichaEnemigo.getValoresFicha(enemigo), fichaPersonaje);
            if (ClaseSingleton.getPersonaje().getSaludActual() <= 0) {
                System.out.println("Has perdido!");
                break;
            }
            sleep(1000);
        }
        menuCombate.start();
    }

    private void playerwin() {
        Personaje personaje = ClaseSingleton.getPersonaje();
        Connection con = ClaseSingleton.getConnection();
        EnemigoDao enemigoDao = new EnemigoDaoMySql(con);
        InventarioDao inventarioDao = new InventarioDaoMySql(con);

        int gold = (int) ((Math.random() + 1) * 100);
        enemigoDao.dropGold(gold);
        System.out.println("Has recibido " + gold + " monedas!");
        enemigoDao.dropExperience();
        System.out.println("Has subido un nivel, ahora eres nivel " + personaje.getNivel() + "!");
        Objeto objeto = enemigoDao.dropObjeto();
        inventarioDao.addObjecto(objeto, personaje);
        System.out.println("Has conseguido el siguiente objeto:");
        System.out.println(FichaObjeto.getValoresFicha(objeto.getObjetoID()));
    }

    private void enemyAtack(FichaEnemigo fichaEnemigo, FichaPersonaje fichaPersonaje) {
        //con la formula calcular cuanta salud le quita personaje a enemigo y quitarsela
        Random random = new Random();
        int ataque = random.nextInt(0, 300);
        int golpe = 0;
        if (ataque <= 15) {
            golpe = fichaEnemigo.getAtaque() * 0;
            System.out.println("Has fallado");
        } else if (ataque >= 15 && ataque <= 50) {
            golpe = (int) (fichaEnemigo.getAtaque() * 0.5);
            System.out.println("Casi Fallas");
        } else if (ataque > 50 && ataque <= 75) {
            golpe = fichaEnemigo.getAtaque() * 1;
            System.out.println("Golpe");
        } else if (ataque > 76) {
            golpe = (int) (fichaEnemigo.getAtaque() * 1.25);
            System.out.println("Golpe Critico");
        }

        fichaPersonaje.setVidaActual(fichaPersonaje.getVidaActual()- golpe);

        System.out.println(fichaPersonaje.toString());
    }

    private void playerAtack(FichaPersonaje fichaPersonaje, FichaEnemigo fichaEnemigo) {
        //con la formula calcular cuanta salud le quita enemigo a personaje y quitarsela
        Random random = new Random();
        int ataque = random.nextInt(0, 300);
        int golpe = 0;
        if (ataque <= 15) {
            golpe = fichaPersonaje.getAtaque() * 0;
        } else if (ataque >= 15 && ataque <= 50) {
            golpe = (int) (fichaPersonaje.getAtaque() * 0.5);
        } else if (ataque > 50 && ataque <= 75) {
            golpe = fichaPersonaje.getAtaque() * 1;
        } else if (ataque > 76) {
            golpe = (int) (fichaPersonaje.getAtaque() * 1.25);
        }
       fichaEnemigo.setVidaActual(fichaEnemigo.getVidaActual()-golpe);
        System.out.println(fichaEnemigo.toString());
    }

    @Override
    protected void onPreOptions() throws SQLException {

    }
}
