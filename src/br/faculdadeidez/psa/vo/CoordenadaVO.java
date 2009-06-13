package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Classe respons�vel por transportar objetoCoordenada
 * entre as camadas.
 */
@SuppressWarnings("serial")
public class CoordenadaVO implements Serializable {
	/**
	 * Propriedade privada codigo
	 */
	private int codigo;
	
	/**
	 * Propriedade privada latitude
	 */
	private String latitude;
	
	/**
	 * Propriedade privada longitude
	 */
	private String longitude;
	
	/**
	 * Respons�vel por referenciar uma Objeto Viatura no banco
	 */
	private ViaturaVO viatura= new ViaturaVO() ;
	
	/**
	 * Propriedade privada locale
	 * Respons�vel por definir o padr�o do Calendar
	 */
	private Locale locBr = new Locale("pt","br"); 
	/**
	 * Propriedade privada data
	 */
	private Calendar data = Calendar.getInstance(locBr);
	
	/**
	 * Propriedade privada foradeArea
	 */
	private boolean foraDeArea;
	
	/**
	 * Propriedade privada processoVerificacao
	 */
	private boolean processadoVerificacao;
	
	/**
	 * Construtor da classe
	 */
	public CoordenadaVO(){
		
	}
	
	/**
	 * Sobrecarga do construtor padr�o
	 * @param String lat
	 * @param String longit
	 * @param ViaturaVO viatura
	 * @param Calendar data
	 * @param boolean foraDeArea
	 * @param int id
	 * @param processadoVerificacao
	 */
	public CoordenadaVO(String lat,String longit, ViaturaVO viatura, Calendar data, boolean foraDeArea, int id, boolean processadoVerificacao) {
		this.latitude = lat;
		this.longitude = longit;
		this.viatura = viatura;
		this.data = data;
		this.foraDeArea = foraDeArea;
		this.codigo = id;
		this.processadoVerificacao = processadoVerificacao;
	}
	
	/**
	 * M�todo getter da propriedade 
	 * @return int codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo setter da propridade codigo
	 * @param int codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade latitude
	 * @return String latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	
	/**
	 * M�todo setter da propridade lat
	 * @param String lat
	 */
	public void setLatitude(String lat) {
		this.latitude = lat;
	}
	
	/**
	 * M�todo getter da propriedade longitude
	 * @return String longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	
	/**
	 * M�todo is(boolean) da propriedade processadoVerificacao 
	 * @return boolean processadoVerificacao
	 */
	public boolean isProcessadoVerificacao() {
		return processadoVerificacao;
	}
	
	/**
	 * M�todo setter da propridade processadoVerifacao
	 * @param processadoVerificacao
	 */
	public void setProcessadoVerificacao(boolean processadoVerificacao) {
		this.processadoVerificacao = processadoVerificacao;
	}

	/**
	 * M�todo setter da propridade lat
	 * @param String lat
	 */
	public void setLongitude(String lat) {
		this.longitude = lat;
	}
	
	/**
	 * M�todo setter da propridade viatura
	 * @param Objetc<ViaturaVo> viatura
	 */
	public void setViatura(ViaturaVO viatura) {
		this.viatura = viatura;
	}
	
	
	public ViaturaVO getViatura() {
		return viatura;
	}
	
	/**
	 * M�todo setter da propridade data
	 * @param Date data
	 */
	public void setData(Date data) {
		this.data.setTime(data);
		//	this.data.set(data.getYear(), data.getMonth(), data.getDate(), data.getHours(),data.getMinutes());
	}
	
	/**
	 * M�todo getter da propridade data
	 * @return Date data
	 */
	public Calendar getData() {
		return data;
	}
	
	/**
	 * M�todo setter da propridade foraDeArea
	 * @param boolean foraDeArea
	 */
	public void setForaDeArea(boolean foraDeArea) {
		this.foraDeArea = foraDeArea;
	}
	
	/**
	 * M�todo getter da propridade foraDeArea
	 * @return boolean foraDeArea
	 */
	public boolean getForaDeArea() {
		return foraDeArea;
	}

}
