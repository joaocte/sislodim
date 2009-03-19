package br.faculdadeidez.psa.beans;

import java.util.List;

import br.faculdadeidez.psa.businesslogic.Fachada;

public class GenericoBean {

	private GenericoBean elementoSelecionado;
	private String linkEditar;
	private String valorBusca;
	
	
	
	Fachada getFachada(){
		return Fachada.getFachada();
	}

	


	



	public String getValorBusca() {
		return valorBusca;
	}


	public void setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
	}


	public String getLinkEditar() {
		return linkEditar;
	}

	public void setLinkEditar(String linkEditar) {
		this.linkEditar = linkEditar;
	}
	
	public GenericoBean getElementoSelecionado() {
		return elementoSelecionado;
	}

	public void setElementoSelecionado(GenericoBean elementoSelecionado) {
		this.elementoSelecionado = elementoSelecionado;
	}
	
}
