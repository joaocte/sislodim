package br.faculdadeidez.psa.vo;


/**
 * Classe respons�vel por transportar objetoRotasPercorrida
 * entre as camadas.
 */
public class RotaPercorridaVO {
	
	/**
	 * Propriedade privada eSetor
	 */
	private boolean eSetor;
	
	/**
	 * Propriedade privada bairro
	 */
	private String bairro;
	
	/**
	 * Respons�vel por referenciar um Objeto Viatura no banco
	 */
	private ViaturaVO viatura;
	
	/**
	 * Propriedade privada data
	 */
	private String data;
	
	/**
	 * Propriedade privada horario
	 */
	private String horario;
	
	/**
	 * M�tdo setter da propriedade privada bairro
	 * @param bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	/**
	 * M�todo getter da propriedade viatura
	 * @return ViaturaVO viatura
	 */
	public ViaturaVO getViatura() {
		return viatura;
	}
	
	/**
	 * M�todo setter da propriedade viatura
	 * @param ViaturaVO viatura
	 */
	public void setViatura(ViaturaVO viatura) {
		this.viatura = viatura;
	}
	
	/**
	 * M�todo getter da propriedade data
	 * @return Date data
	 */
	public void setData(String string) {
		this.data = string;
	}

	/**
	 * M�todo IS da propriedade privada eSetor
	 * @return
	 */
	public boolean isESetor() {
		return eSetor;
	}

	/**
	 * M�todo setter da propriedade setor
	 * @param boolean setor
	 */
	public void setESetor(boolean setor) {
		eSetor = setor;
	}
	
	/**
	 * M�todo getter da propriedade horario
	 * @return String 
	 */
	public String getHorario() {
		return horario;
	}
	
	/**
	 * Retorna codigo da viatura
	 * @return String
	 */
	public String getCodViatura(){
		return viatura.getCodigo();
	}
	
	/**
	 * M�todo getter da propriedade privada data
	 * @return String
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * M�todo setter da propriedade privada horario
	 * @param String horario 
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

}
