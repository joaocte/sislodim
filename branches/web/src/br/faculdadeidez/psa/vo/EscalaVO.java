package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Classe respons�vel por transportar objetoEscala
 * entre as camadas.
 */
@SuppressWarnings("serial")
public class EscalaVO implements Serializable {
	
	/**
	 * Propriedade privada codigo
	 */
	private int codigo;
	
	/**
	 * Respons�vel por referenciar uma Objeto Setor no banco
	 */
	private SetorVO setor = new SetorVO();
	
	/**
	 * Propriedade privada dataInicial
	 * @deprecated
	 */
	private Date dataInicial;
	
	/**
	 * Propriedade privada dataFinal
	 * @deprecated
	 */
	private Date dataFinal;
	
	/**
	 * Propriedade privada ativo
	 */
	private boolean ativo;
	
	/**
	 * Respons�vel por referenciar os Objeto Viatura no banco 
	 */
	private List<ViaturaVO> viaturas;
	
	/**
	 * Construtor da classe
	 */
	public EscalaVO(){
		
	}
	
	
	/**
	 * Sobrecarga do contrutor padr�o
	 * @param int codigo
	 */
	public EscalaVO(int codigo){
		setCodigo(codigo);
	}
	
	/**
	 * Sobrecarga do contrutor padr�o
	 * @param int codigo
	 * @param Setor setor
	 * @param Date dataInicial
	 * @param Date dataFinal
	 * @param List<ViaturaVO> viaturas
	 * @param boolean ativo
	 */
	public EscalaVO(int codigo, SetorVO setor, Date dataInicial, Date dataFinal, List<ViaturaVO> viaturas, boolean ativo) {
		setCodigo(codigo);	
		setSetor(setor);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setViaturas(viaturas);
		setAtivo(ativo);
	}
	
	/**
	 * Retorna uma lista de viaturas da escala
	 * @return List<ViaturaVo> viaturas
	 */
	public List<ViaturaVO> getViaturas() {
		return viaturas;
	}
	
	/**
	 * M�todo setter da propriedade viaturas
	 * @param List<ViaturaVo> viaturas
	 */
	public void setViaturas(List<ViaturaVO> viaturas) {
		this.viaturas = viaturas;
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
	 * @param int codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade setor
	 * @return SetorVo setor
	 */
	public SetorVO getSetor() {
		return setor;
	}
	
	/**
	 * M�todo setter da propriedade setor
	 * @param SetorVO setor
	 */
	public void setSetor(SetorVO setor) {
		this.setor = setor;
	}
	
	/**
	 * M�todo getter da propriedade dataInicial
	 * @return Date dataInicial
	 */
	public Date getDataInicial() {
		return dataInicial;
	}
	
	/**
	 * M�todo setter da propriedade dataInicial
	 * @param Date dataInicial
	 */
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	/**
	 * M�todo getter da propriedade dataFinal
	 * @return Date dataFinal
	 */
	public Date getDataFinal() {
		return dataFinal;
	}
	
	/**
	 * M�todo setter da propriedade dataFinal
	 * @param Date dataFinal
	 */
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	/**
	 * M�todo setter da propriedade ativo
	 * @param boolean ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * M�todo getter da propriedade ativo
	 * @return boolean ativo
	 */
	public boolean getAtivo() {
		return ativo;
	}	
}
