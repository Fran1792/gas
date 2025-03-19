package com.croncero.gasolinera.repository;

import com.croncero.gasolinera.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrecioRepository extends JpaRepository<Precio, Long> {
    
}

