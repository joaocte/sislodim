package br.faculdadeidez.psa.servico;

import br.faculdadeidez.psa.vo.ViaturaVO;
/**
 * Classe que armazena os dados retornados do servi�o do google maps
 *
 */
public class GoogleMaps {

	/**
	 * Propriedade que armazena a dist�ncia entre os pontos
	 */
	private String distancia = null;
	/**
	 * Propriedade que armazena a dist�ncia entre os pontos em um tipo double
	 */
	private Double distanciaReal;
	/**
	 * Propriedade que armazena o tempo a ser percorrido
	 */
	private String tempo = null;
	/**
	 * Propriedade que armazena a viatura do percurso
	 */
	private ViaturaVO viatura;
	/**
	 * Propriedade que armazena o pa�s de origem
	 */
	private String paisOrigem = null;
	/**
	 * Propriedade que armazena o pa�s de destino
	 */
	private String paisDestino = null;
	
	/**
	 * Propriedade que armazena o munic�pio de origem
	 */
	private String municipioOrigem = null;
	/**
	 * Propriedade que armazena o munic�pio de destino
	 */
	private String municipioDestino = null;
	/**
	 * Propriedade que armazena o endere�o de origem
	 */
	private String enderecoOrigem = null;
	/**
	 * Propriedade que armazena o endere�o de destino
	 */
	private String enderecoDestino = null;
	
	/**
	 * Propriedade que armazena o cep de origem
	 */
	private String cepOrigem = null;
	/**
	 * Propriedade que armazena o cep de destino
	 */
	private String cepDestino = null;
	
	/**
	 * Propriedade que armazena a latitude de origem
	 */
	private String latitudeOrigem = null;
	/**
	 * Propriedade que armazena o latitude de destino
	 */
	private String latitudeDestino = null;
	/**
	 * Propriedade que armazena a longitude de origem
	 */
	private String longitudeOrigem = null;
	/**
	 * Propriedade que armazena a longitude de destino
	 */
	private String longitudeDestino = null;
	/**
	 * Propriedade que armazena o endere�o completo da origem
	 */
	private String enderecoCompletoOrigem = null;
	/**
	 * Propriedade que armazena o endere�o completo do destino
	 */
	private String enderecoCompletoDestino = null;
	/**
	 * Propriedade que armazena poss�vel mensagem de erro
	 */
	private String msgErro = null;
	/**
	 * Propriedade que armazena poss�vel mensagem de sucesso
	 */
	private String msgSucesso = null;

	/**
	 * Construtor default
	 */
	public GoogleMaps() {
		
	}
	
	/**
	 * M�todo getter do atributo distanciaReal
	 * @return Double
	 */
	public Double getDistanciaReal() { 
		return distanciaReal;
	}
	/**
	 * M�todo setter do atributo distanciaReal
	 * @param distanciaReal Double
	 */
	public void setDistanciaReal(Double distanciaReal) { 
		this.distanciaReal = distanciaReal;
	}
	/**
	 * M�todo getter do atributo distancia
	 * @return String
	 */
	public String getDistancia() {
		return distancia;
	}

	/**
	 * M�todo setter do atributo distancia
	 * @param distancia String
	 */
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	/**
	 * M�todo getter do atributo tempo
	 * @return String
	 */
	public String getTempo(){
		return this.tempo;
	}
	/**
	 * M�todo setter do atributo tempo
	 * @param tempo String
	 */
	public void setTempo(String tempo){
		this.tempo = tempo;
	}
	/**
	 * M�todo getter do atributo msgErro
	 * @return String
	 */
	public String getMsgErro() {
		return msgErro;
	}
	/**
	 * M�todo setter do atributo msgErro
	 * @param msgErro String
	 */
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
	/**
	 * M�todo getter do atributo msgSucesso
	 * @return String
	 */
	public String getMsgSucesso() {
		return msgSucesso;
	}
	/**
	 * M�todo setter do atributo msgSucesso
	 * @param msgSucesso String
	 */
	public void setMsgSucesso(String msgSucesso) {
		this.msgSucesso = msgSucesso;
	}
	/**
	 * M�todo getter do atributo municipioOrigem
	 * @return String
	 */
	public String getMunicipioOrigem() {
		return municipioOrigem;
	}

	/**
	 * M�todo setter do atributo municipioOrigem
	 * @param municipioOrigem String
	 */
	public void setMunicipioOrigem(String municipioOrigem) {
		this.municipioOrigem = municipioOrigem;
	}

	/**
	 * M�todo getter do atributo municipioDestino
	 * @return String
	 */
	public String getMunicipioDestino() {
		return municipioDestino;
	}

