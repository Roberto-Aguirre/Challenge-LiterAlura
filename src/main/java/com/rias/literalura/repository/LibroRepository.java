package com.rias.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rias.literalura.modelos.Libro;



public interface LibroRepository extends JpaRepository<Libro,Long>{
    
    // @Query("SELECT a FROM Libro l WHERE a.id = :id")
    // List<Libro> obtenerLibroDeAutor(int id);
    
    // @Query(value="SELECT * FROM Libros WHERE totaltemporadas <= 2 AND evaluacion >= 7",nativeQuery = true)
    // @Query("SELECT s FROM Libro s WHERE s.totaltemporadas <= :temporadas AND s.evaluacion >= :evaluacion")
    // List<Libro> LibrosPorTemporadasYEvaluacion();

}
