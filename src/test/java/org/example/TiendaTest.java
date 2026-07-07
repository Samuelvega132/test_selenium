package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TiendaTest {

    private Tienda tienda;

    @BeforeEach
    public void setUp() {
        // Inicializamos el objeto org.example.Tienda antes de cada caso de prueba
        tienda = new Tienda();
    }

    @Test
    public void testCalcularDescuentoCon20() {
        // - Prueba de calcularDescuento() con 20%
        // Si el precio es 100 y el descuento es 20%, el resultado debe ser 80.0
        double resultado = tienda.calcularDescuento(100.0, 20.0);
        assertEquals(80.0, resultado, 0.001);
    }

    @Test
    public void testCalcularDescuentoCon0() {
        // - Prueba de calcularDescuento() con 0%
        // Si el precio es 100 y el descuento es 0%, el precio se mantiene igual (100.0)
        double resultado = tienda.calcularDescuento(100.0, 0.0);
        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    public void testAplicaEnvioGratisMonto50() {
        // - Prueba de aplicaEnvioGratis() cuando el monto es 50
        // Al ser 50 exactos, la condición (>= 50) debe retornar verdadero (true)
        assertTrue(tienda.aplicaEnvioGratis(50.0));
    }

    @Test
    public void testAplicaEnvioGratisMontoMenorA50() {
        // - Prueba de aplicaEnvioGratis() cuando el monto es menor a 50
        // Si el monto es 49.99, debe retornar falso (false)
        assertFalse(tienda.aplicaEnvioGratis(49.99));
    }

    @Test
    public void testCalcularTotal() {
        // - Prueba de calcularTotal()
        // Si el precio es 15.0 y se compran 3 unidades, el total debe ser 45.0
        double resultado = tienda.calcularTotal(15.0, 3);
        assertEquals(45.0, resultado, 0.001);
    }
}