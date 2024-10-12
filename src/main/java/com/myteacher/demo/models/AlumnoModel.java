package com.myteacher.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class AlumnoModel extends UsuarioModel{
    @OneToMany(mappedBy = "alumno")
    private List<ClaseModel> clases;
}
