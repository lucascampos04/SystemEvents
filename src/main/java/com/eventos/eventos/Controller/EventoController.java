package com.eventos.eventos.Controller;

import com.eventos.eventos.Model.Convidado;
import com.eventos.eventos.Model.Evento;
import com.eventos.eventos.Repository.ConvidadoReposiroty;
import com.eventos.eventos.Repository.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String formPost(@Valid Evento evento, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/cadastrarEvento";
        }
        er.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso");
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");

        // Buscando eventos
        Iterable<Evento> evento = er.findAll();
        mv.addObject("eventos", evento);
        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("id") long id){
        Evento evento = er.findById(id);
        ModelAndView mv = new ModelAndView("Evento/detalhesEvento");
        mv.addObject("evento", evento);

        System.out.println("Evento : " + id);

        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);

        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("id") long id,
                                     @Valid Convidado convidado,
                                     BindingResult result,
                                     RedirectAttributes attributes,
                                     Model model){
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Erro: Verifique os campos");
            System.out.println("If foi");
        }
        else {
            attributes.addFlashAttribute("mensagem", "Sucesso: Convidado adicionado com sucesso");
            System.out.println("If não foi");
        }
        Evento evento = er.findById(id);
        convidado.setEvento(evento);
        cr.save(convidado);
        return "redirect:/" + id;
    }
}
