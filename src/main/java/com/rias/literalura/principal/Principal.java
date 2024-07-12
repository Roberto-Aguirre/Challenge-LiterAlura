package com.rias.literalura.principal;

//#region Liter-Alura
// import java.util.List;
// import java.util.Scanner;

// import com.rias.literalura.modelos.Autor;
// import com.rias.literalura.modelos.Libro;
// import com.rias.literalura.modelos.dto.DatosAutor;
// import com.rias.literalura.modelos.dto.DatosLibros;
// import com.rias.literalura.modelos.dto.DatosResponse;
// import com.rias.literalura.repository.AutorRepository;
// import com.rias.literalura.repository.LibroRepository;
// import com.rias.literalura.service.ConvierteDatos;
// import com.rias.literalura.service.ServiceConsultaApi;

// public class Principal {
//     private static final String URL_BASE = "https://gutendex.com/books/?search=";
//     private ServiceConsultaApi consumoAPI = new ServiceConsultaApi();
//     private ConvierteDatos convierteDatos = new ConvierteDatos();
//     private Scanner teclado = new Scanner(System.in);
//     private LibroRepository libroRepository;
//     private AutorRepository autorRepository;
//     private List<Libro> libros;
//     private List<Autor> autores;
//     private List<String> idiomas;


//     public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
//         this.libroRepository = libroRepository;
//         this.autorRepository = autorRepository;
//     }

//     public void muestraElMenu() {
//         int opcion = 1;
//         while (opcion != 0) {
//             var menu = """
//                     ---------------------------------------------
//                     1. Agregar libro
//                     2. Lista de libros registrados
//                     3. Lista de autores registrados
//                     4. Lista de autores vivos en un determinado año
//                     5. Lista libros por idioma
//                     0- Salir
//                     ---------------------------------------------
//                     Selecciona una opcion para continuar
//                     """;
//             System.out.println(menu);
//             if (teclado.hasNextInt()) {
//                 opcion = teclado.nextInt();
//                 teclado.nextLine();

//                 switch (opcion) {
//                     case 1:
//                         buscarLibro();
//                         break;
//                     case 2:
//                         listaLibrosRegistrados();
//                         break;
//                     case 3:
//                         listaAutoresRegistrados();
//                         break;
//                     case 4:
//                         listaAutoresVivos();
//                         break;
//                     case 5:
//                         listaLibrosPorIdioma();
//                         break;
//                     case 0:
//                         System.out.println("Cerrando la aplicacion");
//                         break;
//                     default:
//                         System.out.println("Opcion no valida");
//                 }
//             } else {
//                 System.out.println("Opción no válida");
//                 teclado.next();
//             }
//         }
//     }

//     private void buscarLibro(){
//         System.out.println("Ingrese el nombre del libro que desea agregar:");
//         var tituloLibro = teclado.nextLine();
//         var json = consumoAPI.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "%20"));
//         System.out.println(json);
//         guardarDatos(json);
//     }

//     private void guardarDatos(String json) {
//         try {
//             DatosResponse datosResponse = convierteDatos.obtenerDatos(json, DatosResponse.class);
//             DatosLibros datosLibro = datosResponse.datosLibros().get(0);
//             DatosAutor datosAutor = datosResponse.datosLibros().get(0).autores().get(0);
//             System.out.println(datosResponse);
//             System.out.println(datosAutor);
//             System.out.println(datosLibro);
//             //Verifica si el autor ya existe
//             Autor autor = autorRepository.findByNombre(datosAutor.nombre())
//                     .orElseGet(() -> autorRepository.save(new Autor(datosAutor)));
//             //Verifica si el libro ya existe
//             if (libroRepository.findByTitulo(datosLibro.titulo()).isEmpty()) {
//                 Libro libro = new Libro(datosLibro);
//                 libro.setAutor(autor);
//                 libroRepository.save(libro);
//                 System.out.println(libro);
//                 System.out.println("Libro agregado con exito");

//             }else {
//                 System.out.printf("---------------------------------------------\n");
//                 System.out.println("El libro ya se encuntra registrado");
//             }
//         }catch (NullPointerException e) {
//             System.out.printf("---------------------------------------------\n");
//             System.out.println("Libro no encontrado");
//         }
//     }

//     private void listaLibrosRegistrados() {
//         libros = libroRepository.findAll();
//         libros.stream().forEach(System.out::println);
//     }

