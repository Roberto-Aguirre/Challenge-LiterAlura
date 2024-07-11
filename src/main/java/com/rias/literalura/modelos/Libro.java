package com.rias.literalura.modelos;

import com.rias.literalura.modelos.dto.DatosLibro;

import jakarta.persistence.*;


@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String idiomas;
    private Integer descargas;
    // ! Linked Id

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Libro() {

    }

    public Libro(DatosLibro datosLibro) {
        this.nombre = datosLibro.nombre();
        this.idiomas = datosLibro.idiomas().get(0);
        this.descargas = datosLibro.descargas();
    }

    @Override
    public String toString() {
        String libro = """
                ============ Libro ============
                Titulo: %titulo
                Autor: %autor
                Idioma: %idioma
                Descargas totales: %descargas
                ===============================
                """;                
        libro = libro.replace("%titulo", this.getNombre());
        libro = libro.replace("%autor", this.getAutor().getNombre());
        switch (this.idiomas) {
            case "es":
            libro = libro.replace("%idioma", "Español");
                break;
            case "en":
            libro = libro.replace("%idioma", "Ingles");
                break;
            case "fr":
            libro = libro.replace("%idioma", "Frances");
                break;
            default:
            libro = libro.replace("%idioma", "Idioma desconocido");
                break;
        }

        libro = libro.replace("%descargas", String.valueOf(this.getDescargas()));
        return libro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
