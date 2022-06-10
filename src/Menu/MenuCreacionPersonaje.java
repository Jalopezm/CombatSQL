package Menu;

import Conection.ClaseSingleton;
import DAO.ClaseDao;
import DAO.MySql_Implementation.ClaseDaoMySql;
import DAO.MySql_Implementation.PersonajeDaoMySql;
import DAO.MySql_Implementation.UsuarioDaoMySql;
import DAO.PersonajeDao;
import DAO.UsuarioDao;
import domain.Clase;
import domain.Personaje;

import java.sql.Connection;
import java.sql.SQLException;

public class MenuCreacionPersonaje extends Menu {

    public MenuCreacionPersonaje(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("S", new MenuAction() {
            @Override
            public void execute() throws SQLException {
                Menu menuPersonaje = new MenuPersonaje("\u001B[31m" + "   _____                                                         \n" +
                        "  /     \\   ____   ____  __ __                                   \n" +
                        " /  \\ /  \\_/ __ \\ /    \\|  |  \\                                  \n" +
                        "/    Y    \\  ___/|   |  \\  |  /                                  \n" +
                        "\\____|__  /\\___  >___|  /____/                                   \n" +
                        "        \\/     \\/     \\/                                         \n" + "\u001B[0m" + "\u001B[35m" +
                        "__________                                             __        \n" +
                        "\\______   \\ ___________  __________   ____ _____      |__| ____  \n" +
                        " |     ___// __ \\_  __ \\/  ___/  _ \\ /    \\\\__  \\     |  |/ __ \\ \n" +
                        " |    |   \\  ___/|  | \\/\\___ (  <_> )   |  \\/ __ \\_   |  \\  ___/ \n" +
                        " |____|    \\___  >__|  /____  >____/|___|  (____  /\\__|  |\\___  >\n" +
                        "               \\/           \\/           \\/     \\/\\______|    \\/ " + "\u001B[0m");
                menuPersonaje.start();
            }

            @Override
            public String getOptionName() {
                return ") Salir";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        Connection con = ClaseSingleton.getConnection();
        String nombrePersonaje = Input.readString("Introduce el nombre de tu personaje");
        while (nombrePersonaje.length() > 12 && nombrePersonaje.length() < 1) {
            nombrePersonaje = Input.readString("Introduce el nombre de tu personaje");
        }
            ClaseDao claseDao = new ClaseDaoMySql(con);
            Clase clase = claseDao.getClase("");
            boolean respuestaValida = false;
            while (!respuestaValida) {
                System.out.println("0) Picaro");
                System.out.println("1) Mago");
                System.out.println("2) Guerrero");
                String nombreClase = Input.readString("Elige una de las Clases");
                if (nombreClase.equals("0")) {
                    clase = claseDao.getClase("Picaro");
                    respuestaValida = true;
                } else if (nombreClase.equals("1")) {
                    clase = claseDao.getClase("Mago");
                    respuestaValida = true;
                } else if (nombreClase.equals("2")) {
                    clase = claseDao.getClase("Guerrero");
                    respuestaValida = true;
                } else {
                    System.out.println("Introduce un número valido");
                }
            }

            Personaje personaje = new Personaje(
                    new UsuarioDaoMySql(con).getUsuario(ClaseSingleton.getNombreUsuario()),
                    nombrePersonaje,
                    clase,
                    clase.getVidaMaxima(),
                    1,
                    0,
                    0);
            PersonajeDao personajeDao = new PersonajeDaoMySql(ClaseSingleton.getConnection());
            while (personajeDao.findIfPersonajeExists(nombrePersonaje)) {
                nombrePersonaje = Input.readString("El nombre del personaje ya existe, introduce otro. Si has cambiado de idea pulsa intro");
                if (!nombrePersonaje.equals("")) {
                    personaje.setNombre(nombrePersonaje);
                } else break;
            }
            if (!nombrePersonaje.equals("")) {
                personajeDao.insertNuevoPersonaje(personaje);
                System.out.println("Nuevo Usuario Creado: " + nombrePersonaje);
            }

        }
    }
