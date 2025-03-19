package com.croncero.gasolinera.controller;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/productos/traer")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }
    
    @GetMapping("/productos/traer/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productoService.findProducto(id);
    }
    
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "El producto fue creado correctamente";
    }






    @DeleteMapping("/productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "El producto fue eliminado correctamente";
    }
    
    @PutMapping("/productos/editar/{idOriginal}")
    public Producto editProducto(@PathVariable Long idOriginal,
                                @RequestParam(required = false, name = "nombre") String nuevoNombre,
                                @RequestParam(required = false, name = "descripcion") String nuevaDescripcion,
                                @RequestParam(required = false, name = "tipo") String nuevoTipo) {
        
        productoService.editProducto(idOriginal, nuevoNombre, nuevaDescripcion, nuevoTipo);
        
        return productoService.findProducto(idOriginal);
    }
    
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto producto) {
        productoService.editProducto(
            producto.getIdProducto(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getTipo()
        );
        
        return productoService.findProducto(producto.getIdProducto());
    }
}

