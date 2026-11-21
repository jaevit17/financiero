package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {
	private int ultimoCodigo=1000;
	
	//CONSTRUCTOR
	public Banco() {
		
	}
	
	//GETTERS-SETTERS
	public int getUltimoCodigo() {
		return ultimoCodigo;
	}
	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	//METODO
	public Cuenta crearCuenta(Cliente cliente){
		String codigoStr=ultimoCodigo+"";
		ultimoCodigo++;
		Cuenta cuentaBase=new Cuenta(codigoStr,cliente);
		return cuentaBase;
	}
	public boolean depositar(double monto,Cuenta cuenta) {
		if(monto>0) {
			cuenta.setSaldoActual(cuenta.getSaldoActual()+monto);
			return true;
		}else {
			return false;
		}
	}
	public boolean retirar(double monto,Cuenta cuenta) {
		if(monto>0&&monto<cuenta.getSaldoActual()) {
			cuenta.setSaldoActual(cuenta.getSaldoActual()-monto);
			return true;
		}else {
			return false;
		}
	}
	public boolean transferir(double monto,Cuenta origen,Cuenta destino) {
		boolean retiro=retirar(monto,origen);
		if(retiro==true) {
			boolean deposito=depositar(monto,destino);	
			if(deposito==true) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
