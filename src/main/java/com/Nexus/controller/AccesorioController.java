
package com.Nexus.controller;


import com.Nexus.domain.Accesorio;
import com.Nexus.service.AccesorioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class AccesorioController {
    @Autowired
    private AccesorioService accesorioService;
    
    @GetMapping("/accesorio/listado")
    public String inicio(Model model) {
    var accesorios = accesorioService.getAccesorios(false);
    model.addAttribute("accesorios", accesorios);
    return "/accesorio/listado";
    }
   
    @GetMapping("/accesorio/nuevo")
    public String nuevoAccesorio(Accesorio accesorio, Model model){
        return "/accesorio/modificar";
    }    
    
    
    @PostMapping("/accesorio/guardar")
    public String guardarAccesorio(Accesorio accesorio){
        accesorioService.save(accesorio);
        return "redirect:/accesorio/listado";
    }  

    @GetMapping("/accesorio/modificar/{idAccesorio}")
    public String modificarAccesorio(Accesorio accesorio, Model model) {
        accesorio = accesorioService.getAccesorio(accesorio);
        model.addAttribute("accesorio", accesorio);
        return "/accesorio/modificar";
    } 
    
    
    @GetMapping("/accesorio/eliminar/{idAccesorio}")
    public String eliminarAccesorio(Accesorio accesorio){
        accesorioService.delete(accesorio);
        return "redirect:/accesorio/listado";
    }   
}
