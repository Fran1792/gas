package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.model.Suministro;
import com.croncero.gasolinera.model.Surtidor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ISuministroService {
    
    // método para traer todos los suministros
    // lectura
    public List<Suministro> getSuministros();

    // alta
    public void saveSuministro(Suministro suministro);

    // baja
    public void deleteSuministro(Long idSuministro);

    // lectura de un solo objeto
    public Suministro findSuministro(Long idSuministro);

    // edición/modificación
    public void editSuministro(Long idOriginal, 
                              Surtidor nuevoSurtidor,
                              Producto nuevoProducto,
                              LocalDateTime nuevaFechaHora,
                              BigDecimal nuevoVolumenLitros,
                              BigDecimal nuevoImporteEuros);
}

