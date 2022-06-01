package Menu;

import DAO.MySql_Implementation.UsuarioDaoMySql;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import Conection.ClaseSingleton;
import DAO.UsuarioDao;
import domain.Usuario;

public class MenuLogin extends Menu {
    public MenuLogin(String title) {
        super(title);
    }

    @Override
    protected void initActions() {

    }

    @Override
    protected void onPreOptions() {

        Connection con = ClaseSingleton.getConnection();

        String nombreUsuario = Input.readString("Introduce el Nombre del Usuario");
        String contraseña = Input.readString("Introduce una Contraseña");
        String contraseñaHash = "";
        //Hash Contraseña
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(contraseña.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            contraseñaHash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        UsuarioDao usuarioDao = new UsuarioDaoMySql(ClaseSingleton.getConnection());
        if (!usuarioDao.login(nombreUsuario, contraseñaHash)) {
            System.out.println("Usuario y/o contraseña incorrecto/s");

        }else {
            System.out.println("Acceso autorizado. Bienvenido " + nombreUsuario + "!");
        }

    }
}
