import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase base
class Usuario {
    private String nombre;
    private String email;
    private String rol;

    public Usuario(String nombre, String email, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Rol: " + rol);
    }
}

// Subclase para Empleado Regular
class EmpleadoRegular extends Usuario {
    public EmpleadoRegular(String nombre, String email) {
        super(nombre, email, "Empleado");
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Permisos: Solo puede ver sus datos y realizar tareas básicas.");
    }
}

// Subclase para Supervisor
class Supervisor extends Usuario {
    public Supervisor(String nombre, String email) {
        super(nombre, email, "Supervisor");
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Permisos: Puede ver detalles de todos los empleados y supervisar su trabajo.");
    }
}

// Subclase para Administrador
class Administrador extends Usuario {
    public Administrador(String nombre, String email) {
        super(nombre, email, "Administrador");
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Permisos: Puede gestionar todos los usuarios (crear, eliminar, modificar) y ver la información completa de cualquier usuario.");
    }
}

// Clase principal para gestionar usuarios
public class Main434 {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenu");
            System.out.println("1. Agregar Empleado Regular");
            System.out.println("2. Agregar Supervisor");
            System.out.println("3. Agregar Administrador");
            System.out.println("4. Mostrar Todos los Usuarios");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEmpleadoRegular();
                    break;
                case 2:
                    agregarSupervisor();
                    break;
                case 3:
                    agregarAdministrador();
                    break;
                case 4:
                    mostrarUsuarios();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void agregarEmpleadoRegular() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del empleado: ");
        String email = scanner.nextLine();
        usuarios.add(new EmpleadoRegular(nombre, email));
        System.out.println("Empleado Regular agregado.");
    }

    private static void agregarSupervisor() {
        System.out.print("Ingrese el nombre del supervisor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del supervisor: ");
        String email = scanner.nextLine();
        usuarios.add(new Supervisor(nombre, email));
        System.out.println("Supervisor agregado.");
    }

    private static void agregarAdministrador() {
        System.out.print("Ingrese el nombre del administrador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del administrador: ");
        String email = scanner.nextLine();
        usuarios.add(new Administrador(nombre, email));
        System.out.println("Administrador agregado.");
    }

    private static void mostrarUsuarios() {
        System.out.println("\nLista de Usuarios");
        for (Usuario usuario : usuarios) {
            usuario.mostrarDetalles();
            System.out.println();
        }
    }
}