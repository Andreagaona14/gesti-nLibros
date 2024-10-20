import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros;

    public LibroDAOImpl() {
        libros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    @Override
    public Libro obtenerLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    @Override
    public void actualizarLibro(Libro libro) {
        Libro libroExistente = obtenerLibroPorId(libro.getId());
        if (libroExistente != null) {
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setAñoPublicacion(libro.getAñoPublicacion());
            System.out.println("Libro actualizado: " + libroExistente);
        }
    }

    @Override
    public void eliminarLibro(int id) {
        Libro libro = obtenerLibroPorId(id);
        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado: " + libro);
        }
    }
}

