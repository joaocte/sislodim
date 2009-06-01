package br.faculdadeidez.psa.db.entity;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.faculdadeidez.psa.db.dao.DAOBairro;
import br.faculdadeidez.psa.vo.SetorVO;

@SuppressWarnings("serial")
@Entity 
@Table (name="SIS_SETOR")
/**
 * Classe que abstrai uma linha da tabela SIS_SETOR
 * -Objeto relacional Setor
 */
public class Setor implements Serializable {	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column (name="SET_CODIGO")
	/**
	 * Propriedade privada id
	 * Representa o identificador do registro na tabela
	 */
	private int codigo;
	
	@Basic @Column (name="SET_NOME", nullable=false, length=100) 
	/**
	 * Propriedade privada nome
	 * Representa a coluna nome da tabela
	 */
	private String nome;
	
    @ManyToMany(cascade={CascadeType.ALL} )
    @JoinTable(name="SIS_BAIRRO_SETOR",
            joinColumns=
                @JoinColumn(name="BAS_SET_CODIGO", referencedColumnName="SET_CODIGO"),
            inverseJoinColumns=
                @JoinColumn(name="BAS_BAI_CODIGO", referencedColumnName="BAI_CODIGO")
            )	
    /**
	 * Propriedade privada bairros
	 * Respons�vel por representar os relacionamentos
	 */
    private List<Bairro> bairros;
    
    @Basic @Column( name="SET_ATIVO", nullable=false)
    /**
	 * Propriedade privada ativo
	 * Representa a coluna ativo da tabela
	 */
	private boolean ativo;
    
    @OneToMany(mappedBy = "setor")
    /**
	 * Propriedade privada escalas
	 * Respons�vel por representar os relacionamentos
	 */
    private List<Escala> escalas;
    
    /**
     * M�todo getter da propriedade privada bairros
     * @return List<Bairro>
     */
	public List<Bairro> getBairros() {
		return bairros;
	}

	/**
	 * M�todo setter da propriedade privada bairros
	 * @param List<Bairro> bairros
	 */
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	/**
	 * M�todo para convers�o de objeto SetorVO para Setor
	 */
	public Setor(SetorVO vo) {
		this.codigo = vo.getCodigo();
		this.nome = vo.getNome();
		this.ativo = vo.getAtivo();
		this.bairros = new DAOBairro().ConverteEntidade(vo.getBairros());
	}
	
	/**
	 * M�todo para convers�o de objeto Setor para SetorVO
	 * @param Setor obj
	 * @return SetorVO
	 */
	public static SetorVO VO(Setor obj){
		SetorVO setorVO = new SetorVO();
		
		setorVO.setAtivo(obj.getAtivo());
		setorVO.setCodigo(obj.getCodigo());
		setorVO.setNome(obj.getNome());
		setorVO.setBairros(new DAOBairro().ConvertList(obj.getBairros()));
		
		return setorVO;
	}

	/**
	 * Construtor default da classe
	 */
	public Setor() {
		 
	}
	
	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param String nome
	 */
	public Setor(String nome)
	{
		setNome(nome);
	}

	/**
	 * Sobrecarga do construtor padr�o da classe
	 * @param int codigo
	 * @param String nome
	 */
	public Setor(int codigo, String nome)
	{
		setCodigo(codigo);
		setNome(nome);
	}
	
	/**
	 * M�tdo getter da propriedade privada codigo
	 * @return int
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * M�tdo setter da propriedade privada codigo
	 * @param int codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�tdo getter da propriedade privada nome
	 * @return String
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�tdo setter da propriedade privada nome
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�tdo getter da propriedade privada ativo
	 * @return boolean
	 */
	public boolean getAtivo() {
		return ativo;
	}
	
	/**
	 * M�tdo setter da propriedade privada ativo
	 * @param boolean ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * M�tdo setter da propriedade privada escalas
	 * @param List<Escala>escalas
	 */
	public void setEscalas(List<Escala> escalas) {
		this.escalas = escalas;
	}
	
	/**
	 * M�tdo getter da propriedade privada escalas
	 * @return List<Escala>
	 */
	public List<Escala> getEscalas() {
		return escalas;
	}

}