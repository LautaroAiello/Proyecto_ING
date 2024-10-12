package com.myteacher.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myteacher.demo.models.ClaseModel;
import com.myteacher.demo.repositories.ClaseRepository;

@Service
public class ClaseService {
    @Autowired // inyecta automaticamente una instancia de ClaseRepository cuando cree el objeto ClaseService
    private ClaseRepository claseRepository;

    public ClaseModel agendarClase(ClaseModel clase){
        return claseRepository.save(clase);
    }

    public List<ClaseModel> obtenerClasesPorProfesor(Long profesorId){
        return claseRepository.findByProfesorId(profesorId);  
    }

    public List<ClaseModel> obtenerClasesPorAlumno(Long alumnoId){
        return claseRepository.findByAlumnoId(alumnoId);
    }
}
