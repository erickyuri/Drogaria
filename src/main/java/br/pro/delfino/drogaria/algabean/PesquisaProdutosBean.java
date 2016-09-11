package br.pro.delfino.drogaria.algabean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class PesquisaProdutosBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Integer> produtosfiltrados;
	
	public PesquisaProdutosBean(){
		produtosfiltrados = new ArrayList<>();
		for (int i = 0; i < 50; i++){
			produtosfiltrados.add(i);
		}
	}
	
	public List<Integer> getProdutosFiltrados(){
		return produtosfiltrados;
	}

}
