package com.example.demo.Controller;

import com.example.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class AuthController {

    @Autowired
    private JwtService jwtService;

    // LOGIN SIMULADO (Para probar rápido)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credenciales) {
        String usuario = credenciales.get("username");
        String password = credenciales.get("password");

        // AQUÍ deberías verificar con tu Base de Datos si el usuario y pass son correctos.
        // Por ahora, simularemos que solo "admin" con clave "1234" puede entrar.
        if ("admin".equals(usuario) && "1234".equals(password)) {
            String token = jwtService.generateToken(usuario);
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
