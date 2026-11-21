
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

}
