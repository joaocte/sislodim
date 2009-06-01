package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Classe respons�vel por transportar objetoSetorVO
 * entre as camadas.
 */
@SuppressWarnings("serial")
public class ViaturaVO implements Serializable {
	
	/**
	 * Propriedade privada codigo
	 */
	private String codigo;
	/**
	 * Propriedade privada ocupado
	 */
	private boolean ocupada;
	
	/**
	 * Propriedade privada ativo
	 */
	private boolean ativo;
	
	/**
	 * Respons�vel por referenciar os Objeto Escala relacionado com  Viatura no banco
	 */
	private List<EscalaVO> escalas;
	
	/**
	 * Respons�vel por referenciar os Objeto Coordenada relacionado com Viatura no banco
	 */
	private List<CoordenadaVO> coordenadas;
	
	/**
	 * Construtor da classe
	 */
	public ViaturaVO(){
		super();
		this.ativo = false;
		this.ocupada = false;
	}
	
	/**
	 * Sobrecarga do construtor padr�o
	 * @param String codigo
	 */
	public ViaturaVO(String codigo){
		setCodigo(codigo);
	}
	
	/**
	 * Sobrecarga do construtor padr�o
	 * @param String codigo
	 * @param boolean ocupada
	 * @param boolean ativo
	 */
	public ViaturaVO(String codigo, boolean ocupada, boolean ativo){
		setCodigo(codigo);
		setOcupada(ocupada);
		setAtivo(ativo);
	}
	
	/**
	 * M�todo getter da propriedade codigo
	 * @return String codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo setter da propriedade codigo
	 * @param int codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade ocupada
	 * @return boolean ocupada
	 */
	public boolean getOcupada() {
		return ocupada;
	}
	
	/**
	 * M�todo setter da propriedade ocupada
	 * @param boolean ocupada
	 */
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	/**
	 * M�todo getter da propriedade ativo
	 * @return boolean ativo
	 */
	public boolean getAtivo() {
		return ativo;
	}
	
	/**
	 * M�todo setter da propriedade ativo
	 * @param boolean ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * M�todo getter da propriedade escalas
	 * @return List<EscalaVO> escalas
	 */
	public List<EscalaVO> getEscalas() {
		return escalas;
	}
	
	/**
	 * M�todo setter da propriedade escalas
	 * @param List<EscalaVO> escalas
	 */
	public void setEscalas(List<EscalaVO> escalas) {
		this.escalas = escalas;
	}
	
	/**
	 * M�todo setter da propriedade coordenadas
	 * @param List<CoordenadaVO> coordenadas
	 */
	public void setCoordenadas(List<CoordenadaVO> coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	/**
	 * M�todo getter da propriedade coordenada
	 * @return List<CoordenadaVO> 
	 */
	public List<CoordenadaVO> getCoordenadas() {
		return coordenadas;
	}
}
