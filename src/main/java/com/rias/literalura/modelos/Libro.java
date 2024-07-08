package com.rias.literalura.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity
// @Table(name = "libros")
public class Libro {    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column String titulo;
    private Autor autor;
    private String genero;
    private Lenguaje lenguaje;
    private Boolean copyright;
    private Long descargas;

}
