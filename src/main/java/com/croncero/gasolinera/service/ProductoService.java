package com.croncero.gasolinera.service;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository repoProducto;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = repoProducto.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto producto) {
        repoProducto.save(producto);
    }

    @Override
    public void deleteProducto(Long idProducto) {
        repoProducto.deleteById(idProducto);
    }

    @Override
    public Producto findProducto(Long idProducto) {
        return repoProducto.findById(idProducto).orElse(null);
    }

    @Override
    public void editProducto(Long idOriginal, String nuevoNombre, 
                            String nuevaDescripcion, String nuevoTipo) {
        
        // busco el objeto original
        Producto producto = this.findProducto(idOriginal);
        
        // proceso de modificación a nivel lógico
        producto.setNombre(nuevoNombre);
        producto.setDescripcion(nuevaDescripcion);
        producto.setTipo(nuevoTipo);
        
        // guardar los cambios
        this.saveProducto(producto);
    }
}

