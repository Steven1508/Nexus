
package com.Nexus.service;

import com.Nexus.dao.ComputadoraDao;
import com.Nexus.domain.Computadora;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComputadoraServicempl implements ComputadoraService {
    
    @Autowired
    private ComputadoraDao computadoraDao;

    @Override
    @Transactional(readOnly = true)
    public List<Computadora> getComputadoras(boolean activo) {
        List<Computadora> lista = (List<Computadora>) computadoraDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Computadora getComputadora(Computadora computadora) {
      return computadoraDao.findById(computadora.getIdComputadora()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Computadora computadora) {
       computadoraDao.save(computadora);
    }

    @Override
    @Transactional
    public void delete(Computadora computadora) {
       computadoraDao.deleteById(computadora.getIdComputadora());
    }
}
