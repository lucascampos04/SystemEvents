package com.eventos.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventosApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventosApplication.class, args);
        System.out.println("Servidor rodando");
    }

}