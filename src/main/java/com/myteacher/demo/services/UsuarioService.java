package com.myteacher.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myteacher.demo.models.UsuarioModel;
import com.myteacher.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel registrarUsuario(UsuarioModel usuario){

        //Desarrollar logica para registrar usuario
        System.out.println(usuario);
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> login(String email, String password){
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);
        if(usuario.isPresent() && usuario.get().getPassword().equals(password)){
            return usuario;
        }else{
            return Optional.empty(); 
        }
        
    }
}
