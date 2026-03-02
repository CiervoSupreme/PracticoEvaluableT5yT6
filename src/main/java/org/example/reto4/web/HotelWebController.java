package org.example.reto4.web;

import org.example.reto4.Exceptions.RecursoNoEncontradoException;
import org.example.reto4.repository.HotelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/hoteles")
public class HotelWebController {

    private final HotelRepository hotelRepository;

    public HotelWebController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping
    public String listarHoteles(Model model) {
        model.addAttribute("hoteles", hotelRepository.findAll());
        return "hoteles";
    }

    @GetMapping("/{id}")
    public String detalleHotel(@PathVariable String id, Model model) {
        model.addAttribute("hotel", hotelRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Hotel no encontrado")));
        return "hotel";
    }
}
