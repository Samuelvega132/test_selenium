package org.example;

public class Tienda {
    public double calcularDescuento (double precio, double porcentaje) {
        return precio - (precio * porcentaje / 100);
    }
    public boolean aplicaEnvioGratis (double montoCompra) {
        return montoCompra >= 50;
    }
    public double calcularTotal (double precio, int cantidad) {
        return precio * cantidad;
    }
}