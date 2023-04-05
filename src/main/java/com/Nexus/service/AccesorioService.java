package com.Nexus.service;

import com.Nexus.domain.Accesorio;
import java.util.List;

public interface AccesorioService {

    public List<Accesorio> getAccesorios(boolean activo);

    public Accesorio getAccesorio(Accesorio accesorio);

    public void save(Accesorio accesorio);

    public void delete(Accesorio accesorio);
}
