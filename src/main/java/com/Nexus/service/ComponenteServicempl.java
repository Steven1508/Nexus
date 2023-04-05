
package com.Nexus.service;

import com.Nexus.dao.ComponenteDao;
import com.Nexus.domain.Componente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComponenteServicempl implements ComponenteService {
    
    @Autowired
    private ComponenteDao componenteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Componente> getComponentes(boolean activo) {
        List<Componente> lista = (List<Componente>) componenteDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Componente getComponente(Componente componente) {
      return componenteDao.findById(componente.getIdComponente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Componente componente) {
       componenteDao.save(componente);
    }

    @Override
    @Transactional
    public void delete(Componente componente) {
       componenteDao.deleteById(componente.getIdComponente());
    }
    
}
