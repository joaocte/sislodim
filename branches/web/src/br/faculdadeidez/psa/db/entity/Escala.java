package br.faculdadeidez.psa.db.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.faculdadeidez.psa.db.dao.DAOViatura;
import br.faculdadeidez.psa.vo.EscalaVO;
import br.faculdadeidez.psa.vo.ViaturaVO;

@SuppressWarnings("serial")
@Entity 
@Table (name="SIS_ESCALA")
/**
 * Classe que abstrai uma linha da tabela SIS_ESCALA
 * -Objeto relacional Escala
 */
public class Escala implements Serializable {	
		
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column (name="ESC_CODIGO")
	/**
	 * Propriedade privada id
	 * Representa o identificador do registro na tabela
	 */
	private int codigo;
	
	@ManyToOne
	@JoinColumn (name="ESC_SET_CODIGO", nullable=false)
	/**
	 * Propriedade privada setor
	 * Respons�vel por representar os relacionamentos
	 */
	private Setor setor;	
	
	@Basic @Temporal(value = TemporalType.TIMESTAMP) @Column (name="ESC_DATA_INC", nullable=false)
	/**
	 * Propriedade privada dataInicial
	 * Representa a coluna dataInicial da tabela
	 */
	private Date dataInicial;
	
	@Basic @Temporal(value = TemporalType.TIMESTAMP) @Column (name="ESC_DATA_FIM", nullable=false)
	/**
	 * Propriedade privada dataFinal
	 * Representa a coluna dataFinal da tabela
	 */
	private Date dataFinal;   
	
	@Basic @Column (name="ESC_ATIVO", nullable=false)
	/**
	 * Propriedade privada ativo
	 * Representa a coluna ativo da tabela
	 */
	private boolean ativo; 
	
	@ManyToMany(cascade={CascadeType.ALL} )
    @JoinTable(name="SIS_ESCALA_VIATURA",
            joinColumns=
                @JoinColumn(name="ESV_ESC_CODIGO", referencedColumnName="ESC_CODIGO"),
            inverseJoinColumns=
                @JoinColumn(name="ESV_VIA_CODIGO", referencedColumnName="VIA_CODIGO")
            )	
     /**
	 * Propriedade privada viaturas
	 * Respons�vel por representar os relacionamentos
	 */
    private List<Viatura> viaturas;	
	

	/**
	 * M�todo para convers�o de objeto EscalaVO para Escala
	 */
	public Escala(EscalaVO vo) {
		this.codigo = vo.getCodigo();
		this.setor = new Setor(vo.getSetor());
		this.dataInicial = vo.getDataInicial();
		this.dataFinal = vo.getDataFinal();
		this.ativo = vo.getAtivo();
		this.viaturas = new DAOViatura().ConverteEntidade(vo.getViaturas());
	}
	
	/**
	 * M�todo para convers�o de objeto Escala oara EscalaVO
	 * @param Escala obj
	 * @return EscalaVO
	 */
	public static EscalaVO VO(Escala obj){
		return new EscalaVO(obj.getCodigo(), Setor.VO(obj.getSetor()), obj.getDataInicial(), obj.getDataFinal(),getViaturasVO(obj.getViaturas()),obj.getAtivo());
	}
	
	/**
	 * Construtor default da classe
	 */
	public Escala() {
		 
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param int codigo
	 */
	public Escala(int codigo)
	{
		setCodigo(codigo);
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param int codigo
	 * @param Setor setor
	 * @param Date dataInicial
	 * @param Date dataFinal
	 * @param boolean ativo
	 * @param List<Viatura> viaturas
	 */
	public Escala(int codigo, Setor setor, Date dataInicial, Date dataFinal, boolean ativo, List<Viatura> viaturas) {
		setCodigo(codigo);	
		setSetor(setor);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setAtivo(ativo);
		setViaturas(viaturas);
	}
	
	/**
	 * M�todo getter da propriedade privada codigo
	 * @return int
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo getter da propriedade privada codigo
	 * @param int codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getter da propriedade privada setor
	 * @return Setor
	 */
	public Setor getSetor() {
		return setor;
	}
	
	/**
	 * M�todo setter da propriedade privada setor
	 * @param Setor setor
	 */
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	/**
	 * M�todo getter da propriedade privada dataInicial
	 * @return Date
	 */
	public Date getDataInicial() {
		return dataInicial;
	}
	
	/**
	 * M�todo setter da propriedade privada dataInicial
	 * @param Date dataInicial
	 */
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	/**
	 * M�todo getter da propriedade privada dataFinal
	 * @return Date
	 */
	public Date getDataFinal() {
		return dataFinal;
	}
	
	/**
	 * M�todo setter da propriedade privada dataFinal
	 * @param Date dataFinal
	 */
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}	
	
	/**
	 * M�todo getter da propriedade privada viaturas
	 * @return List<Viaturas>
	 */
	public List<Viatura> getViaturas() {
		return viaturas;
	}
	
	/**
	 * M�todo setter da propriedade privada viaturas
	 * @param List<Viatura> viaturas
	 */
	public void setViaturas(List<Viatura> viaturas) {
		this.viaturas = viaturas;
	}
	
	/**
	 * M�todo setter da propriedade privada ativo
	 * @param boolean ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * M�todo getter da propriedade privada ativo
	 * @return boolean
	 */
	public boolean getAtivo() {
		return ativo;
	}
	
	/**
	 * M�todo para convers�o de objeto List<Viaturas> para List<ViaturasVO>
	 * @param List<Viatura> viaturas
	 * @return List<ViaturaVO>
	 */
	private static List<ViaturaVO> getViaturasVO(List<Viatura> viaturas){
		List<ViaturaVO> viaturasVO = new ArrayList<ViaturaVO>();
		for (Viatura viatura : viaturas) {
			viaturasVO.add( Viatura.VO(viatura));
		}
		return viaturasVO;
		
	}
}