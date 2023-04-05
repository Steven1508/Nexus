
package com.Nexus.service;

import com.Nexus.dao.AccesorioDao;
import com.Nexus.domain.Accesorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccesorioServicempl implements AccesorioService {
    @Autowired
    private AccesorioDao accesorioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Accesorio> getAccesorios(boolean activo) {
        List<Accesorio> lista = (List<Accesorio>) accesorioDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Accesorio getAccesorio(Accesorio accesorio) {
      return accesorioDao.findById(accesorio.getIdAccesorio()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Accesorio accesorio) {
       accesorioDao.save(accesorio);
    }

    @Override
    @Transactional
    public void delete(Accesorio accesorio) {
       accesorioDao.deleteById(accesorio.getIdAccesorio());
    }
    
}
