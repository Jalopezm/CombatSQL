package Menu;

import domain.Usuario;

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

        //        Si nombre de usuario existe error Creando usuario

    }
}
