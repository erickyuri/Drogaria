package br.pro.delfino.drogaria.bean;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CadastrarUsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String nome;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void verificarDisponibilidadeLogin(){
		FacesMessage msg = null;
		System.out.println("verificando disponibilidade");
		
		if("joao".equalsIgnoreCase(this.login)){
			msg = new FacesMessage("login já esta em uso");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			
		}else{
			msg = new FacesMessage(" Logim disponivel");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		}
	}
	
	public void cadastrar(){
		System.out.println("login: " + login);
		System.out.println("Nome: " + nome);
		
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro efetuado"));
		
	}

}
