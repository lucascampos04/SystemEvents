package com.eventos.eventos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Evento implements Serializable {

    private static final long serialVersionUIDLONG = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String nome;
    private String local;
    private String data;
    private String horario;

}
