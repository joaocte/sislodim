package br.faculdadeidez.psa.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.faculdadeidez.psa.businesslogic.Fachada;

public abstract class GenericoBean {

	private Object elementoSelecionado;
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
	
	public Object getElementoSelecionado() {
		return elementoSelecionado;
	}

	public void setElementoSelecionado(Object elementoSelecionado) {
		this.elementoSelecionado = elementoSelecionado;
	}
	
	public void adicionarMensagem ( String mensagem )
    {
    	FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSummary(mensagem);
        contexto.addMessage(null , message );
    }
}
