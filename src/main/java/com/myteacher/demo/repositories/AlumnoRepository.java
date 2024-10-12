package com.myteacher.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myteacher.demo.models.AlumnoModel;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Long>{
    
}
