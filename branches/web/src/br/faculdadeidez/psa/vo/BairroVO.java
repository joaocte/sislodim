package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.List;

import br.faculdadeidez.psa.db.entity.Setor;
/**
 * Classe respons�vel por transportar objetoBairro
 * entre as camadas.
 * 
 */
@SuppressWarnings("serial")
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
	
	private CidadeVO cidade;
	
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
	public BairroVO(int codigo, String nome, CidadeVO cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
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
	
	public void setCidade(CidadeVO cidade){
		this.cidade = cidade;
	}
	
	public CidadeVO getCidade(){
		return this.cidade;
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