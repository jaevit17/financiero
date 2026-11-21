package com.krakedev.financiero.entidades;

public class Cuenta {
	private String id;
	private double saldoActual;
	private String tipo;
	private Cliente propietario;
	
	//CONSTRUCTOR
	public Cuenta(String id,Cliente propietario) {
		this.id=id;
		this.propietario=propietario;
		this.saldoActual=0;
		this.tipo="A";
	}
	
	//GETTERS-SETTERS
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//----------------------------
	public double getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	//----------------------------
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//------------------------------
	public Cliente getPropietario() {
		return propietario;
	}
	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}
	
	//METODOS
	public void imprimir() {
		System.out.println("----CUENTA----");
		System.out.println("ID: "+id);
		System.out.println("SALDO ACTUAL: "+saldoActual);
		System.out.println("TIPO: "+tipo);
		System.out.println("PROPIETARIO: "+propietario.getCedula());
	}
}
