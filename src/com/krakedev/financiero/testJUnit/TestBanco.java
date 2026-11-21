
package com.krakedev.financiero.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestBanco {

    @Test
    public void testCrearCuenta() {

        // CASO 1: Crear un cliente y un banco
        Cliente cliente = new Cliente("1234567890", "Josue", "Vilcacundo");
        Banco banco = new Banco();

        // CASO 2: Crear la primera cuenta
        Cuenta cuenta1 = banco.crearCuenta(cliente);

        // CASO 3: Crear la segunda cuenta
        Cuenta cuenta2 = banco.crearCuenta(cliente);

        // CASO 4: Validar que los códigos sean consecutivos
        assertEquals("1000", cuenta1.getId());
        assertEquals("1001", cuenta2.getId());

        // CASO 5: Validar que las cuentas pertenezcan al cliente
        assertEquals(cliente, cuenta1.getPropietario());
        assertEquals(cliente, cuenta2.getPropietario());

    }

    @Test
    public void testDepositar() {

    	// CASO 1: Crear un cliente, banco y cuenta
    	Cliente cliente = new Cliente("1234567890", "Josue", "Vilcacundo");
    	Banco banco = new Banco();
    	Cuenta cuenta = banco.crearCuenta(cliente);

    	// CASO 2: Realizar un depósito válido
    	boolean respuesta1 = banco.depositar(100, cuenta);
    	assertTrue(respuesta1);
    	assertEquals(100, cuenta.getSaldoActual());

    	// CASO 3: Realizar otro depósito y comprobar la suma
    	boolean respuesta2 = banco.depositar(50, cuenta);
    	assertTrue(respuesta2);
    	assertEquals(150, cuenta.getSaldoActual());

    	// CASO 4: Intentar depositar un monto de cero
    	boolean respuesta3 = banco.depositar(0, cuenta);
    	assertFalse(respuesta3);
    	assertEquals(150, cuenta.getSaldoActual());

    	// CASO 5: Intentar depositar un monto negativo
    	boolean respuesta4 = banco.depositar(-20, cuenta);
    	assertFalse(respuesta4);
    	assertEquals(150, cuenta.getSaldoActual());

}


}
