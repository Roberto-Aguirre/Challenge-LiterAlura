package com.rias.literalura.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro( @JsonAlias("id") Integer id,
@JsonAlias("title") String nombre,
@JsonAlias("authors") List<DatosAutor> autores,
@JsonAlias("subjects") List<String> categorias,
@JsonAlias("languages") List<String> idiomas,
@JsonAlias("copyright") Boolean derechos,
@JsonAlias("download_count") Long descargas
) {
   
}
