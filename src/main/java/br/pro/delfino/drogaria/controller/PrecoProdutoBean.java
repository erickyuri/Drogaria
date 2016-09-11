package br.pro.delfino.drogaria.controller;

import javax.faces.bean.ManagedBean;

import br.pro.delfino.drogaria.service.CalculadoraPreco;

@ManagedBean
public class PrecoProdutoBean {
	
	private CalculadoraPreco calculadora;
	
	public double getPreco(){
		calculadora = new CalculadoraPreco();
		return calculadora.calculaPreco(10, 44.55);
	}
	

}
