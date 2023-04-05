
package com.Nexus.service;

import com.Nexus.dao.PerifericoDao;
import com.Nexus.domain.Periferico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerifericoServicempl implements PerifericoService {
    
    @Autowired
    private PerifericoDao perifericoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Periferico> getPerifericos(boolean activo) {
        List<Periferico> lista = (List<Periferico>) perifericoDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Periferico getPeriferico(Periferico periferico) {
      return perifericoDao.findById(periferico.getIdPeriferico()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Periferico periferico) {
       perifericoDao.save(periferico);
    }

    @Override
    @Transactional
    public void delete(Periferico periferico) {
       perifericoDao.deleteById(periferico.getIdPeriferico());
    }
}
