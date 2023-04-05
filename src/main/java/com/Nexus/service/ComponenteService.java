
package com.Nexus.service;

import com.Nexus.domain.Componente;
import java.util.List;


public interface ComponenteService {
    public List<Componente> getComponentes(boolean activo);

    public Componente getComponente(Componente componente);

    public void save(Componente componente);

    public void delete(Componente componente);
}
