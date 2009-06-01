package br.faculdadeidez.psa.vo;

/**
 * Classe respons�vel por transportar objetoMensagemValidacao
 * entre as camadas.
 */
public class MensagemValidacaoVO {
	
	/**
	 * Propriedade provada campo
	 */
	private String campo;
	
	/**
	 * Propriedade privada mensagem
	 */
	private String mensagem;
	
	/**
	 * Propriedade privada invalido
	 */
	private Boolean invalido;
	
	/**
	 * Construtor da classe
	 */
	public MensagemValidacaoVO() { 
		
	}
	
	/**
	 * Sobrecarga do construtor padr�o 
	 * @param String campo
	 * @param String mensagem
	 * @param boolean invalido
	 */
	public MensagemValidacaoVO(String campo, String mensagem, Boolean invalido) { 
		this.campo = campo;
		this.mensagem = mensagem;
		this.invalido = invalido;
	}
	
	/**
	 * M�todo getter da propriedade campo
	 * @return String campo
	 */
	public String getCampo() {
		return campo;
	}
	
	/**
	 * M�todo setter da propriedade campo
	 * @param String campo
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	/**
	 * M�todo getter da propriedade mensagem
	 * @return String mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/***
	 * M�todo setter da propriedade mensagem
	 * @param String mensagem
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	/**
	 * M�todo setter da propriedade invalido
	 * @param boolean invalido
	 */
	public void setInvalido(Boolean invalido) { 
		this.invalido = invalido;
	}
	
	/**
	 * M�todo getter da propriedade invalido
	 * @return boolean invalido
	 */
	public Boolean getInvalido() { 
		return invalido;
	}
}
