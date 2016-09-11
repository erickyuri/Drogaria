package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.NaturezasDAO;

import br.pro.delfino.drogaria.domain.Natureza;

@ManagedBean
@ViewScoped
public class NaturezaBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8674065209205223371L;
	private Natureza natureza;
	private List<Natureza> naturezas;

	public List<Natureza> getNaturezas() {
		return naturezas;

	}

	public void setNaturezas(List<Natureza> naturezas) {
		this.naturezas = naturezas;
	}

	public Natureza getNatureza() {

		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public void Listar() {
		try {
			NaturezasDAO naturezasDAO = new NaturezasDAO();
			naturezas = naturezasDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("N�o foi posivel obter natureza");
			erro.printStackTrace();
		}
	}
public void novo(){
		
		try{
			
			
			natureza = new Natureza();
			
		}catch (RuntimeException erro){
			Messages.addGlobalError("erro ao incluir");
			erro.printStackTrace();
		}
	}
	public void salvar(){
	   try{
		   NaturezasDAO naturezasDAO = new NaturezasDAO();
		   naturezasDAO.merge(natureza);
		   
		   this.natureza= new Natureza();
		   naturezas = naturezasDAO.listar();
		   
		   Messages.addGlobalInfo("Salvo com sucesso");
		   
	   }catch (RuntimeException erro) {
		   
		   Messages.addGlobalError("n�o foi possivel salvar");
		   erro.printStackTrace();
	   }
	   }

}
