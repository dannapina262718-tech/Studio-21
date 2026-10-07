package org.example.model;

import jakarta.persistence.*;
import org.example.enums.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "imagenProducto")
public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String url;

    @ManyToOne(optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public ImagenProducto() {
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Producto getProducto() {
        return producto;
    }

    public ImagenProducto(Producto producto, String url) {
        this.producto = Objects.requireNonNull(producto);
        this.url = Objects.requireNonNull(url);
        producto.agregarImagen(this);
    }
}
