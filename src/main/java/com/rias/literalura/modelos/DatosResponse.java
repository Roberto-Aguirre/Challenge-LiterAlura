package com.rias.literalura.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResponse(
    @JsonAlias("results")List<DatosLibro> datosLibros 

) {

}
