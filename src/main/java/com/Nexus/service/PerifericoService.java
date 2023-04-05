
package com.Nexus.service;

import com.Nexus.domain.Periferico;
import java.util.List;

public interface PerifericoService {
    
    public List<Periferico> getPerifericos(boolean activo);

    public Periferico getPeriferico(Periferico periferico);

    public void save(Periferico periferico);

    public void delete(Periferico periferico);
}
