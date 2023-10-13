package com.eventos.eventos.Repository;

import com.eventos.eventos.Model.Convidado;
import com.eventos.eventos.Model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoReposiroty extends CrudRepository<Convidado, String>{
    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);
}
