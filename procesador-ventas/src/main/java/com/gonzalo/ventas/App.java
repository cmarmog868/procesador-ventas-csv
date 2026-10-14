package com.gonzalo.ventas;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        LectorCsv lector = new LectorCsv();
        List<Venta> ventas = lector.leer("datos/ventas.csv");

        System.out.println("\n--- Ventas ---");
        ventas.forEach(System.out::println);

        System.out.println("\n--- Total por categoría ---");
        Estadisticas.totalPorCategoria(ventas)
                .forEach((cat, total) -> System.out.println(cat + ": " + total));

        System.out.println("\nTotal general: " + Estadisticas.totalGeneral(ventas));
        System.out.println("Producto más vendido: " + Estadisticas.productoMasVendido(ventas));
    }
}
