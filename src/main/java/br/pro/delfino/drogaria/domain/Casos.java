package br.pro.delfino.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;


import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@SuppressWarnings("serial")
@Entity
public class Casos extends GenericDomain {

	
	
	@Column(nullable = false)
	private String parte;
	@Transient
	private String caminho;
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	@Column(nullable = false)
	private String natureza;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data_ent;
	
	
	@Column(nullable = true)
	private Integer livro;
	
	
	@Column(nullable = true)
	private Integer folha_i;
	
	
	@Column
	private Integer folha_f;
	
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String nome_cont;
	
	@Column(precision = 6, scale = 2)
	 private BigDecimal valor_reg;
	
	@Column(precision = 6, scale = 2)
	 private BigDecimal valor_regcob;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date data_ass;
	
	 @Column
	 private String status;
	 
	 @Column(precision = 6, scale = 2)
	 private BigDecimal valor;
	 
	 @Column(precision = 6, scale = 2)
	 private BigDecimal valor_cob;
	 
	 
	 
	 @Column(precision = 6, scale = 2)
	 private BigDecimal total;
	 
	 public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		
		total = valor_cob.subtract(valor);
	}

	@Lob
	 @Column
	 private String observacao;
	 
	 
	 @OneToMany(mappedBy = "caso", cascade = CascadeType.REMOVE)
	 private List<Matricula> matriculas;
	
	 
	 public BigDecimal getValor_cob(){
		 return valor_cob;
	 }
	 
	 public void setValor_cob(BigDecimal valor_cob){
		 this.valor_cob = valor_cob;
	 }
	 
	 public BigDecimal getValor_regcob(){
		 return valor_regcob;
	 }
	 
	 public void setValor_regcob(BigDecimal valor_regcob){
		 this.valor_regcob = valor_regcob;
	 }
	 public BigDecimal getValor_reg(){
		 return valor_reg;
	 }
	 
	 public void setValor_reg(BigDecimal valor_reg){
		 this.valor_reg = valor_reg;
	 }
	 
	 public BigDecimal getValor(){
		 return valor;
	 }
	 
	 public void setValor(BigDecimal valor){
		 this.valor = valor;
	 }
	 
	 public String getEmail(){
		 return email;
	 }
	 
	 public void setEmail(String email){
		 this.email = email;
	 }
	 
	 public String getTelefone(){
		 return telefone;
	 }
	 
	 public void setTelefone(String telefone){
		 this.telefone = telefone;
	 }
	 public String getNome_cont(){
		 return nome_cont;
	 }
	 
	 
	 public void setNome_cont(String nome_cont){
		 this.nome_cont = nome_cont;
	 }
	 public Integer getLivro(){
		 return livro;
	 }
	 
	 public void setLivro(Integer livro){
		 
		 this.livro = livro;
	 }
	 
	 
	 public Integer getFolha_i(){
		 return folha_i;
	 }
	 
	 public void setFolha_i(Integer folha_i){
		 this.folha_i = folha_i;
	 }
	 
	 public Integer getFolha_f(){
		 return folha_f;
	 }
	 public void setFolha_f(Integer folha_f){
		 this.folha_f = folha_f;
	 }
	 public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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


	public Date getData_ent() {
		return data_ent;
	}


	public void setData_ent(Date data_ent) {
		this.data_ent = data_ent;
	}


	public Date getData_ass() {
		return data_ass;
	}


	public void setData_ass(Date data_ass) {
		this.data_ass = data_ass;
	}

	public void setCasos(Casos  caso) {
		
		
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	
	

}
