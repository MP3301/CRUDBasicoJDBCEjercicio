package domain;

public class Nombre {


    private String Usuario;
    private String Nombre;
    private String Apellido;
    private int Id;

    public Nombre() {
    }

    public Nombre(int id) {
        Id = id;
    }

    public Nombre(String usuario, String nombre, String apellido, int id) {
        Usuario = usuario;
        Nombre = nombre;
        Apellido = apellido;
        Id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Nombre{" +
                "Usuario='" + Usuario + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Id=" + Id +
                '}';
    }

    public void setId(int id) {
        Id = id;
    }
}
