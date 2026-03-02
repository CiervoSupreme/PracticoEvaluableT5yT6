package org.example.reto4.web;

import org.example.reto4.Exceptions.RecursoNoEncontradoException;
import org.example.reto4.repository.ReservaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/reservas")
public class ReservaWebController {

    private final ReservaRepository reservaRepository;

    public ReservaWebController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas";
    }

    @GetMapping("/{id}")
    public String detalleReserva(@PathVariable String id, Model model) {
        model.addAttribute("reserva", reservaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reserva no encontrada")));
        return "reserva";
    }
}
