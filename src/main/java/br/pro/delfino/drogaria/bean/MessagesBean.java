package br.pro.delfino.drogaria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MessagesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void adcionarMensagemErro(){
		FacesContext contex = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Resumo da mensagem de erro", "Mensagem de erro completa" );
		
		contex.addMessage("destinoErro",msg);
		
		
	} 
	public void adcionarMensagemFlutuante(){
		
		
		FacesContext contex = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Resumo do avso flutante", "Mensagem aviso flutante" );
		
		contex.addMessage("destinoAviso",msg);
		
		
		
		
	} 

}
