package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Precio;
import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.repository.IPrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrecioService implements IPrecioService {
    
    @Autowired
    private IPrecioRepository repoPrecio;

    @Override
    public List<Precio> getPrecios() {
        List<Precio> listaPrecios = repoPrecio.findAll();
        return listaPrecios;
    }

    @Override
    public void savePrecio(Precio precio) {
        repoPrecio.save(precio);
    }

    @Override
    public void deletePrecio(Long idPrecio) {
        repoPrecio.deleteById(idPrecio);
    }

    @Override
    public Precio findPrecio(Long idPrecio) {
        return repoPrecio.findById(idPrecio).orElse(null);
    }

    @Override
    public void editPrecio(Long idOriginal, Producto nuevoProducto, 
                          LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, 
                          BigDecimal nuevoPrecioPorLitro) {
        
        // busco el objeto original
        Precio precio = this.findPrecio(idOriginal);
        
        // proceso de modificación a nivel lógico
        precio.setProducto(nuevoProducto);
        precio.setFechaInicio(nuevaFechaInicio);
        precio.setFechaFin(nuevaFechaFin);
        precio.setPrecioPorLitro(nuevoPrecioPorLitro);
        
        // guardar los cambios
        this.savePrecio(precio);
    }
}

