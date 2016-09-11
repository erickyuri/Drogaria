package br.pro.delfino.drogaria.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;


import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.CasosDAO;
import br.pro.delfino.drogaria.domain.Casos;
import br.pro.delfino.drogaria.domain.Historico;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {
	private Casos caso = new Casos();
	private Boolean exibePainelDados;
	
	private Historico historico = new Historico();

	public Casos getCaso() {
		return caso;
	}

	public void setCasos(Casos caso) {
		this.caso = caso;
	}

	public Boolean getExibePainelDados() {
		return exibePainelDados;
	}

	public void setExibePainelDados(Boolean exibePainelDados) {
		this.exibePainelDados = exibePainelDados;
	}
	
	public Historico getHistorico() {
		return historico;
	}
	
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	@PostConstruct
	public void novo() {
		historico = new Historico();
		caso = new Casos();
		
		
		
	}

	public void buscar() {
		try {
			CasosDAO casosDAO = new CasosDAO();
			Casos resultado = casosDAO.buscar(caso.getCodigo());

			if (resultado == null) {
				exibePainelDados = false;
				Messages.addGlobalWarn("No existe registro cadastrado para o c�digo informado");
			} else {
				exibePainelDados = true;
				caso = resultado;
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar o produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			
			
			
			CasosDAO casosDAO = new CasosDAO();
			casosDAO.merge(caso);
			caso.setCasos(caso);
			Messages.addGlobalInfo("Hist�rico salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o hist�rico");
			erro.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
    	caso = (Casos) evento.getComponent().getAttributes().get("casoSelecionado");
    }
}
