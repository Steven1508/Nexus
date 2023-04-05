
package com.Nexus.controller;

import com.Nexus.domain.Componente;
import com.Nexus.service.ComponenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ComponenteController {
    @Autowired
    private ComponenteService componenteService;
    
    @GetMapping("/componente/listado")
    public String inicio(Model model) {
    var componentes = componenteService.getComponentes(false);
    model.addAttribute("componentes", componentes);
    return "/componente/listado";
    }
   
    @GetMapping("/componente/nuevo")
    public String nuevoComponente(Componente componente, Model model){
        return "/componente/modificar";
    }    
    
    
    @PostMapping("/componente/guardar")
    public String guardarComponente(Componente componente){
        componenteService.save(componente);
        return "redirect:/componente/listado";
    }  

    @GetMapping("/componente/modificar/{idComponente}")
    public String modificarComponente(Componente componente, Model model) {
        componente = componenteService.getComponente(componente);
        model.addAttribute("componente", componente);
        return "/componente/modificar";
    } 
    
    
    @GetMapping("/componente/eliminar/{idComponente}")
    public String eliminarComponente(Componente componente){
        componenteService.delete(componente);
        return "redirect:/componente/listado";
    }   
}
