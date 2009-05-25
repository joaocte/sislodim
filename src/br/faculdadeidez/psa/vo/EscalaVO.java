package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class EscalaVO implements Serializable {	
	private int codigo;
	private SetorVO setor = new SetorVO();
	private Date dataInicial;
	private Date dataFinal;
	private boolean ativo;
	List<ViaturaVO> viaturas;
	
	public EscalaVO(){
		
	}
	
	public EscalaVO(int codigo){
		setCodigo(codigo);
	}
	
	public EscalaVO(int codigo, SetorVO setor, Date dataInicial, Date dataFinal, List<ViaturaVO> viaturas, boolean ativo) {
		setCodigo(codigo);	
		setSetor(setor);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setViaturas(viaturas);
		setAtivo(ativo);
	}
	
	public List<ViaturaVO> getViaturas() {
		return viaturas;
	}

	public void setViaturas(List<ViaturaVO> viaturas) {
		this.viaturas = viaturas;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public SetorVO getSetor() {
		return setor;
	}

	public void setSetor(SetorVO setor) {
		this.setor = setor;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean getAtivo() {
		return ativo;
	}	
}
