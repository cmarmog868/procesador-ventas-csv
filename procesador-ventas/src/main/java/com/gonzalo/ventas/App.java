package com.gonzalo.ventas;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        LectorCsv lector = new LectorCsv();
        List<Venta> ventas = lector.leer("datos/ventas.csv");
        ventas.forEach(System.out::println);
    }
}
