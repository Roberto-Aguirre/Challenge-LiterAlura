
# AluraLatam-Literalura

Una pequeña introducción a los componentes y al uso del proyecto desarrollado.

## Proposito

Se busca mediante este proyecto el desarrollar habilidad como son consultas a un API REST como es Gutendex, trasnformar los datos mediantes un modelo de capas, añadir los datos consultados a una base de datos utilizando PostgreSQL y hacer consultas a los datos localmente.

## Referencia de la API (https://gutendex.com) utilizada.

#### Traer referencias a una moneda a consultar

```http
  GET https://gutendex.com/books
```

| Parametro | Tipo     | Descripcion                |
| :-------- | :------- | :------------------------- |
| `search` | `String` | **Requerido**. Parametro de navegador |
| `titulo` | `String` | **Requerido**. Nombre del libro a consultar|
| `%20` | `String` | **Requerido**. Señaliza los espacios|

**Ejemplo**

```http
  GET https://gutendex.com/books?search=romeo%20and%20juliet
```
## Caracteristicas

- Consulta HTTP a endpoint.
- Guardado de datos de libros.
- Guardado de datos de autores.
- Consulta a datos guardados **(Autores y libros)**

## Copiar repositorio
Si se quiere probar el programa realizado es necesario tener git instalado en nuestra computadora y ejecutar el siguiente comando en el cmd o linea de comandos. Esto para la seleccion de la rama predeterminada main.

```cmd
  git clone https://github.com/Roberto-Aguirre/Challenge-LiterAlura
```
    
Una vez terminado, estara listo para usarse.
## Requisitos previos

Se utilizan los siguientes variables de entorno

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `DB_USER` | `String` | **Requerido**. Usuario creado (postgres) |
| `DB_PASSWORD` | `String` | **Requerido**. Contraseña para entrar|
| `DB_HOST` | `String` | **Requerido**. Host de la db (localhost)|
| `DB_DATABASE` | `String` | **Requerido**. Base de datos (literalura)|

Una vez hecho esto podemos utilizar la aplicacion correctamente.

## Uso 

- **Es necesario instalar las dependencias primarias como Java (JDK 22 y JRE 1.8)**
- Se sugiere el uso de Visual Studio Code con la extension de **Language Support for Java(TM) by Red Hat** proporcionada por Red Hat.

**Se abrira el proyecto y ejecutaremos el archivo LiteraluraApplication.java, en el paquete de principal.**

Una vez abierto se mostrara el siguiente texto.
```Java
----------------------------------------------
Literalura realizado por Roberto Aguirre

1 - Buscar libro por titulo
2 - Lista libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idiomas


0 - Salir
----------------------------------------------
```
 Aquí seremos libres de proporcionar en la linea de comandos la opcion que queramos consultar y ejecutar.

* Ejemplo. Ejecutaremos el valor **1** para una prueba.

Se mostrarar el siguiente texto y tendremos que rellenar nuestro numero
```Java
Ingresa el titulo a buscar: 
> 
```
En caso de encontrar una coincidencia arrojara el siguiente mensaje generado.
```Java
__________________________________
========== Libros ===============
Titulo: Law and Laughter
Autor: Malloch, D. Macleod (Donald Macleod)
Idioma: en
Descargas: 371.0
°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
Libro guardado en base de datos

```
**Caso no encontro coincidencia en Base de datos**

En caso de encontrar una coincidencia en la base de datos y detectar que ya fue guardado anteriormente saltara lo siguiente
```Java
==================================
El libro ya se encuntra registrado
==================================
```
**Caso no encontro libro**

Despues de esto realizara una busqueda en caso de no encontrar alguna coincidencia.
Arrojara el siguiente texto.
```Java
===================
Libro no encontrado
===================
```


## Limitaciones

* Solo es capaz de realizar 5 operaciones.

* Al teclear en el programa algun valor incorrecto o inesperado el programa terminara.


## Autor

- [@Roberto-Aguirre](https://www.github.com/Roberto-Aguirre)
