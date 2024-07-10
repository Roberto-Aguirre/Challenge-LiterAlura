package com.rias.literalura.modelos.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
@JsonAlias("name")String nombre,
@JsonAlias("birth_year")String annoNacimiento,
@JsonAlias("death_year")String annoMuerte) {

}
