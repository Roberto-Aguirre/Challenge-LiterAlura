package com.rias.literalura.principal;

import java.util.List;
import java.util.Scanner;

import com.rias.literalura.modelos.Libro;
import com.rias.literalura.modelos.DatosResponse;
import com.rias.literalura.service.ConvierteDatos;
import com.rias.literalura.service.ServiceConsultaApi;

public class Principal {
    private static ServiceConsultaApi consultaApi = new ServiceConsultaApi();
    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String SEACH = "?search=";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    // private List<Libros> libros;
    private String menu = """
            \n1 - Buscar libro por titulo
            2 - Lista libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idiomas


            0 - Salir
            """;

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                consultaLibroTitulo();
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
        consultaLibroTitulo();
        // System.out.println("Ingresa el litulo del libro a buscar");
        // String libro = teclado.nextLine();
        // System.out.println(libro);
        // var respuesta = consultaApi.obtenerDatos(URL_BASE + SEACH + libro.replace(" ", "%20"));
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
    var json = consultaApi.obtenerDatos(URL_BASE+SEACH+libro);
    System.out.println(json);
    DatosResponse respuesta = convierteDatos.obtenerDatos(json, DatosResponse.class);

    respuesta.datosLibros().stream()
    .forEach(e->new Libro(e));
    
    
    return null;
    }
}
