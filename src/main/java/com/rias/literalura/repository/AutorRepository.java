package com.rias.literalura.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rias.literalura.modelos.Autor;
import java.util.List;


public interface AutorRepository extends JpaRepository<Autor,Long>{

}
