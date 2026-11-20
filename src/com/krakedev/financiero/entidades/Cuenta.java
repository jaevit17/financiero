package com.krakedev.financiero.entidades;

public class Cuenta {
	private String id;
	private double saldoActual;
	private String tipo;
	//CONSTRUCTOR
	public Cuenta(String id) {
		this.id=id;
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
	public double getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//METODOS
	public void imprimir() {
		System.out.println("----CUENTA----");
		System.out.println("ID: "+id);
		System.out.println("SALDO ACTUAL: "+saldoActual);
		System.out.println("TIPO: "+tipo);
	}
	
}
