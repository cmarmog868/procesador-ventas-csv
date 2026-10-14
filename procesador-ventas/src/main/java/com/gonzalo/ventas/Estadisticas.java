package com.gonzalo.ventas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Estadisticas {

    public static BigDecimal totalGeneral(List<Venta> ventas) {
        return ventas.stream()
                .map(Venta::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Map<String, BigDecimal> totalPorCategoria(List<Venta> ventas) {
        return ventas.stream().collect(Collectors.groupingBy(
                Venta::getCategoria,
                TreeMap::new,
                Collectors.reducing(BigDecimal.ZERO, Venta::getTotal, BigDecimal::add)));
    }

    public static Map<String, Integer> unidadesPorProducto(List<Venta> ventas) {
        return ventas.stream().collect(Collectors.groupingBy(
                Venta::getProducto,
                TreeMap::new,
                Collectors.summingInt(Venta::getCantidad)));
    }

    public static String productoMasVendido(List<Venta> ventas) {
        return unidadesPorProducto(ventas).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> e.getKey() + " (" + e.getValue() + " uds)")
                .orElse("sin datos");
    }
}