//     private void listaAutoresRegistrados() {
//         autores = autorRepository.findAll();
//         autores.stream().forEach(System.out::println);
//     }

//     private void listaAutoresVivos() {
//         // System.out.println("Indica el año limite: ");
//         // int fecha = teclado.nextInt();
//         // autores = autorRepository.autoresPorFechaDeMuerte(fecha);
//         // autores.stream().forEach(System.out::println);
//     }

//     public void listaLibrosPorIdioma() {
//     //     idiomas = libroRepository.idiomasLibros();
//     //     System.out.printf("------------------IDIOMAS--------------------\n");
//     //     idiomas.stream().forEach(System.out::println);
//     //     System.out.printf("---------------------------------------------\n");
//     //     System.out.println("Ingresa el idioma por el que deseas buscar: ");
//     //     var idiomaSeleccionado = teclado.nextLine().toLowerCase();
//     //     libros = libroRepository.librosPoridioma(idiomaSeleccionado);
//     //     if (libros.isEmpty()) {
//     //         System.out.println("Opcion no valida");
//     //     }else {
//     //         libros.stream().forEach(System.out::println);
//     //     }
//     }
// }
//#endregion Liter-Alura

import com.rias.literalura.modelos.Libro;
import com.rias.literalura.modelos.dto.DatosAutor;
import com.rias.literalura.modelos.dto.DatosLibros;
import com.rias.literalura.modelos.dto.DatosResponse;
import com.rias.literalura.repository.AutorRepository;
import com.rias.literalura.repository.LibroRepository;

import java.util.List;
import java.util.Scanner;

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
    private List<Libro> libros;
    private List<Autor> autores;

    private String menu = """
            \n1 - Buscar libro por titulo
            2 - Lista libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idiomas


            0 - Salir
            """;
    private String idiomas = """
            Elige un idioma para filtrar los libros
            es-spañol
            en-Ingles
            fr-Frances
            pt-Portugues

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

        DatosResponse datos = convierteDatos.obtenerDatos(consultaLibroTitulo(), DatosResponse.class);
        try {
            DatosLibros datosLibro = datos.datosLibros().get(0);
            DatosAutor datosAutor = datos.datosLibros().get(0).autores().get(0);
            Autor autor = autorRepository.findByNombre(datosAutor.nombre()).orElseGet(() -> autorRepository.save(new Autor(datosAutor)));
            if (libroRepository.findByTitulo(datosLibro.titulo()).isEmpty()) {
                Libro libro = new Libro(datosLibro);
                libro.setAutor(autor);
                libroRepository.save(libro);
                System.out.println("Datos libro:\n"+libro);
                System.out.println("Libro guardado en base de datos");

            }else {
                System.out.println("==================================\n"+"El libro ya se encuntra registrado"+"\n==================================");
            }
        }catch (NullPointerException e) {
            System.out.printf("");
            System.out.println("===================\n"+"Libro no encontrado"+"\n===================");
        }
        
    }

    private void verLibrosBuscados() {
        List<Libro> librosBuscados = libroRepository.findAll();
        librosBuscados.stream()
        .forEach(e->System.out.println(e.toString()));
    }

    private void verAutoresRegistrados() {
        autorRepository.findAll().stream()
        .forEach(a->System.out.println(a));
    }

    private void verAutoresEnAnnoN() {
    //    System.out.println("Ingresa el año de nacimiento");
    //    int inicio = teclado.nextInt();
    //    System.out.println("Ingresa el año de nacimiento");
    //    int fin = teclado.nextInt();

    //    var autores = autorRepository.encontrarAutoresEntreFechas(inicio, fin);
    //    autores.stream().forEach(a->System.out.println(a));
    }

    private void verLibrosPorIdioma() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verLibrosPorIdioma'");
    }

    public String consultaLibroTitulo() {
        System.out.println("Ingresa el titulo a buscar: ");
        var libro = teclado.nextLine().replace(" ", "%20");
        var json = consultaApi.obtenerDatos(URL_BASE + SEACH + libro);
        // DatosResponse respuesta = convierteDatos.obtenerDatos(json, DatosResponse.class);
        // System.out.println(json);
        // List<DatosLibro> datosLibros = respuesta.datosLibros();

        return json;
        // return null;
    }
}
