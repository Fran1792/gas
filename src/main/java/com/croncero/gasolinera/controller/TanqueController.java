package com.croncero.gasolinera.controller;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.model.Tanque;
import com.croncero.gasolinera.service.IProductoService;
import com.croncero.gasolinera.service.ITanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TanqueController {
    
    @Autowired
    private ITanqueService tanqueService;
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/tanques/traer")
    public List<Tanque> getTanques() {
        return tanqueService.getTanques();
    }
    
    @GetMapping("/tanques/traer/{id}")
    public Tanque getTanque(@PathVariable Long id) {
        return tanqueService.findTanque(id);
    }
    
    @PostMapping("/tanques/crear")
    public String saveTanque(@RequestBody Tanque tanque) {
        tanqueService.saveTanque(tanque);
        return "El tanque fue creado correctamente";
    }
    
    @DeleteMapping("/tanques/borrar/{id}")
    public String deleteTanque(@PathVariable Long id) {
        tanqueService.deleteTanque(id);
        return "El tanque fue eliminado correctamente";
    }

    @PutMapping("/tanques/editar/{idOriginal}")
    public Tanque editTanque(@PathVariable Long idOriginal,
                            @RequestParam(required = false, name = "codigo") String nuevoCodigo,
                            @RequestParam(required = false, name = "capacidadMaxima") Integer nuevaCapacidadMaxima,
                            @RequestParam(required = false, name = "nivelActual") Integer nuevoNivelActual,
                            @RequestParam(required = false, name = "idProducto") Long idProducto) {

        Producto producto = null;
        if (idProducto != null) {
            producto = productoService.findProducto(idProducto);
        }

        Tanque t = tanqueService.findTanque(idOriginal);
        if (nuevoCodigo==null) nuevoCodigo=t.getCodigo();
        if (nuevaCapacidadMaxima==null) nuevaCapacidadMaxima=t.getCapacidadMaxima();
        if (nuevoNivelActual==null) nuevoNivelActual=t.getNivelActual();
        if (producto==null) producto=t.getProducto();


        tanqueService.editTanque(idOriginal, nuevoCodigo, nuevaCapacidadMaxima, nuevoNivelActual, producto);

        return tanqueService.findTanque(idOriginal);
    }
    
    @PutMapping("/tanques/editar")
    public Tanque editTanque(@RequestBody Tanque tanque) {
        tanqueService.editTanque(
            tanque.getIdTanque(),
            tanque.getCodigo(),
            tanque.getCapacidadMaxima(),
            tanque.getNivelActual(),
            tanque.getProducto()
        );
        
        return tanqueService.findTanque(tanque.getIdTanque());
    }
}

