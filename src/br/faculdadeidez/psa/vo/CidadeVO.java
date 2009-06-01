package br.faculdadeidez.psa.vo;

import java.io.Serializable;
/**
 * Classe respons�vel por transportar objetoCidade
 * entre as camadas.
 */
@SuppressWarnings("serial")
public class CidadeVO implements Serializable {

	/**
	 * Propriedade privada codigo
	 */
	private int codigo;
	
	/**
	 * Propriedade privada nome
	 */
	private String nome;
	
	/**
	 * Construtor da classe
	 */
	public CidadeVO(){
		
	}
	
	/**
	 * Sobrecarga do construtor padr�o
	 * @param int codigo
	 * @param String nome
	 */
	public CidadeVO(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	/**
	 * M�todo getter da propriedade codigo
	 * @return int codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo setter da propriedade codigo
	 * @param int codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade nome
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setter da propriedade nome
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}