package com.eventos.eventos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Convidado {
    @Id
    private String rg;
    private String nomeConvidado;
    @ManyToOne
    private Evento evento;

}
