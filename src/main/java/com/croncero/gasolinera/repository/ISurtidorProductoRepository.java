package com.croncero.gasolinera.repository;

import com.croncero.gasolinera.model.SurtidorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorProductoRepository extends JpaRepository<SurtidorProducto, Long> {
    
}

