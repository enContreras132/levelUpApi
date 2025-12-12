package com.example.demo.Controller;

import com.example.demo.Model.AdminModel;
import com.example.demo.Model.ClienteModel;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.ClienteRepository;
import com.example.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})

public class AuthController {

    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;

    // LOGIN REAL CON BASE DE DATOS
    @PostMapping({"/login", "/usuario/login"})
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("username");
        String password = credenciales.get("password");
        
        // DEBUG: Ver qué está recibiendo
        System.out.println("=== LOGIN ATTEMPT ===");
        System.out.println("Correo recibido: [" + correo + "]");
        System.out.println("Password recibido: [" + password + "]");

        // Buscar primero en la tabla de administradores
        System.out.println("Buscando en admins...");
        Optional<AdminModel> admin = adminRepository.findAll().stream()
            .peek(a -> System.out.println("Admin en BD: correo=[" + a.getCorreo() + "] pass=[" + a.getContraseña() + "]"))
            .filter(a -> a.getCorreo().equals(correo) && a.getContraseña().equals(password))
            .findFirst();
        
        if (admin.isPresent()) {
            AdminModel adminData = admin.get();
            String token = jwtService.generateToken(adminData.getCorreo(), adminData.getRol());
            return ResponseEntity.ok(Map.of(
                "token", token,
                "rol", adminData.getRol(),
                "nombre", adminData.getNombre(),
                "id", adminData.getId()
            ));
        }

        // Si no es admin, buscar en clientes
        System.out.println("Buscando en clientes...");
        Optional<ClienteModel> cliente = clienteRepository.findAll().stream()
            .peek(c -> System.out.println("Cliente en BD: correo=[" + c.getCorreo() + "] pass=[" + c.getContraseña() + "]"))
            .filter(c -> c.getCorreo().equals(correo) && c.getContraseña().equals(password))
            .findFirst();
        
        if (cliente.isPresent()) {
            ClienteModel clienteData = cliente.get();
            String token = jwtService.generateToken(clienteData.getCorreo(), clienteData.getRol());
            return ResponseEntity.ok(Map.of(
                "token", token,
                "rol", clienteData.getRol(),
                "nombre", clienteData.getNombre(),
                "id", clienteData.getId()
            ));
        }

        // Credenciales inválidas
        System.out.println("Login fallido - credenciales no encontradas");
        return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
    }
}
