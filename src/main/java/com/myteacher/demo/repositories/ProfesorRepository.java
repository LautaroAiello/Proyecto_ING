package com.myteacher.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myteacher.demo.models.ProfesorModel;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorModel, Long>{
    List<ProfesorModel> findByMateria(String materia);
    List<ProfesorModel> findByOrderByValoracionDesc(); // Desarrollar

}
