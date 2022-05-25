package Menu;

import domain.Usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MenuRegistro extends Menu{
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
        String contraseña = Input.readString("Introduce una Contraseña");

        Usuario usuario = new Usuario(nombre,apellido,nombreUsuario,correo,contraseña);
        System.out.println("Nuevo Usuario Creado: " + usuario.getNombre());

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            String passwordToHash = "";
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            String generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //        Si nombre de usuario existe error Creando usuario

    }
}
