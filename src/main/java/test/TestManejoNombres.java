package test;

import datos.NombreDAO;
import domain.Nombre;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestManejoNombres {
    public static void main(String[] args) {
        //ANTES DE CORRER EL PROGRAMA PARA QUE FUNCIONE
        //crear DB llamada testdbJDBC
        //con user root
        // con password null
        /*
        * String JDBC_URL = "jdbc:mysql://localhost:3306/testdbJDBC?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        JDBC_USER = "root";
        JDBC_PASSWORD = null;
        * */
        // CREAR TABLA LLAMADA nombre;
        //CAMPOS
        //Usuario	varchar(30)
        //Nombre	varchar(30)
        //Apellido	varchar(30)
        //Id	int(30)

        TestManejoNombres.inicio();

    }

    public static void inicio() {

        Scanner intro = new Scanner(System.in);
        int x;


        System.out.println("----------------BIENVENIDO AL SISTEMA--------------");
        System.out.println("SELECCIONE LA OPERACION A REALIZAR");
        System.out.println("1. LISTAR USUARIOS");
        System.out.println("2. AGREGAR USUARIO");
        System.out.println("3. MODIFICAR USUARIO");
        System.out.println("4. ELIMINAR USUARIO");
        System.out.println("5. SALIR");
        System.out.println("---------------------------------------------------");
        x = intro.nextInt();
        switch (x) {

            case 1:
                TestManejoNombres.Listar();
                break;

            case 2:
                Scanner input1 = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                Scanner input3 = new Scanner(System.in);
                String usuario = null;
                String nombre = null;
                String apellido = null;
                System.out.println("INGRESE USERNAME, NO DEBE ESTAR VACIO");
                usuario = input1.nextLine();
                System.out.println("INGRESE NOMBRE DE USUARIO, NO DEBE ESTAR VACIO");
                nombre = input2.nextLine();
                System.out.println("INGRESE APELLIDO DE USUARIO, NO DEBE ESTAR VACIO");
                apellido = input3.nextLine();
                TestManejoNombres.Insertar(usuario,nombre,apellido);
                break;

            case 3:
                System.out.println("ELIJA USUARIO A ACTUALIZAR USANDO EL ID DE LA LISTA DEL USUARIO DESEADO");
                TestManejoNombres.ListarNoMenu();
                Scanner input1upd = new Scanner(System.in);
                Scanner input2upd = new Scanner(System.in);
                Scanner input3upd = new Scanner(System.in);
                Scanner input4upd = new Scanner(System.in);
                String usuarioUpd = null;
                String nombreUpd = null;
                String apellidoUpd = null;
                int  IdUpd = 0;

                System.out.println("INGRESE ID DE USUARIO A ACTUALIZAR, NO DEBE ESTAR VACIO, DEBE SER NUMERICO");
                IdUpd = input4upd.nextInt();
                System.out.println("INGRESE NUEVO USERNAME, NO DEBE ESTAR VACIO");
                usuarioUpd = input1upd.nextLine();
                System.out.println("INGRESE NUEVO NOMBRE DE USUARIO, NO DEBE ESTAR VACIO");
                nombreUpd = input2upd.nextLine();
                System.out.println("INGRESE NUEVO APELLIDO DE USUARIO, NO DEBE ESTAR VACIO");
                apellidoUpd = input3upd.nextLine();

                TestManejoNombres.Actualizar(usuarioUpd,nombreUpd,apellidoUpd,IdUpd);
                break;

            case 4:
                System.out.println("ELIJA USUARIO A ELIMINAR USANDO EL ID DE LA LISTA DEL USUARIO DESEADO");
                TestManejoNombres.ListarNoMenu();
                Scanner input1del = new Scanner(System.in);
                int  IdDel = 0;
                System.out.println("INGRESE ID DE USUARIO A ELIMINAR, NO DEBE ESTAR VACIO, DEBE SER NUMERICO");
                IdDel = input1del.nextInt();
                TestManejoNombres.Eliminar(IdDel);
                break;

            case 5:
                System.out.println("GRACIAS POR USAR NUESTRO SISTEMA");
                break;

            default:
                System.out.println("FUNCION NO RECONOCIDA");



        }

    }
    public static void ListarNoMenu(){


        NombreDAO nombreDao = new  NombreDAO();

        List<Nombre> nombres = nombreDao.seleccionar();

//lambda
        System.out.println("--------LISTA USUARIOS-------------");
        nombres.forEach(nombre -> {
            System.out.println(nombre);
        });


        System.out.println("-------------------------------");

    }

    public static void Listar(){


        NombreDAO nombreDao = new  NombreDAO();

        List<Nombre> nombres = nombreDao.seleccionar();

//lambda
        System.out.println("--------LISTA USUARIOS-------------");
        nombres.forEach(nombre -> {
            System.out.println(nombre);
        });


        System.out.println("-------------------------------");
        TestManejoNombres.inicio();
    }


    public static void Insertar(String usuario,String vnombre, String apellido){
        NombreDAO nombreDao = new  NombreDAO();
        // initialize a Random object somewhere; you should only need one
        Random random = new Random();

// generate a random integer from 0 to 899, then add 100
        int x = random.nextInt(900) + 100;


        //insertando un nuevo objeto de tipo Nombre
        Nombre nombreNueva = new Nombre(usuario,vnombre,apellido,x);
        System.out.println("----------USUARIO INSERTADO----------");
        System.out.println("Usuario="+usuario);
        System.out.println("Nombre="+vnombre);
        System.out.println("Apellido="+apellido);
        nombreDao.insertar(nombreNueva);

        List<Nombre> nombresNueva = nombreDao.seleccionar();

//lambda
        System.out.println("--------LISTA USUARIOS-------------");
        nombresNueva.forEach(nombre -> {
            System.out.println(nombre);
        });


        System.out.println("-------------------------------");
        TestManejoNombres.inicio();
    }





    public static void Actualizar(String usuario,String vnombre, String apellido,int Id){
        NombreDAO nombreDao = new  NombreDAO();

        //insertando un nuevo objeto de tipo Nombre
        Nombre nombresNuevaUpdate = new Nombre(usuario,vnombre,apellido,Id);

        System.out.println("-----------USUARIO ACTUALIZADO----------");
        System.out.println("Usuario="+usuario);
        System.out.println("Nombre="+vnombre);
        System.out.println("Apellido="+apellido);
        System.out.println("Id="+Id);
        System.out.println("-------------------------------------------");
        nombreDao.actualizar(nombresNuevaUpdate);

        List<Nombre> nombresNuevaUpd = nombreDao.seleccionar();

//lambda
        System.out.println("--------LISTA CON DATOS ACTUALIZADOS-------------");
        nombresNuevaUpd.forEach(nombre -> {
            System.out.println(nombre);
        });


        System.out.println("-------------------------------");


        TestManejoNombres.inicio();
    }

    public static void Eliminar(int Id){
        NombreDAO nombreDao = new  NombreDAO();
        //eliminando un nuevo objeto de tipo Nombre
        Nombre nombresNuevaDelete = new Nombre(Id);

        nombreDao.eliminar(nombresNuevaDelete);
        System.out.println("----------USUARIO ELIMINADO EXITOSAMENTE--------");
        TestManejoNombres.inicio();
    }
}


