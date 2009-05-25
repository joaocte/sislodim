package br.faculdadeidez.psa.apresentacao.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.faculdadeidez.psa.facade.Fachada;
/**
 * ManagedBean gen�rico com os m�todos comuns a todos os outros
 * @author Samuel
 *
 */
public abstract class GenericoBean {

	/**
	 * Respons�vel por armazenar o objeto selecionado em uma lista
	 */
	private Object elementoSelecionado;
	/**
	 * Respons�vel por guardar o termo pesquisado
	 */
	private String termoPesquisa;
	/**
	 * M�todo que retorna a fachada
	 * @return Fachada
	 */
	Fachada getFachada(){
		return Fachada.getFachada();
	}

	/**
	 * M�todo getter do atributo
	 * @return String
	 */
	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	/**
	 * M�todo setter do atributo
	 * @param termoPesquisa String
	 */
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	/**
	 * M�todo que permite atualizar sem bugs
	 * @return Boolean
	 */
	public Boolean canUpdate() {
		FacesContext contexto = FacesContext.getCurrentInstance();		
		if(contexto.getExternalContext().getRequestContentType().indexOf("charset") == -1) { 								
			setTermoPesquisa(new String());
			return true;
		}
		else { 
			return false;
		}
	}


	/**
	 * M�todo getter do atributo elementoSelecionado
	 * @return Object
	 */
	public Object getElementoSelecionado() {
		return elementoSelecionado;
	}

	/**
	 * M�todo setter do atributo elementoSelecionado
	 * @param elementoSelecionado Object
	 */
	public void setElementoSelecionado(Object elementoSelecionado) {
		this.elementoSelecionado = elementoSelecionado;
	}
	
	/**
	 * M�todo para adicionar mensagens informativas
	 * @param mensagem String
	 */
	public void adicionarMensagem ( String mensagem )
    {
    	FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSummary(mensagem);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        contexto.addMessage(null , message);
    }
	
	/**
	 * M�todo para adicionar mensagens de erro
	 * @param mensagem String
	 */
	public void adicionarMensagemErro (String mensagem)
    {
    	FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSummary(mensagem);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        contexto.addMessage(null , message);
    }
}
