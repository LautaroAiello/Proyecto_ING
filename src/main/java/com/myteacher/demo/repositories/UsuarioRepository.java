package com.myteacher.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myteacher.demo.models.UsuarioModel;

// @Repository marca la clase como un repositorio que manejará las operaciones de persistencia y las consultas a la base de datos.
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email); //metodo personalizado que busca usuario por su email. Puede ser un valor o null.
}


/*JpaRepository<T, ID>:
Es una interfaz proporcionada por Spring Data JPA, que proporciona métodos predefinidos para realizar operaciones comunes en la base de datos, como guardar, actualizar, eliminar y buscar datos.
T: Es el tipo de entidad con el que trabajarás. En este caso, UsuarioModel es la clase que representa la entidad "Usuario" que deseas persistir en la base de datos.
ID: Es el tipo de la clave primaria (Primary Key) de la entidad. En este caso, es Long porque la clave primaria de UsuarioModel es un Long. */