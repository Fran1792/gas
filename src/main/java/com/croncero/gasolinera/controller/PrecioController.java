package com.croncero.gasolinera.controller;

import com.croncero.gasolinera.model.Precio;
import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.service.IPrecioService;
import com.croncero.gasolinera.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PrecioController {
    
    @Autowired
    private IPrecioService precioService;
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/precios/traer")
    public List<Precio> getPrecios() {
        return precioService.getPrecios();
    }
    
    @GetMapping("/precios/traer/{id}")
    public Precio getPrecio(@PathVariable Long id) {
        return precioService.findPrecio(id);
    }
    
    @PostMapping("/precios/crear")
    public String savePrecio(@RequestBody Precio precio) {
        precioService.savePrecio(precio);
        return "El precio fue creado correctamente";
    }
    
    @DeleteMapping("/precios/borrar/{id}")
    public String deletePrecio(@PathVariable Long id) {
        precioService.deletePrecio(id);
        return "El precio fue eliminado correctamente";
    }
    
    @PutMapping("/precios/editar/{idOriginal}")
    public Precio editPrecio(@PathVariable Long idOriginal,
                            @RequestParam(required = false, name = "idProducto") Long idProducto,
                            @RequestParam(required = false, name = "fechaInicio") String fechaInicio,
                            @RequestParam(required = false, name = "fechaFin") String fechaFin,
                            @RequestParam(required = false, name = "precioPorLitro") BigDecimal precioPorLitro) {

        Precio p = null;
        p= precioService.findPrecio(idOriginal);

        Producto producto = null;

        if (idProducto != null) {
            producto = productoService.findProducto(idProducto);
        } else{
            producto=p.getProducto();
        }



        LocalDate fechaInicioDate = fechaInicio != null ? LocalDate.parse(fechaInicio) : p.getFechaInicio();
        LocalDate fechaFinDate = fechaFin != null ? LocalDate.parse(fechaFin) : p.getFechaFin();

        
        precioService.editPrecio(idOriginal, producto, fechaInicioDate, fechaFinDate, precioPorLitro);
        
        return precioService.findPrecio(idOriginal);
    }
    
    @PutMapping("/precios/editar")
    public Precio editPrecio(@RequestBody Precio precio) {
        Precio precioOriginal = precioService.findPrecio(precio.getIdPrecio());
        
        precioService.editPrecio(
            precioOriginal.getIdPrecio(),
            precio.getProducto(),
            precio.getFechaInicio(),
            precio.getFechaFin(),
            precio.getPrecioPorLitro()
        );
        
        return precioService.findPrecio(precio.getIdPrecio());
    }
}

