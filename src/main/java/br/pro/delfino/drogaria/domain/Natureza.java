package br.pro.delfino.drogaria.domain;


import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Natureza extends GenericDomain {
	
		private String natureza;
		
		public String getNatureza() {
			return natureza;
		}
		
		public void setNatureza(String natureza){
			this.natureza = natureza;
		}

	}
	