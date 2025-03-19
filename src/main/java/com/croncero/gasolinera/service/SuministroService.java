package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.model.Suministro;
import com.croncero.gasolinera.model.Surtidor;
import com.croncero.gasolinera.repository.ISuministroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuministroService implements ISuministroService {
    
    @Autowired
    private ISuministroRepository repoSuministro;

    @Override
    public List<Suministro> getSuministros() {
        List<Suministro> listaSuministros = repoSuministro.findAll();
        return listaSuministros;
    }

    @Override
    public void saveSuministro(Suministro suministro) {
        repoSuministro.save(suministro);
    }

    @Override
    public void deleteSuministro(Long idSuministro) {
        repoSuministro.deleteById(idSuministro);
    }

    @Override
    public Suministro findSuministro(Long idSuministro) {
        return repoSuministro.findById(idSuministro).orElse(null);
    }

    @Override
    public void editSuministro(Long idOriginal, Surtidor nuevoSurtidor, 
                              Producto nuevoProducto, LocalDateTime nuevaFechaHora, 
                              BigDecimal nuevoVolumenLitros, BigDecimal nuevoImporteEuros) {
        
        // busco el objeto original
        Suministro suministro = this.findSuministro(idOriginal);
        
        // proceso de modificación a nivel lógico
        suministro.setSurtidor(nuevoSurtidor);
        suministro.setProducto(nuevoProducto);
        suministro.setFechaHora(nuevaFechaHora);
        suministro.setVolumenLitros(nuevoVolumenLitros);
        suministro.setImporteEuros(nuevoImporteEuros);
        
        // guardar los cambios
        this.saveSuministro(suministro);
    }
}

