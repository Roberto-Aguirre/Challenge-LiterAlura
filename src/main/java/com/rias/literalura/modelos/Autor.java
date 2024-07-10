package com.rias.literalura.modelos;



// import jakarta.persistence.*;

// import java.util.List;

// import com.rias.literalura.modelos.dto.DatosAutor;




// @Entity
// @Table(name = "autores")
// public class Autor {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique = true)
//     private String nombre;
//     private Integer fecha_nacimiento;
//     private Integer fecha_deceso;
//     @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//     private List<Libro> libro;

//     public Autor(){}

//     public Autor(DatosAutor datosAutor){
//         this.nombre=datosAutor.nombre();
//         this.fecha_nacimiento = datosAutor.annoNacimiento();
//         this.fecha_deceso = datosAutor.annoMuerte();
//     }

//     @Override
//     public String toString() {
//         StringBuilder librosStr = new StringBuilder();
//         librosStr.append("Libros: ");

//         for(int i = 0; i < libro.size() ; i++) {
//             librosStr.append(libro.get(i).getTitulo());
//             if (i < libro.size() - 1 ){
//                 librosStr.append(", ");
//             }
//         }
//         return String.format("********** Autor **********%nNombre:" +
//                 " %s%n%s%nFecha de Nacimiento: %s%nFecha de Deceso:" +
//                 " %s%n***************************%n",nombre,librosStr.toString(),fecha_nacimiento,fecha_deceso);
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getNombre() {
//         return nombre;
//     }

//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }

//     public Integer getFecha_nacimiento() {
//         return fecha_nacimiento;
//     }

//     public void setFecha_nacimiento(Integer fecha_nacimiento) {
//         this.fecha_nacimiento = fecha_nacimiento;
//     }

//     public Integer getFecha_deceso() {
//         return fecha_deceso;
//     }

//     public void setFecha_deceso(Integer fecha_deceso) {
//         this.fecha_deceso = fecha_deceso;
//     }

//     public List<Libro> getLibro() {
//         return libro;
//     }

//     public void setLibro(List<Libro> libro) {
//         this.libro = libro;
//     }
// }

import java.util.List;

import org.hibernate.mapping.ManyToOne;

import com.rias.literalura.modelos.dto.DatosAutor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer annoNacimiento;
    private Integer annoMuerte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.annoNacimiento = datosAutor.annoNacimiento();
        this.annoMuerte = datosAutor.annoMuerte();
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

    public Integer getAnnoNacimiento() {
        return annoNacimiento;
    }

    public void setAnnoNacimiento(Integer annoNacimiento) {
        this.annoNacimiento = annoNacimiento;
    }

    public Integer getAnnoMuerte() {
        return annoMuerte;
    }

    public void setAnnoMuerte(Integer annoMuerte) {
        this.annoMuerte = annoMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor [nombre=" + nombre + ", annoNacimiento=" + annoNacimiento + ", annoMuerte=" + annoMuerte + "]";
    }

}
