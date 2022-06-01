package Menu;

import Conection.ClaseSingleton;
import Conection.DBUtil;
import DAO.MySql_Implementation.UsuarioDaoMySql;
import DAO.UsuarioDao;
import domain.Clase;
import domain.Usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

public class MenuRegistro extends Menu {
    public MenuRegistro(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
    }

    @Override
    protected void onPreOptions() {
        String nombre = Input.readString("Introduce tu Nombre");
        String apellido = Input.readString("Introduce tu apellido");
        String nombreUsuario = Input.readString("Introduce el Nombre del Usuario");
        String correo = Input.readString("Introduce un email");
        String contraseña = createHash(Input.readString("Introduce una Contraseña"));

        Usuario USUARIO = new Usuario(nombre, apellido, nombreUsuario, correo, contraseña);
        UsuarioDao usuarioDao = new UsuarioDaoMySql(ClaseSingleton.getConnection());
        while (usuarioDao.findIfUsuarioExists(nombreUsuario)) {
            String newNombreUsuario = Input.readString("El nombre de usuario ya existe, introduce otro. Si has cambiado de idea introduce x.");
            if ( newNombreUsuario.equals("x")) {
                System.exit(1);
            }
            USUARIO.setNombreUsuario(newNombreUsuario);
        }
        usuarioDao.insertNuevoUsuario(USUARIO);
        System.out.println("Nuevo Usuario Creado: " + USUARIO.getNombre());


    }

    private static String createHash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(pass.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
