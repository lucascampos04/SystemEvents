package com.eventos.eventos.Controller;

import com.eventos.eventos.Model.Convidado;
import com.eventos.eventos.Model.Evento;
import com.eventos.eventos.Repository.ConvidadoReposiroty;
import com.eventos.eventos.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoReposiroty cr;
    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "Evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento eventoModel){
        er.save(eventoModel);
        return "redirect:cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");

        // Buscando eventos
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("id") long id){
        Evento evento = er.findById(id);
        ModelAndView mv = new ModelAndView("Evento/detalhesEvento");
        mv.addObject("evento", evento);
        System.out.println("Evento : " + id);
        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String detalhesEvento(@PathVariable("id") long id, Convidado convidado){
        Evento evento = er.findById(id);
        convidado.setEvento(evento);
        cr.save(convidado);
        return "redirect:/{id}";
    }



}
