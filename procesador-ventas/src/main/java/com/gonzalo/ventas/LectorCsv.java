package com.gonzalo.ventas;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LectorCsv {

    public List<Venta> leer(String ruta) throws Exception {
        List<Venta> ventas = new ArrayList<>();
        int descartadas = 0;

        try (CSVReader reader = new CSVReader(
                Files.newBufferedReader(Path.of(ruta), StandardCharsets.UTF_8))) {

            String[] fila;
            boolean cabecera = true;

            while ((fila = reader.readNext()) != null) {
                if (cabecera) { cabecera = false; continue; }

                Venta venta = convertir(fila);
                if (venta == null) {
                    descartadas++;
                } else {
                    ventas.add(venta);
                }
            }
        }

        System.out.println("Filas válidas: " + ventas.size() + " | Descartadas: " + descartadas);
        return ventas;
    }

    private Venta convertir(String[] fila) {
        if (fila.length < 5) return null;
        try {
            LocalDate fecha = LocalDate.parse(fila[0].trim());
            String producto = capitalizar(fila[1]);
            String categoria = capitalizar(fila[2]);
            int cantidad = Integer.parseInt(fila[3].trim());
            double precio = Double.parseDouble(fila[4].trim());
            return new Venta(fecha, producto, categoria, cantidad, precio);
        } catch (Exception e) {
            return null; // fila vacía o con datos inválidos
        }
    }

    private String capitalizar(String texto) {
        String t = texto.trim().toLowerCase();
        if (t.isEmpty()) return t;
        return t.substring(0, 1).toUpperCase() + t.substring(1);
    }
}
