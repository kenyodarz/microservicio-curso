package com.cdm.microserviciocurso.services;

import com.cdm.microserviciocurso.models.Curso;
import com.cdm.microserviciocurso.repositories.CursoRepository;
import com.cdm.microserviciocurso.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Long> implements CursoServiceAPI {

    @Autowired
    private CursoRepository repository;

    @Override
    public CrudRepository<Curso, Long> getRepository() {
        return repository;
    }
}
