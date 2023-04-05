
package com.Nexus.controller;

import com.Nexus.domain.Computadora;
import com.Nexus.service.ComputadoraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ComputadoraController {
    @Autowired
    private ComputadoraService computadoraService;
    
    @GetMapping("/computadora/listado")
    public String inicio(Model model) {
    var computadoras = computadoraService.getComputadoras(false);
    model.addAttribute("computadoras", computadoras);
    return "/computadora/listado";
    }
   
    @GetMapping("/computadora/nuevo")
    public String nuevoComputadora(Computadora computadora, Model model){
        return "/computadora/modificar";
    }    
    
    
    @PostMapping("/computadora/guardar")
    public String guardarComputadora(Computadora computadora){
        computadoraService.save(computadora);
        return "redirect:/computadora/listado";
    }  

    @GetMapping("/computadora/modificar/{idComputadora}")
    public String modificarComputadora(Computadora computadora, Model model) {
        computadora = computadoraService.getComputadora(computadora);
        model.addAttribute("computadora", computadora);
        return "/computadora/modificar";
    } 
    
    
    @GetMapping("/computadora/eliminar/{idComputadora}")
    public String eliminarComputadora(Computadora computadora){
        computadoraService.delete(computadora);
        return "redirect:/computadora/listado";
    }   
}
