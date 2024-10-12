package com.myteacher.demo.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myteacher.demo.models.UsuarioModel;
import com.myteacher.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //ResponseEntity es una clase que permite construir una respuesta HTTP completa.
    @PostMapping("/registro") //maneja las solicitudes HTTP POST en la ruta
    public ResponseEntity<UsuarioModel> registrarUsuario(@RequestBody UsuarioModel usuario){
        UsuarioModel nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioModel> login(@RequestBody Map<String, String> credenciales){ //las claves son los nombres de los campos y los valores son las credenciales.
        Optional<UsuarioModel> usuario = usuarioService.login(credenciales.get("email"), credenciales.get("password"));
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            //nueva instancia de ResponseEntity con el estado 401 (No autorizado) y sin cuerpo.
        }
        
        
        
        
            
    }
    
}
