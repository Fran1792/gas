package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Surtidor;
import java.time.LocalDate;
import java.util.List;

public interface ISurtidorService {
    
    // método para traer todos los surtidores
    // lectura
    public List<Surtidor> getSurtidores();

    // alta
    public void saveSurtidor(Surtidor surtidor);

    // baja
    public void deleteSurtidor(Long idSurtidor);

    // lectura de un solo objeto
    public Surtidor findSurtidor(Long idSurtidor);

    // edición/modificación
    public void editSurtidor(Long idOriginal, 
                            String nuevoCodigo,
                            LocalDate nuevaFechaInstalacion,
                            boolean nuevoActivo);
}

