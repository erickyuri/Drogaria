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
public class Historico extends GenericDomain {
	
	

	@Column
	private String parte;
	
	
	@Column
	private String natureza;
	
	
	
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date data_ass;
	
	 @Column
	 private String assinado;
	 
	 
	 @Column(length = 500)
	 private String observacao;
	 
	@ManyToOne
	@JoinColumn
	private Casos casos;
	
	 
	 public Casos getCasos() {
		return casos;
	}

	public void setCasos(Casos casos) {
		this.casos = casos;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getAssinado() {
		return assinado;
	}

	public void setAssinado(String assinado) {
		this.assinado = assinado;
	}

	public String getParte(){
		 
		 return parte;
	 }
	 
	 public void setParte(String parte){
		 this.parte = parte;
	 }
	 
	public String getNatureza() {
		return natureza;
	}


	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}




	public Date getData_ass() {
		return data_ass;
	}


	public void setData_ass(Date data_ass) {
		this.data_ass = data_ass;
	}

	
	
	
	

}
