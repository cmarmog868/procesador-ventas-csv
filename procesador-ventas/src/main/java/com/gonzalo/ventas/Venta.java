package com.gonzalo.ventas;

import java.time.LocalDate;

public class Venta {
    private final LocalDate fecha;
    private final String producto;
    private final String categoria;
    private final int cantidad;
    private final double precio;

    public Venta(LocalDate fecha, String producto, String categoria, int cantidad, double precio) {
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
    public double getPrecio() { return precio; }

    public double getTotal() {
        return cantidad * precio;
    }

    @Override
    public String toString() {
        return fecha + " | " + producto + " | " + categoria + " | " + cantidad + " x " + precio + " = " + getTotal();
    }
}
