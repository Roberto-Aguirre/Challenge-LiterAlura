package com.rias.literalura.modelos;

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


@Entity(name = "autor")
@Table(name = "AUTORES")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private int annoNacimiento;
    private int annoMuerte;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.annoNacimiento = Integer.parseInt(datosAutor.annoNacimiento());
        this.annoMuerte = Integer.parseInt(datosAutor.annoMuerte());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnnoNacimiento() {
        return annoNacimiento;
    }

    public void setAnnoNacimiento(int annoNacimiento) {
        this.annoNacimiento = annoNacimiento;
    }

    public int getAnnoMuerte() {
        return annoMuerte;
    }

    public void setAnnoMuerte(int annoMuerte) {
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
        return "Autor [nombre=" + nombre + ", annoNacimiento=" + annoNacimiento + ", annoMuerte=" + annoMuerte+"]";
    }

    
}
