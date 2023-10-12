package com.eventos.eventos.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
    @OneToMany
    private List<Convidado> convidados;

}
