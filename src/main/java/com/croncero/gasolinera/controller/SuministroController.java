package com.croncero.gasolinera.controller;

import com.croncero.gasolinera.model.Producto;
import com.croncero.gasolinera.model.Suministro;
import com.croncero.gasolinera.model.Surtidor;
import com.croncero.gasolinera.service.IProductoService;
import com.croncero.gasolinera.service.ISuministroService;
import com.croncero.gasolinera.service.ISurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SuministroController {
    
    @Autowired
    private ISuministroService suministroService;
    
    @Autowired
    private ISurtidorService surtidorService;
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/suministros/traer")
    public List<Suministro> getSuministros() {
        return suministroService.getSuministros();
    }
    
    @GetMapping("/suministros/traer/{id}")
    public Suministro getSuministro(@PathVariable Long id) {
        return suministroService.findSuministro(id);
    }
    
    @PostMapping("/suministros/crear")
    public String saveSuministro(@RequestBody Suministro suministro) {
        suministroService.saveSuministro(suministro);
        return "El suministro fue creado correctamente";
    }
    
    @DeleteMapping("/suministros/borrar/{id}")
    public String deleteSuministro(@PathVariable Long id) {
        suministroService.deleteSuministro(id);
        return "El suministro fue eliminado correctamente";
    }
    
    @PutMapping("/suministros/editar/{idOriginal}")
    public Suministro editSuministro(@PathVariable Long idOriginal,
                                    @RequestParam(required = false, name = "idSurtidor") Long idSurtidor,
                                    @RequestParam(required = false, name = "idProducto") Long idProducto,
                                    @RequestParam(required = false, name = "fechaHora") String fechaHora,
                                    @RequestParam(required = false, name = "volumenLitros") BigDecimal volumenLitros,
                                    @RequestParam(required = false, name = "importeEuros") BigDecimal importeEuros) {
        
        Surtidor surtidor = null;
        if (idSurtidor != null) {
            surtidor = surtidorService.findSurtidor(idSurtidor);
        }
        
        Producto producto = null;
        if (idProducto != null) {
            producto = productoService.findProducto(idProducto);
        }
        
        LocalDateTime fechaHoraDateTime = null;
        if (fechaHora != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            fechaHoraDateTime = LocalDateTime.parse(fechaHora, formatter);
        }
        
        suministroService.editSuministro(idOriginal, surtidor, producto, fechaHoraDateTime, volumenLitros, importeEuros);
        
        return suministroService.findSuministro(idOriginal);
    }
    
    @PutMapping("/suministros/editar")
    public Suministro editSuministro(@RequestBody Suministro suministro) {
        suministroService.editSuministro(
            suministro.getIdSuministro(),
            suministro.getSurtidor(),
            suministro.getProducto(),
            suministro.getFechaHora(),
            suministro.getVolumenLitros(),
            suministro.getImporteEuros()
        );
        
        return suministroService.findSuministro(suministro.getIdSuministro());
    }
}

