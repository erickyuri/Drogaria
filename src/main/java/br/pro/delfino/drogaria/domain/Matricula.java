package br.pro.delfino.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Matricula extends GenericDomain{
	
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable= false)
	private Integer matricula; 
	
	@Column(nullable = false)
	private String registro;
	
	@Column(nullable = false)
	private String protocolo;
	
	@Column(nullable =  false)
	@Temporal(TemporalType.DATE)
	private Date data_ped;
	
	@Column
	private String parte;
	
	@ManyToOne
	@JoinColumn(name = "caso_codigo")
	private Casos caso;
	
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Casos getCaso() {
		return caso;
	}

	public void setCaso(Casos caso) {
		this.caso = caso;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public Date getData_ped() {
		return data_ped;
	}

	public void setData_ped(Date data_ped) {
		this.data_ped = data_ped;
	}

	public String getParte() {
		return parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}
	
	
	
	

}
