package com.gonzalo.ventas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venta {
    private final LocalDate fecha;
    private final String producto;
    private final String categoria;
    private final int cantidad;
    private final BigDecimal precio;

    public Venta(LocalDate fecha, String producto, String categoria, int cantidad, BigDecimal precio) {
        this.fecha = fecha;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public LocalDate getFecha() { return fecha; }
    public String getProducto() { return producto; }
    public String getCategoria() { return categoria; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getPrecio() { return precio; }

    public BigDecimal getTotal() {
        return precio.multiply(BigDecimal.valueOf(cantidad));
    }

    @Override
    public String toString() {
        return fecha + " | " + producto + " | " + categoria + " | " + cantidad + " x " + precio + " = " + getTotal();
    }
}
