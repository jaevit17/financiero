
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

    @Test
    public void testRetirar() {

    	// CASO 1: Crear un cliente, banco y cuenta
    	Cliente cliente = new Cliente("1234567890", "Josue", "Vilcacundo");
    	Banco banco = new Banco();
    	Cuenta cuenta = banco.crearCuenta(cliente);

    	// CASO 2: Depositar dinero para realizar los retiros
    	banco.depositar(100, cuenta);

    	// CASO 3: Realizar un retiro válido
    	boolean respuesta1 = banco.retirar(30, cuenta);
    	assertTrue(respuesta1);
    	assertEquals(70, cuenta.getSaldoActual());

    	// CASO 4: Intentar retirar un monto de cero
    	boolean respuesta2 = banco.retirar(0, cuenta);
    	assertFalse(respuesta2);
    	assertEquals(70, cuenta.getSaldoActual());

    	// CASO 5: Intentar retirar un monto negativo
    	boolean respuesta3 = banco.retirar(-20, cuenta);
    	assertFalse(respuesta3);
    	assertEquals(70, cuenta.getSaldoActual());

    	// CASO 6: Intentar retirar más dinero del disponible
    	boolean respuesta4 = banco.retirar(100, cuenta);
    	assertFalse(respuesta4);
    	assertEquals(70, cuenta.getSaldoActual());

    }

    @Test
    public void testTransferir() {

    	// CASO 1: Crear un cliente, banco y dos cuentas
    	Cliente cliente = new Cliente("1234567890", "Josue", "Vilcacundo");
    	Banco banco = new Banco();
    	Cuenta origen = banco.crearCuenta(cliente);
    	Cuenta destino = banco.crearCuenta(cliente);

    	// CASO 2: Depositar dinero en la cuenta origen
    	banco.depositar(200, origen);

    	// CASO 3: Realizar una transferencia válida
    	boolean respuesta1 = banco.transferir(100, origen, destino);
    	assertTrue(respuesta1);
    	assertEquals(100, origen.getSaldoActual());
    	assertEquals(100, destino.getSaldoActual());

    	// CASO 4: Intentar transferir más dinero del disponible
    	boolean respuesta2 = banco.transferir(150, origen, destino);
    	assertFalse(respuesta2);
    	assertEquals(100, origen.getSaldoActual());
    	assertEquals(100, destino.getSaldoActual());

    	// CASO 5: Intentar transferir un monto de cero
    	boolean respuesta3 = banco.transferir(0, origen, destino);
    	assertFalse(respuesta3);
    	assertEquals(100, origen.getSaldoActual());
    	assertEquals(100, destino.getSaldoActual());

    	// CASO 6: Intentar transferir un monto negativo
    	boolean respuesta4 = banco.transferir(-20, origen, destino);
    	assertFalse(respuesta4);
    	assertEquals(100, origen.getSaldoActual());
    	assertEquals(100, destino.getSaldoActual());

    }




}
