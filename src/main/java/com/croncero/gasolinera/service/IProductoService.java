package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Producto;
import java.util.List;

public interface IProductoService {
    
    // método para traer todos los productos
    // lectura
    public List<Producto> getProductos();

    // alta
    public void saveProducto(Producto producto);

    // baja
    public void deleteProducto(Long idProducto);

    // lectura de un solo objeto
    public Producto findProducto(Long idProducto);

    // edición/modificación
    public void editProducto(Long idOriginal, 
                            String nuevoNombre,
                            String nuevaDescripcion,
                            String nuevoTipo);


}

