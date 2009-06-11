package br.faculdadeidez.psa.apresentacao.managedbean;

import br.faculdadeidez.psa.servico.GoogleMaps;
import br.faculdadeidez.psa.vo.BairroVO;

/**
 * ManagedBean de coordenada
 * @author Samuel
 *
 */
public class CoordenadaBean extends GenericoBean{
	
	/**
	 * Respons�vel por armazenar o nome do bairro
	 */
	private String bairro="";
	/**
	 * Respons�vel por armazenar o nome da rua
	 */
	private String rua="";
	/**
	 * Respons�vel por armazenar o n�mero
	 */
	private String numero;
	/**
	 * Respons�vel por armazenar o conte�do do googleMaps
	 */
	private GoogleMaps gmaps;
	
	/**
	 * M�todo getter do atributo bairro
	 * @return String
	 */
	public String getBairro() {
		BairroVO bairroVO = getFachada().pesquisaBairroNome(this.bairro);
		return String.valueOf(bairroVO.getCodigo());
	}
	/**
	 * M�todo setter do atributo bairro
	 * @param bairro String
	 */
	public void setBairro(String bairro) {
		BairroVO bairroVO = getFachada().pesquisaBairro(Integer.parseInt(bairro));
		this.bairro = bairroVO.getNome();
	}
	/**
	 * M�todo getter do atributo rua
	 * @return String
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * M�todo setter do atributo rua
	 * @param rua String
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	/**
	 * M�todo respons�vel por enviar os dados a serem calculados para trazer a viatura desocupada mais pr�xima da ocorr�ncia
	 */
	public String calculaPontoMaisProximo(){
		StringBuffer destino= new StringBuffer();
		destino.append(this.rua);
		destino.append(",");
		destino.append(this.bairro);
		destino.append(",");
		destino.append("Jo�o Pessoa");
		this.gmaps=getFachada().calculaViaturaMaisProxima(destino.toString());
		if (this.gmaps.getMsgErro()!=null){
			if (gmaps.getMsgErro().equals("ViaturasOcupadas"))
				adicionarMensagemErro("Todas as viaturas est�o indispon�veis");
			else
				adicionarMensagemErro("Endere�o n�o encontrado");
		}else{
			adicionarMensagem("A viatura " +this.gmaps.getViatura().getCodigo()+" sair� do ponto A ("+this.gmaps.getEnderecoCompletoOrigem()+") para o ponto B ("+this.gmaps.getEnderecoCompletoDestino()+")"+" percorrendo "+this.gmaps.getDistancia()+" em "+this.gmaps.getTempo());
		}
		
		return "viaturaProxima";
	}
	/**
	 * M�todo setter do atributo gmaps
	 * @param gmaps GoogleMaps
	 */
	public void setGmaps(GoogleMaps gmaps) {
		this.gmaps = gmaps;
	}
	/**
	 * M�todo getter do atributo gmaps
	 * @return GoogleMaps
	 */
	public GoogleMaps getGmaps() {
		return gmaps;
	}
	/**
	 * M�todo setter do atributo numero
	 * @param numero String
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * M�todo getter do atributo numero
	 * @return String
	 */
	public String getNumero() {
		return numero;
	}

}
