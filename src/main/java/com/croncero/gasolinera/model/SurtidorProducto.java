package com.croncero.gasolinera.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "surtidor_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurtidorProducto {
    public Long getIdSurtidorProducto() {
        return idSurtidorProducto;
    }

    public void setIdSurtidorProducto(Long idSurtidorProducto) {
        this.idSurtidorProducto = idSurtidorProducto;
    }

    public Surtidor getSurtidor() {
        return surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSurtidorProducto;

    @ManyToOne
    @JoinColumn(name = "id_surtidor", nullable = false)
    private Surtidor surtidor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
}

