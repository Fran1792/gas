package com.croncero.gasolinera.controller;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.model.Surtidor;
import com.croncero.gasolinera.model.SurtidorProducto;
import com.croncero.gasolinera.service.IProductoService;
import com.croncero.gasolinera.service.ISurtidorProductoService;
import com.croncero.gasolinera.service.ISurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SurtidorProductoController {
    
    @Autowired
    private ISurtidorProductoService surtidorProductoService;
    
    @Autowired
    private ISurtidorService surtidorService;
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/surtidor-productos/traer")
    public List<SurtidorProducto> getSurtidorProductos() {
        return surtidorProductoService.getSurtidorProductos();
    }
    
    @GetMapping("/surtidor-productos/traer/{id}")
    public SurtidorProducto getSurtidorProducto(@PathVariable Long id) {
        return surtidorProductoService.findSurtidorProducto(id);
    }
    
    @PostMapping("/surtidor-productos/crear")
    public String saveSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        surtidorProductoService.saveSurtidorProducto(surtidorProducto);
        return "La relación surtidor-producto fue creada correctamente";
    }
    
    @DeleteMapping("/surtidor-productos/borrar/{id}")
    public String deleteSurtidorProducto(@PathVariable Long id) {
        surtidorProductoService.deleteSurtidorProducto(id);
        return "La relación surtidor-producto fue eliminada correctamente";
    }
    
    @PutMapping("/surtidor-productos/editar/{idOriginal}")
    public SurtidorProducto editSurtidorProducto(@PathVariable Long idOriginal,
                                                @RequestParam(required = false, name = "idSurtidor") Long idSurtidor,
                                                @RequestParam(required = false, name = "idProducto") Long idProducto) {
        
        Surtidor surtidor = null;
        if (idSurtidor != null) {
            surtidor = surtidorService.findSurtidor(idSurtidor);
        }
        
        Producto producto = null;
        if (idProducto != null) {
            producto = productoService.findProducto(idProducto);
        }
        
        surtidorProductoService.editSurtidorProducto(idOriginal, surtidor, producto);
        
        return surtidorProductoService.findSurtidorProducto(idOriginal);
    }
    
    @PutMapping("/surtidor-productos/editar")
    public SurtidorProducto editSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        surtidorProductoService.editSurtidorProducto(
            surtidorProducto.getIdSurtidorProducto(),
            surtidorProducto.getSurtidor(),
            surtidorProducto.getProducto()
        );
        
        return surtidorProductoService.findSurtidorProducto(surtidorProducto.getIdSurtidorProducto());
    }
}

