package com.rias.literalura.principal;

import java.util.List;
import java.util.Scanner;

import com.rias.literalura.service.ServiceConsultaApi;

public class Principal {    
    private static ServiceConsultaApi consultaApi = new ServiceConsultaApi();
    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";
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
        while (opcion!=0) {

            switch (opcion) {
                case 1:
                    
                break;
            
                case 2:
                    
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                case 5:
                    
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

    public  void consultaApiLibros(){
        var respuesta = consultaApi.obtenerDatos(URL_BASE);
        System.out.println(respuesta);
    }
}
