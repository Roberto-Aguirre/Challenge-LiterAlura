package com.rias.literalura.modelos;

import com.rias.literalura.modelos.dto.DatosLibro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity(name = "libros")
@Table(name = "LIBROS")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    String idiomas;
    Long descargas;
    //! Linked Id

    @ManyToOne
    @JoinColumn(name = "autor")
    Autor autor;
    
   public Libro(){
    
   }
    public Libro(DatosLibro datosLibro) {
        this.nombre = datosLibro.nombre();
        this.idiomas = datosLibro.idiomas().get(0);
        
        this.descargas = datosLibro.descargas();
        this.autor = new Autor(datosLibro.autores().get(0));
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

    public Long getDescargas() {
        return descargas;
    }
    public void setDescargas(Long descargas) {
        this.descargas = descargas;
    }
    
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", idiomas=" + idiomas
                + ", descargas=" + descargas + ", autor=" + autor + "]";
    }


}
