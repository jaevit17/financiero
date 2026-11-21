package com.krakedev.financiero.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestCuenta {

	public static void main(String[] args) {
		Cliente propietario=new Cliente();
		Cuenta c1=new Cuenta("001",propietario);
		c1.imprimir();

	}

}
