// package com.rias.literalura.modelos;



// import com.rias.literalura.modelos.dto.DatosLibro;

// import jakarta.persistence.*;


// @Entity
// @Table(name = "libros")
// public class Libro {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long Id;
//     private String titulo;
//     @ManyToOne
//     private Autor autor;
//     private String lenguaje;
//     private Integer numero_descargas;

//     public Libro(){}

//     public Libro(DatosLibro datosLibro){
//         this.titulo = datosLibro.nombre();
//         this.lenguaje = datosLibro.idiomas().get(0);
//         this.numero_descargas = datosLibro.descargas();
//     }

//     @Override
//     public String toString() {
//         String nombreAutor = (autor != null) ? autor.getNombre() : "Autor desconocido";
//         return String.format("********** Libro **********%nTitulo:" +
//                 " %s%nAutor: %s%nIdioma: %s%nNumero de Descargar:" +
//                 " %d%n***************************%n",titulo,nombreAutor,lenguaje,numero_descargas);
//     }

//     public Long getId() {
//         return Id;
//     }

//     public void setId(Long id) {
//         Id = id;
//     }

//     public String getTitulo() {
//         return titulo;
//     }

//     public void setTitulo(String titulo) {
//         this.titulo = titulo;
//     }

//     public Autor getAutor() {
//         return autor;
//     }

//     public void setAutor(Autor autor) {
//         this.autor = autor;
//     }

//     public String getLenguaje() {
//         return lenguaje;
//     }

//     public void setLenguaje(String lenguaje) {
//         this.lenguaje = lenguaje;
//     }

//     public Integer getNumero_descargas() {
//         return numero_descargas;
//     }

//     public void setNumero_descargas(Integer numero_descargas) {
//         this.numero_descargas = numero_descargas;
//     }
// }
package com.rias.literalura.modelos;

import com.rias.literalura.modelos.dto.DatosLibro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String idiomas;
    private Integer descargas;
    //! Linked Id

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;
    
   public Libro(){
    
   }

    public Libro(DatosLibro datosLibro) {
        this.nombre = datosLibro.nombre();
        this.idiomas = datosLibro.idiomas().get(0);
        this.descargas = datosLibro.descargas();
    }
    
    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", idiomas=" + idiomas
                + ", descargas=" + descargas + ", autor=" + autor + "]";
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
