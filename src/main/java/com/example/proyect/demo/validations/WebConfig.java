package com.example.proyect.demo.validations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**") // Esto permite CORS para todos los endpoints
                .allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500/index.html", "http://127.0.0.1:5500") // Aquí coloca el origen de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*")
                .allowCredentials(true); // Permitir cookies o autenticación basada en sesiones
    }
}