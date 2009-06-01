package br.faculdadeidez.psa.db.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.faculdadeidez.psa.vo.ViaturaVO;

@SuppressWarnings("serial")
@Entity 
@Table (name="SIS_VIATURA")
/**
 * Classe que abstrai uma linha da tabela SIS_VIATURA
 * -Objeto relacional Viatura
 */
public class Viatura implements Serializable {	
	
	@Id @Column (name="VIA_CODIGO", length=4)
	/**
	 * Propriedade privada id
	 * Representa o identificador do registro na tabela
	 */
	private String codigo;
	
	@Basic @Column (name="VIA_OCUPADA", nullable=false)
	/**
	 * Propriedade privada ocupada
	 * Representa a coluna ocupada da tabela
	 */
	private boolean ocupada = false;
	
	@Basic @Column (name="VIA_ATIVO", nullable=false)
	/**
	 * Propriedade privada ativo
	 * Representa a coluna ativo da tabela
	 */
	private boolean ativo = false;
	
	@OneToMany(mappedBy = "viatura")  
	 /**
	 * Propriedade privada viaturas
	 * Respons�vel por representar os relacionamentos
	 */
	private List<Coordenada> coordenadas;
	
	@ManyToMany(mappedBy = "viaturas")
	 /**
	 * Propriedade privada escalas
	 * Respons�vel por representar os relacionamentos
	 */
	private List<Escala> escalas;
		

	/**
	 * M�todo para convers�o de objeto ViaturaVO para Viatura
	 */
	public Viatura(ViaturaVO vo) {
		this.codigo = vo.getCodigo();
		this.ocupada = vo.getOcupada();
		this.ativo = vo.getAtivo();
	}
	
	/**
	 * M�todo para convers�o de objeto Viatura para ViaturaVO
	 * @param Viatura obj
	 * @return ViaturaVO
	 */
	public static ViaturaVO VO(Viatura obj){
		return new ViaturaVO(obj.getCodigo(), obj.getOcupada(), obj.getAtivo());
	}

	/**
	 * Construtor default da classe
	 */
	public Viatura()
	{
		
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param String codigo
	 */
	public Viatura(String codigo)
	{
		setCodigo(codigo);
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param String codigo
	 * @param Boolean ocupada
	 */
	public Viatura(String codigo, Boolean ocupada)
	{
		setCodigo(codigo);
		setOcupada(ocupada);
	}
	
	/**
	 * M�todo getter da propriedade privada codigo
	 * @return String
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo getter da propriedade privada codigo
	 * @param String codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade privada ocupado
	 * @return boolean
	 */
	public boolean getOcupada() {
		return ocupada;
	}
	
	/**
	 * M�todo setter da propriedade privada ocupado
	 * @param boolean ocupada
	 */
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	/**
	 * M�todo getter da propriedade privada ativo
	 * @return boolean
	 */
	public boolean getAtivo() {
		return ativo;
	}
	
	/**
	 * M�todo setter da propriedade privada ativo
	 * @param boolean ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * M�todo setter da propriedade privada coordenadas
	 * @param List<Coordenada> coordenadas
	 */
	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	/**
	 * M�todo getter da propriedade privada coordenadas
	 * @return List<Coordenada>
	 */
	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}
	
	/**
	 * M�todo setter da propriedade privada escalas
	 * @param List<Escala> escalas
	 */
	public void setEscalas(List<Escala> escalas) {
		this.escalas = escalas;
	}
	/**
	 * M�todo getter da propriedade privada escalas
	 * @return List<Escala>
	 */
	public List<Escala> getEscalas() {
		return escalas;
	}

	
}
