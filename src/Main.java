import java.util.Scanner;

 class AppGestorLibros {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de uso
        while (true) {
            System.out.println("Gestión de Libros:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Ver todos los libros");
            System.out.println("3. Buscar libro por ID");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar un nuevo libro
                    System.out.print("Ingresa el ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consumir salto de línea
                    System.out.print("Ingresa el título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingresa el año de publicación: ");
                    int anio = scanner.nextInt();
                    Libro nuevoLibro = new Libro(id, titulo, autor, anio);
                    libroDAO.agregarLibro(nuevoLibro);
                    break;

                case 2:
                    // Ver todos los libros
                    System.out.println("Lista de libros:");
                    for (Libro libro : libroDAO.obtenerTodosLosLibros()) {
                        System.out.println(libro);
                    }
                    break;

                case 3:
                    // Buscar libro por ID
                    System.out.print("Ingresa el ID del libro: ");
                    int idBuscar = scanner.nextInt();
                    Libro libro = libroDAO.obtenerLibroPorId(idBuscar);
                    if (libro != null) {
                        System.out.println(libro);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    // Actualizar libro
                    System.out.print("Ingresa el ID del libro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();  // Consumir salto de línea
                    System.out.print("Ingresa el nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Ingresa el nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("Ingresa el nuevo año de publicación: ");
                    int nuevoAnio = scanner.nextInt();
                    Libro libroActualizado = new Libro(idActualizar, nuevoTitulo, nuevoAutor, nuevoAnio);
                    libroDAO.actualizarLibro(libroActualizado);
                    break;

                case 5:
                    // Eliminar libro
                    System.out.print("Ingresa el ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    libroDAO.eliminarLibro(idEliminar);
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
