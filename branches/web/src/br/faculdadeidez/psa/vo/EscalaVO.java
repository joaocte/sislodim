package br.faculdadeidez.psa.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class EscalaVO implements Serializable {	
	private int codigo;
	private int setor;
	private Date dataInicial;
	private Date dataFinal;
		
	public EscalaVO(){
		
	}
	
	public EscalaVO(int codigo){
		setCodigo(codigo);
	}
	
	public EscalaVO(int codigo, int setor, Date dataInicial, Date dataFinal) {
		setCodigo(codigo);	
		setSetor(setor);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
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
}
