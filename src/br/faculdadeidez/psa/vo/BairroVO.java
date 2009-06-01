package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.List;

import br.faculdadeidez.psa.db.entity.Setor;
/**
 * Classe respons�vel por transportar objetoBairro
 * entre as camadas.
 * 
 */
public class BairroVO implements Serializable {
	/**
	 * Propriedade privada codigo
	 */
	private int codigo;
	/**
	 * Propriedade privada nome
	 */
	private String nome;
	/**
	 * propriedade privada setores
	 */
	private List<Setor> setores;
	
	/**
	 * Construtor da classe
	 */
	public BairroVO(){
		
	}
	
	/**
	 * M�todo getter da propriedade setores
	 * @return List<Setor>
	 */
	public List<Setor> getSetores() {
		return setores;
	}
	
	/**
	 * M�todo setter da propriedade setores
	 * @param List<Setor> setores
	 */
	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	
	/**
	 * Sobrecarga do contrutor padr�o
	 * @param int codigo
	 * @param String nome
	 */
	public BairroVO(int codigo, String nome) {
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
	 * @param codigo
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
