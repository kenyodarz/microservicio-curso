package com.cdm.microserviciocurso.controller;

import com.cdm.microserviciocurso.models.Curso;
import com.cdm.microserviciocurso.services.CursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
