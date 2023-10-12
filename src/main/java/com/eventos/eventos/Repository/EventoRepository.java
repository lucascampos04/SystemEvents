package com.eventos.eventos.Repository;

import com.eventos.eventos.Model.EventoModel;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<EventoModel, String> {
}
