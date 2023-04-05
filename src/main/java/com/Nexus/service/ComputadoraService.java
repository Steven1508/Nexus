
package com.Nexus.service;

import com.Nexus.domain.Computadora;
import java.util.List;


public interface ComputadoraService {
    
    public List<Computadora> getComputadoras(boolean activo);

    public Computadora getComputadora(Computadora computadora);

    public void save(Computadora computadora);

    public void delete(Computadora computadora);
}
