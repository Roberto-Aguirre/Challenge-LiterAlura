package com.rias.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.rias.literalura.modelos.Libro;

public class LibroRepository extends JpaRepository<Libro,Long>{
    // @Query(value="SELECT * FROM Libros WHERE totaltemporadas <= 2 AND evaluacion >= 7",nativeQuery = true)
    // @Query("SELECT s FROM Libro s WHERE s.totaltemporadas <= :temporadas AND s.evaluacion >= :evaluacion")
    // List<Libro> LibrosPorTemporadasYEvaluacion();

}
