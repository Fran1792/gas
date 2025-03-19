package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.model.Tanque;
import com.croncero.gasolinera.repository.ITanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanqueService implements ITanqueService {
    
    @Autowired
    private ITanqueRepository repoTanque;

    @Override
    public List<Tanque> getTanques() {
        List<Tanque> listaTanques = repoTanque.findAll();
        return listaTanques;
    }

    @Override
    public void saveTanque(Tanque tanque) {
        repoTanque.save(tanque);
    }

    @Override
    public void deleteTanque(Long idTanque) {
        repoTanque.deleteById(idTanque);
    }

    @Override
    public Tanque findTanque(Long idTanque) {
        return repoTanque.findById(idTanque).orElse(null);
    }

    @Override
    public void editTanque(Long idOriginal, String nuevoCodigo, 
                          Integer nuevaCapacidadMaxima, Integer nuevoNivelActual, 
                          Producto nuevoProducto) {
        
        // busco el objeto original
        Tanque tanque = this.findTanque(idOriginal);
        
        // proceso de modificación a nivel lógico
        tanque.setCodigo(nuevoCodigo);
        tanque.setCapacidadMaxima(nuevaCapacidadMaxima);
        tanque.setNivelActual(nuevoNivelActual);
        tanque.setProducto(nuevoProducto);
        // guardar los cambios
        this.saveTanque(tanque);
    }
}

