package com.croncero.gasolinera.controller;

import com.croncero.gasolinera.model.Surtidor;
import com.croncero.gasolinera.service.ISurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SurtidorController {
    
    @Autowired
    private ISurtidorService surtidorService;
    
    @GetMapping("/surtidores/traer")
    public List<Surtidor> getSurtidores() {
        return surtidorService.getSurtidores();
    }
    
    @GetMapping("/surtidores/traer/{id}")
    public Surtidor getSurtidor(@PathVariable Long id) {
        return surtidorService.findSurtidor(id);
    }
    
    @PostMapping("/surtidores/crear")
    public String saveSurtidor(@RequestBody Surtidor surtidor) {
        surtidorService.saveSurtidor(surtidor);
        return "El surtidor fue creado correctamente";
    }
    
    @DeleteMapping("/surtidores/borrar/{id}")
    public String deleteSurtidor(@PathVariable Long id) {
        surtidorService.deleteSurtidor(id);
        return "El surtidor fue eliminado correctamente";
    }
    
    @PutMapping("/surtidores/editar/{idOriginal}")
    public Surtidor editSurtidor(@PathVariable Long idOriginal,
                                @RequestParam(required = false, name = "codigo") String nuevoCodigo,
                                @RequestParam(required = false, name = "fechaInstalacion") String nuevaFechaInstalacion,
                                @RequestParam(required = false, name = "activo") Boolean nuevoActivo) {
        
        LocalDate fechaInstalacionDate = nuevaFechaInstalacion != null ? LocalDate.parse(nuevaFechaInstalacion) : null;
        
        surtidorService.editSurtidor(idOriginal, nuevoCodigo, fechaInstalacionDate, nuevoActivo != null ? nuevoActivo : false);
        
        return surtidorService.findSurtidor(idOriginal);
    }
    
    @PutMapping("/surtidores/editar")
    public Surtidor editSurtidor(@RequestBody Surtidor surtidor) {
        surtidorService.editSurtidor(
            surtidor.getIdSurtidor(),
            surtidor.getCodigo(),
            surtidor.getFechaInstalacion(),
            surtidor.isActivo()
        );
        
        return surtidorService.findSurtidor(surtidor.getIdSurtidor());
    }
}

