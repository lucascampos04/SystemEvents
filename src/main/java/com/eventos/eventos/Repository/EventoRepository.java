package com.eventos.eventos.Repository;

import com.eventos.eventos.Model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, String> {
    Evento findById(long id);
}
