package br.faculdadeidez.psa.apresentacao.managedbean;

import br.faculdadeidez.psa.servico.ComparacaoDistanciaException;
import br.faculdadeidez.psa.servico.GoogleMaps;
import br.faculdadeidez.psa.vo.BairroVO;

public class CoordenadaBean extends GenericoBean{
	
	private String bairro="";
	private String rua="";
	private String nomeBairro;
	private String numero;
	private GoogleMaps gmaps;
	
	
	public String getBairro() {
		BairroVO bairroVO = getFachada().pesquisaBairroNome(this.bairro);
		return String.valueOf(bairroVO.getCodigo());
	}
	public void setBairro(String bairro) {
		BairroVO bairroVO = getFachada().pesquisaBairro(Integer.parseInt(bairro));
		this.bairro = bairroVO.getNome();
		this.nomeBairro = bairroVO.getNome();
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void calculaPontoMaisProximo() throws NumberFormatException, ComparacaoDistanciaException{
		StringBuffer origem= new StringBuffer();
		origem.append(this.rua);
		origem.append(",");
		origem.append(this.bairro);
		origem.append(",");
		origem.append("Jo�o Pessoa");
		this.gmaps=getFachada().calculaViaturaMaisProxima(origem.toString());
	}
	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}
	public String getNomeBairro() {
		return nomeBairro;
	}
	public void setGmaps(GoogleMaps gmaps) {
		this.gmaps = gmaps;
	}
	public GoogleMaps getGmaps() {
		return gmaps;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumero() {
		return numero;
	}

}
