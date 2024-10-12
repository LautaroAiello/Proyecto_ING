package com.myteacher.demo.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/* @JoinColumn se encarga de especificar los nombres de las columnas que almacenarán las claves foráneas, 
vinculando las tablas profesor y alumno con la tabla clase en la base de datos. */
@Entity
@Table(name = "clase")
public class ClaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaHora; // fecha y hora de clase

    @Column(unique = true, nullable = false)
    private boolean esVirtual; // si la clase sera virtual o presencial

    // relacion de profesor con la clase
    @ManyToOne //muchas instancias de ClaseModel pueden estar relacionadas con una sola instancia de ProfesorModel.
    @JoinColumn(name = "profesor_id") /*define que la columna de la base de datos que almacena el ID del profesor en la tabla de clases se llamara profesor_id.
                                      Esto crea una clave foránea (foreign key) en la tabla de clases que referencia el id del profesor.*/
    private ProfesorModel profesor;

    // relacion de alumno con la clase
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private AlumnoModel alumno;

    public Long getId(){
        return this.id;
    }
    public void setId(Long i){
        this.id = i;
    }
    public LocalDateTime getFechaHora(){
        return this.fechaHora;
    }
    public void setFechaHora(LocalDateTime f){
        this.fechaHora = f;
    }
    public boolean getEsVirtual(){
        return this.esVirtual;
    }
    public void setEsVirtual(boolean k){
        this.esVirtual = k;
    }
}
