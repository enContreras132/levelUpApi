package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.security.JwtFilter;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("null")
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        // 1. VERIFICAR SI LLEGA EL HEADER
        System.out.println(" INTENTO DE ACCESO A: " + request.getRequestURI());
        System.out.println("    Header recibido: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            System.out.println("    Token extraído (primeros 10 caracteres): " + (token.length() > 10 ? token.substring(0, 10) : token));
            try {
                username = jwtService.extractUsername(token);
                System.out.println("    Usuario encontrado en token: " + username);
            } catch (Exception e) {
                System.out.println("    ERROR AL LEER TOKEN: " + e.getMessage());
            }
        } else {
            System.out.println("    NO HAY TOKEN O NO EMPIEZA POR 'Bearer '"); 
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("    Validando token...");
            if (jwtService.validateToken(token, username)) {
                System.out.println("    TOKEN VÁLIDO. AUTORIZANDO USUARIO.");
                UserDetails userDetails = new User(username, "", new ArrayList<>());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("    TOKEN INVÁLIDO O EXPIRADO SEGÚN VALIDATE()");
            }
        }
        
        filterChain.doFilter(request, response);
    }
}
