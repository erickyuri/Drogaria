package br.pro.delfino.drogaria.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;




@ManagedBean
public class FormatacaoBean {
	private DateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");

	private Date dataInformada;
	private String dataFormatada;

	public void enviar() {
		dataFormatada = formatadorData.format(dataInformada);
	}
	
	public Date getDataInforamada(){
		return dataInformada;
	}
	
	public void setDataInforamada(Date dataInformada){
		this.dataInformada = dataInformada;
	}
	
	public String getDataFormatada(){
		return dataFormatada;
	}

}
