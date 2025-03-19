package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Precio;
import com.croncero.gasolinera.model.Producto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPrecioService {
    
    // método para traer todos los precios
    // lectura
    public List<Precio> getPrecios();

    // alta
    public void savePrecio(Precio precio);

    // baja
    public void deletePrecio(Long idPrecio);

    // lectura de un solo objeto
    public Precio findPrecio(Long idPrecio);

    // edición/modificación
    public void editPrecio(Long idOriginal, 
                          Producto nuevoProducto,
                          LocalDate nuevaFechaInicio,
                          LocalDate nuevaFechaFin,
                          BigDecimal nuevoPrecioPorLitro);
}

