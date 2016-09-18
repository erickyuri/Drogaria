package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Projections;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import br.pro.delfino.drogaria.dao.CasosDAO;
import br.pro.delfino.drogaria.dao.NaturezasDAO;
import br.pro.delfino.drogaria.domain.Casos;
import br.pro.delfino.drogaria.domain.Natureza;
import br.pro.delfino.drogaria.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CasosBean implements Serializable {
    private BigDecimal total;
	private Casos caso;
	private List<Casos> casos;
	private List<Natureza> naturezas;
	private Long codigo;

	
	@SuppressWarnings("unused")
	private CasosDAO casosDAO;

	public List<Natureza> getNaturezas() {
		return naturezas;
	}

	public void setNatureza(List<Natureza> naturezas) {
		this.naturezas = naturezas;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Casos getCaso() {
		return caso;
	}

	public void setCaso(Casos caso) {
		this.caso = caso;
	}

	public List<Casos> getCasos() {
		return casos;
	}

	public void setCasos(List<Casos> casos) {
		this.casos = casos;
	}
	
	public BigDecimal getTolta(){
		return total;
	}
	
	public void setTotal(BigDecimal total){
		this.total = total;
	}

	@PostConstruct
	public void listar() {
		
		try {
			CasosDAO casosDAO = new CasosDAO();
			casos = casosDAO.listar();

			
			

			
			
		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Não foi possivel listar");
			erro.printStackTrace();

		}
	}

	public void excluir(ActionEvent evento) {

		try {
			caso = (Casos) evento.getComponent().getAttributes().get("casoSelecionado");

			CasosDAO casosDAO = new CasosDAO();
			casosDAO.excluir(caso);

			casos = casosDAO.listar();

			Messages.addGlobalInfo("exluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("N�o foi poss�vel exluir");
			erro.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		caso = (Casos) evento.getComponent().getAttributes().get("casoSelecionado");

	}

	public void salvar() {
		try {
			CasosDAO casosDAO = new CasosDAO();
			
			casosDAO.merge(caso);

			caso = new Casos();
			casos = casosDAO.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			erro.printStackTrace();
		}
	}

	public void novo() {

		try {

			caso = new Casos();
			NaturezasDAO naturezasDAO = new NaturezasDAO();
			naturezas = naturezasDAO.listar();
		
			;

		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao incluir");
			erro.printStackTrace();
		}
	}
	
	
	
	@PostConstruct
	public Long getMaior() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Long maxAge = null ;
		try {
			Criteria criteria = sessao
				    .createCriteria(Casos.class)
				    .setProjection(Projections.max("codigo"));
			 maxAge = (Long)criteria.uniqueResult()+1;
		
			 
				
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao buscar codigo");
			erro.printStackTrace();
		}
		System.out.println(maxAge);
		return maxAge;
		
		
		
	}

	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/produtos.jasper");

			Map<String, Object> parametros = new HashMap<>();

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			
			JasperPrintManager.printReport(relatorio, true);
		} catch (JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}
	
	}