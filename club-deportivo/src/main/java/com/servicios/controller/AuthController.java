package com.servicios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club-deportivo/api")
public class AuthController {

    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestParam String usuario,
                                           @RequestParam String contrasena) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado correctamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String usuario,
                                        @RequestParam String contrasena) {

        if ("oscar".equals(usuario) && "12345".equals(contrasena)) {
            return ResponseEntity.ok("autenticación satisfactoria");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("error en la autenticación");
        }
    }
}