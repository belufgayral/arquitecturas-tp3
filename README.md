# TP3 Arquitecturas Web

Tome como punto de partida el ejercicio integrador del TP2

1) Considere el diseño de un registro de estudiantes, con la siguiente información: nombres,
   apellido, edad, género, número de documento, ciudad de residencia, número de libreta
   universitaria, carrera(s) en la que está inscripto, antigüedad en cada una de esas carreras, y
   si se graduó o no.

2) Implementar las consultas mediante servicios REST para:
   a) dar de alta un estudiante CHECK

   b) matricular un estudiante en una carrera

   c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.

   d) recuperar un estudiante, en base a su número de libreta universitaria.

   e) recuperar todos los estudiantes, en base a su género.

   f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.

   g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.

   h) generar un reporte de las carreras, que para cada carrera incluya información de los
   inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
   presentar los años de manera cronológica.

3) Testear la invocación a los servicios REST mediante Postman, o cliente similar.

## Endpoints para testeo

A. http://localhost:8080/alumnos

{
"nombre": "Pepito",
"apellido": "Fernándoez",
"fechaNacimiento": "2018-01-10",
"genero": "masculino",
"dni": 27689716,
"ciudad": "Olavarría",
"legajo": 1276372
}

B. http://localhost:8080/alumnos/matricular

{
"id_Alumno": 5,
"id_Carrera": 1,
"fechaInscripcion": 2021,
"fechaGraduacion": 2023
}

C. http://localhost:8080/alumnos

D. http://localhost:8080/alumnos/legajo/1234

E. http://localhost:8080/alumnos/genero/masculino

F. http://localhost:8080/carreras/inscriptos

G. http://localhost:8080/alumnos?carrera=tudai&ciudad=tandil

H. http://localhost:8080/carreras/reporte

## Autores:

####  Fernandez Gayral, Belen - belenfernandezgayral@gmail.com
#### Mengarelli Yespersen, Gaetano	- gmengarelliyespersen@alumnos.exa.unicen.edu.ar
#### Menchon, Agustin - amenchon@alumnos.exa.unicen.edu.ar
#### Martínez, Ezequiel - ezmartinez@alumnos.exa.unicen.edu.ar
