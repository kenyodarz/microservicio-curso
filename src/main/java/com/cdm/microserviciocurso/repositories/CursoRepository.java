package com.cdm.microserviciocurso.repositories;

import com.cdm.microserviciocurso.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <Curso, Long> {

    @Query("select c from Curso c join fetch c.alumnos a where a.idAlumnos=?1")
    Curso findCursoByAlumnoId(Long id);

}
