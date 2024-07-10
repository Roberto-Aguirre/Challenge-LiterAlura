package com.rias.literalura.principal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.rias.literalura.modelos.Libro;
import com.rias.literalura.modelos.dto.DatosResponse;
import com.rias.literalura.repository.AutorRepository;
import com.rias.literalura.repository.LibroRepository;
// import com.rias.literalura.repository.LibroRepository;
import com.rias.literalura.modelos.Autor;
import com.rias.literalura.service.ConvierteDatos;
import com.rias.literalura.service.ServiceConsultaApi;

public class Principal {
    private static ServiceConsultaApi consultaApi = new ServiceConsultaApi();
    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String SEACH = "?search=";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    private String menu = """
            \n1 - Buscar libro por titulo
            2 - Lista libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idiomas


            0 - Salir
            """;

    public Principal(LibroRepository libroRepository,AutorRepository autorRepository){
    this.libroRepository = libroRepository;
    this.autorRepository = autorRepository;
    }
    public Principal(AutorRepository autorRepository,LibroRepository libroRepository) {

    }

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    verLibrosBuscados();
                    break;
                case 3:
                    verAutoresRegistrados();
                    break;
                case 4:
                    verAutoresEnAnnoN();
                    break;
                case 5:
                    verLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Valor incorrecto, seleccione algo del menu.");
                    break;
            }
        }
    }

    private void buscarLibroPorTitulo() {

        List<Libro> libros = consultaLibroTitulo();
        Libro libro = libros.get(0);
        System.out.println(libro);
        libroRepository.save(libro);
        // System.out.println(libroSubir);
        // libroRepository.save(libroSubir);

        // libroRepository.save(libroSubir);

        // System.out.println("Ingresa el litulo del libro a buscar");
        // String libro = teclado.nextLine();
        // System.out.println(libro);
        // var respuesta = consultaApi.obtenerDatos(URL_BASE + SEACH + libro.replace("
        // ", "%20"));
        // System.out.println(respuesta);
    }

    private void verLibrosBuscados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verLibrosBuscados'");
    }

    private void verAutoresRegistrados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verAutoresRegistrados'");
    }

    private void verAutoresEnAnnoN() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verAutoresEnAnnoN'");
    }

    private void verLibrosPorIdioma() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verLibrosPorIdioma'");
    }

    public List<Libro> consultaLibroTitulo() {
        System.out.println("Ingresa el titulo a buscar: ");
        var libro = teclado.nextLine().replace(" ", "%20");
        var json = consultaApi.obtenerDatos(URL_BASE + SEACH + libro);
        DatosResponse respuesta = convierteDatos.obtenerDatos(json, DatosResponse.class);
        // System.out.println(json);
        // List<DatosLibro> datosLibros = respuesta.datosLibros();

        return respuesta.datosLibros().stream()
                .map(e -> new Libro(e))
                .collect(Collectors.toList());
        // return null;
    }
}