	/**
	 * M�todo setter do atributo municipioDestino
	 * @param municipioDestino String
	 */
	public void setMunicipioDestino(String municipioDestino) {
		this.municipioDestino = municipioDestino;
	}
	/**
	 * M�todo getter do atributo enderecoOrigem
	 * @return String
	 */
	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	/**
	 * M�todo setter do atributo enderecoOrigem
	 * @param enderecoOrigem String
	 */
	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	/**
	 * M�todo getter do atributo enderecoDestino
	 * @return String
	 */
	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	/**
	 * M�todo setter do atributo enderecoDestino
	 * @param enderecoDestino String
	 */
	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	/**
	 * M�todo getter do atributo latitudeOrigem
	 * @return String
	 */
	public String getLatitudeOrigem() {
		return latitudeOrigem;
	}

	/**
	 * M�todo setter do atributo latitudeOrigem
	 * @param latitudeOrigem String
	 */
	public void setLatitudeOrigem(String latitudeOrigem) {
		this.latitudeOrigem = latitudeOrigem;
	}

	/**
	 * M�todo getter do atributo latitudeDestino
	 * @return String
	 */
	public String getLatitudeDestino() {
		return latitudeDestino;
	}

	/**
	 * M�todo setter do atributo latitudeDestino
	 * @param latitudeDestino String
	 */
	public void setLatitudeDestino(String latitudeDestino) {
		this.latitudeDestino = latitudeDestino;
	}

	/**
	 * M�todo getter do atributo longitudeOrigem
	 * @return String
	 */
	public String getLongitudeOrigem() {
		return longitudeOrigem;
	}

	/**
	 * M�todo setter do atributo longitudeOrigem
	 * @param longitudeOrigem String
	 */
	public void setLongitudeOrigem(String longitudeOrigem) {
		this.longitudeOrigem = longitudeOrigem;
	}

	/**
	 * M�todo getter do atributo longitudeDestino
	 * @return String
	 */
	public String getLongitudeDestino() {
		return longitudeDestino;
	}

	/**
	 * M�todo setter do atributo longitudeDestino
	 * @param longitudeDestino String
	 */
	public void setLongitudeDestino(String longitudeDestino) {
		this.longitudeDestino = longitudeDestino;
	}

	/**
	 * M�todo getter do atributo enderecoCompletoOrigem
	 * @return String
	 */
	public String getEnderecoCompletoOrigem() {
		return enderecoCompletoOrigem;
	}

	/**
	 * M�todo setter do atributo enderecoCompletoOrigem
	 * @param enderecoCompletoOrigem String
	 */
	public void setEnderecoCompletoOrigem(String enderecoCompletoOrigem) {
		this.enderecoCompletoOrigem = enderecoCompletoOrigem;
	}

	/**
	 * M�todo getter do atributo enderecoCompletoDestino
	 * @return String
	 */
	public String getEnderecoCompletoDestino() {
		return enderecoCompletoDestino;
	}

	/**
	 * M�todo setter do atributo enderecoCompletoDestino
	 * @param enderecoCompletoDestino String
	 */
	public void setEnderecoCompletoDestino(String enderecoCompletoDestino) {
		this.enderecoCompletoDestino = enderecoCompletoDestino;
	}

	/**
	 * M�todo getter do atributo cepOrigem
	 * @return String
	 */
	public String getCepOrigem() {
		return cepOrigem;
	}

	/**
	 * M�todo setter do atributo cepOrigem
	 * @param cepOrigem String
	 */
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	/**
	 * M�todo getter do atributo cepDestino
	 * @return String
	 */
	public String getCepDestino() {
		return cepDestino;
	}

	/**
	 * M�todo setter do atributo cepDestino
	 * @param cepDestino String
	 */
	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	/**
	 * M�todo getter do atributo paisOrigem
	 * @return String
	 */
	public String getPaisOrigem() {
		return paisOrigem;
	}

	/**
	 * M�todo setter do atributo paisOrigem
	 * @param paisOrigem String
	 */
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	/**
	 * M�todo getter do atributo paisDestino
	 * @return String
	 */
	public String getPaisDestino() {
		return paisDestino;
	}

	/**
	 * M�todo setter do atributo paisDestino
	 * @param paisDestino String
	 */
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}


	/**
	 * M�todo setter do atributo viatura
	 * @param viatura ViaturaVO
	 */
	public void setViatura(ViaturaVO viatura) {
		this.viatura = viatura;
	}


	/**
	 * M�todo getter do atributo viatura
	 * @return ViaturaVO
	 */
	public ViaturaVO getViatura() {
		return viatura;
	}
}
