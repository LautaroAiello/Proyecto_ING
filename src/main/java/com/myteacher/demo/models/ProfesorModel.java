package com.myteacher.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "profesor")
public class ProfesorModel extends UsuarioModel{
    
    @Column(nullable = false)
    private String materia;

    @Column(nullable = false)
    private int valoracion;

    @Column()
    private int disponibilidad;

    @OneToMany(mappedBy = "profesor") // un profesor puede tener muchas clases (lista de clases)
    private List<ClaseModel> clases;

    public String getMateria(){
        return this.materia;
    }
    public void setMateria(String m){
        this.materia = m;
    }
    public int getValoracion(){
        return this.valoracion;
    }
    public void setValoracion(int v){
        this.valoracion = v;
    }
    public int getDisponibilidad(){
        return this.disponibilidad;
    }
    public void setDisponibilidad(int disponibilidad){
        this.disponibilidad = disponibilidad;
    }
}
