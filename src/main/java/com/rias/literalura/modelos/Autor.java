package com.rias.literalura.modelos;

import java.util.List;

import org.springframework.data.annotation.Transient;

import com.rias.literalura.modelos.dto.DatosAutor;
import com.rias.literalura.repository.AutorRepository;

import jakarta.persistence.*;

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
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    // @Transient
    // private AutorRepository autorRepository;

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
        String autor = """
            _______________________________
            !!!!!!!!!! Autores !!!!!!!!!!!!
            Autor: %autor
            Año nacimiento: %annoNacimiento
            Año fallecimiento: %annoFallecimiento
            Libros escritor: %libros
            """;
            String libros = "";
            this.getLibros().forEach(l->System.out.println(l.getNombre()));
            System.out.println(libros);
            
            String footer =  "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";

            autor = autor.replace("%autor", this.nombre);

            if (this.annoNacimiento!=0) {
                autor = autor.replace("%annoNacimiento", String.valueOf(this.annoNacimiento) );
            }else{
                autor = autor.replace("%annoNacimiento", "Fecha desconocida" );
            }
            if (this.annoMuerte!=0) {
                autor = autor.replace("%annoFallecimiento", String.valueOf(this.annoMuerte));   
            }else{
                autor = autor.replace("%annoFallecimiento", "Fecha desconocida");   
            }
            // autor = autor.replace("%libros", libros);   
            
            
    return autor;
    }

}
