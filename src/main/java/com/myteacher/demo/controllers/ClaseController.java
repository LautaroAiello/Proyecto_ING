package com.myteacher.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myteacher.demo.models.ClaseModel;
import com.myteacher.demo.services.ClaseService;


//Modelo: Define las tablas de la base de datos (entidades).
// Repositorios: Proveen acceso a la base de datos.
// Servicios: Contienen la lógica de negocio (registrar usuarios, agendar clases, etc.).
// Controladores: Manejan las peticiones HTTP (registro, login, agendar clases, etc.).

// ResponseEntity en Spring representa la respuesta HTTP completa, incluyendo el código de estado (status code), los encabezados (headers) y el cuerpo (body) de la respuesta.
// ResponseEntity.ok() es un método rápido que te ayuda a devolver una respuesta con el estado HTTP 200 OK de manera directa.
/* @PathVariable es una anotación en Spring que se utiliza para extraer datos de la URL de una solicitud HTTP y pasarlos como argumentos a un método en un controlador. 
Básicamente, toma una parte de la ruta de la URL y la asigna a una variable en el método. Indica que el valor de {id} en la URL sera extraido y pasado como argumento al método.*/

@RestController
@RequestMapping("/clases")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @PostMapping("/agendar")
    public ResponseEntity<ClaseModel> agendarClase(@RequestBody ClaseModel clase){
        ClaseModel nuevaClase = claseService.agendarClase(clase);
        return ResponseEntity.ok(nuevaClase);
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<ClaseModel>> obtenerClasesPorProfesor(@PathVariable Long id){
        return ResponseEntity.ok(claseService.obtenerClasesPorProfesor(id));
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<ClaseModel>> obtenerClasesPorAlumno(@PathVariable Long id){
        return ResponseEntity.ok(claseService.obtenerClasesPorAlumno(id));
    }



}
