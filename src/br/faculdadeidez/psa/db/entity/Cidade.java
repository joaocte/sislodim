package br.faculdadeidez.psa.db.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.faculdadeidez.psa.vo.CidadeVO;

@SuppressWarnings("serial")
@Entity 
@Table (name="SIS_CIDADE")
/**
 * Classe que abstrai uma linha da tabela SIS_CIDADE
 * -Objeto relacional Cidade
 */
public class Cidade implements Serializable {	
		
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column (name="CID_CODIGO")
	/**
	 * Propriedade privada codigo
	 * Representa o identificador do registro na tabela
	 */
	private int codigo;
	
	@Basic @Column (name="CID_NOME", length=80, nullable=false)
	/**
	 * Propriedade privada nome
	 * Representa a coluna nome da tabela
	 */
	private String nome;
	

	
	/**
	 * M�todo para convers�o de objeto CidadeVo para Cidade
	 * @param CidadeVO vo
	 */
	public Cidade(CidadeVO vo) {
		this.codigo = vo.getCodigo();
		this.nome = vo.getNome();
	}
	/**
	 * M�todo para convers�o de objeto Cidade para CidadeVO
	 * @param Cidade obj
	 * @return CidadeVO
	 */
	public static CidadeVO VO(Cidade obj){
		return new CidadeVO(obj.getCodigo(), obj.getNome());
	}

	/**
	 * Construtor default da classe
	 */
	public Cidade() {
		 
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param String nome
	 */
	public Cidade(String nome)
	{
		setNome(nome);
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param int codigo
	 */
	public Cidade(int codigo)
	{
		setCodigo(codigo);
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param int codigo
	 * @param String nome
	 */
	public Cidade(int codigo, String nome)
	{
		setCodigo(codigo);
		setNome(nome);
	}
	
	/**
	 * M�todo getter da propriedade privada codigo
	 * @return int
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo setter da propriedade privada codigo
	 * @param int codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade privada nome
	 * @return String
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setter da propriedade privada nome
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}