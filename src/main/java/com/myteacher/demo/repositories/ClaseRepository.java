package com.myteacher.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myteacher.demo.models.ClaseModel;

@Repository
public interface ClaseRepository extends JpaRepository<ClaseModel, Long>{
    List<ClaseModel> findByProfesorId(Long profesorId);
    List<ClaseModel> findByAlumnoId(Long alumnoId);
}
