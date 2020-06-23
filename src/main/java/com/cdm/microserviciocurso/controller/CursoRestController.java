package com.cdm.microserviciocurso.controller;

import com.cdm.microserviciocurso.models.Alumno;
import com.cdm.microserviciocurso.models.Curso;
import com.cdm.microserviciocurso.services.CursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoRestController {

    @Autowired
    private CursoServiceAPI serviceApi;

    @GetMapping
    public List<Curso> getAll(){
        return serviceApi.getAll();
    }

    @GetMapping("/{id}")
    public Curso find(@PathVariable Long id){
        return serviceApi.get(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Curso> save (@RequestBody Curso requestBody){
        Curso obj = serviceApi.save(requestBody);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity <Curso> delete (@PathVariable Long id){
        Curso obj = serviceApi.get(id);
        if (obj != null){
            serviceApi.delete(id);
        }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumnos(
            @RequestBody List<Alumno> alumnos,
            @PathVariable Long id
    ){
        Curso curso = serviceApi.get(id);
        if (curso == null){
            return ResponseEntity.notFound().build();
        }

        alumnos.forEach(curso::addAlumno);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.serviceApi.save(curso));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(
            @RequestBody Alumno alumno,
            @PathVariable Long id
    ){
        Curso curso = serviceApi.get(id);
        if (curso == null){
            return ResponseEntity.notFound().build();
        }

        curso.removeAlumno(alumno);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.serviceApi.save(curso));
    }

}
