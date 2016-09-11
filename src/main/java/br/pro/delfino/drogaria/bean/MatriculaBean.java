package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.CasosDAO;
import br.pro.delfino.drogaria.dao.MatriculaDAO;
import br.pro.delfino.drogaria.domain.Casos;
import br.pro.delfino.drogaria.domain.Matricula;

@ManagedBean
@ViewScoped
public class MatriculaBean implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -255774147685844795L;
	private Matricula matricula;
	private List<Matricula> matriculas;
	private List <Casos> casos;
	
	
	
	
	
	
	public List<Casos> getCasos() {
		return casos;
	}
	public void setCasos(List<Casos> casos) {
		this.casos = casos;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	@PostConstruct
	public void listar(){
		try{
			MatriculaDAO matriculaDAO = new MatriculaDAO();
			
			
			matriculas=matriculaDAO.listar();
		}catch (RuntimeException erro){
			Messages.addGlobalError("n�o foi possivel listar matriculas");
			erro.printStackTrace();
			
		}
	}
	
	public void novo(){
		
		try{
			matricula = new Matricula();
			CasosDAO casosDAO = new CasosDAO();
			casos = casosDAO.listar();
		}catch (RuntimeException erro){
			Messages.addGlobalError("erro ao incluir");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		
		try{
			MatriculaDAO matriculaDAO = new MatriculaDAO();
			matriculaDAO.merge(matricula);
			
			matricula = new Matricula();
			CasosDAO casosDAO = new CasosDAO();
			casos = casosDAO.listar();
			
			matriculas = matriculaDAO.listar();
			
			Messages.addGlobalInfo("salvo com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalError("n�o foi possivel salvar");
			
		}
	}
	
public void excluir(ActionEvent evento) {
		
		try{
		matricula = (Matricula) evento.getComponent().getAttributes().get("matriculaSelecionada");
		
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		matriculaDAO.excluir(matricula);
		
		matriculas= matriculaDAO.listar();
		
		Messages.addGlobalInfo("exluido com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalInfo("N�o foi poss�vel exluir");
			erro.printStackTrace();
			
		}
	}
    public void editar(ActionEvent evento){
    	matricula = (Matricula) evento.getComponent().getAttributes().get("matriculaSelecionada");
    }
}



