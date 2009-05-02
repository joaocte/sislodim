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
public class Setor implements Serializable {	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column (name="SET_CODIGO")
	private int codigo;
	@Basic @Column (name="SET_NOME", nullable=false, length=100) 
	private String nome;
    @ManyToMany(cascade={CascadeType.ALL} )
    @JoinTable(name="SIS_BAIRRO_SETOR",
            joinColumns=
                @JoinColumn(name="BAS_SET_CODIGO", referencedColumnName="SET_CODIGO"),
            inverseJoinColumns=
                @JoinColumn(name="BAS_BAI_CODIGO", referencedColumnName="BAI_CODIGO")
            )	
      
    private List<Bairro> bairros;
    @Basic @Column( name="SET_ATIVO", nullable=false)
	private boolean ativo;
    @OneToMany(mappedBy = "setor")
    private List<Escala> escalas;
    
	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	/*********************************************************/
	/******** Convers�o do objeto Setor para o SetorVO *******/
	/*********************************************************/
	public Setor(SetorVO vo) {
		this.codigo = vo.getCodigo();
		this.nome = vo.getNome();
		this.ativo = vo.getAtivo();
		this.bairros = new DAOBairro().ConverteEntidade(vo.getBairros());
	}
	
	public static SetorVO VO(Setor obj){
		SetorVO setorVO = new SetorVO();
		
		setorVO.setAtivo(obj.getAtivo());
		setorVO.setCodigo(obj.getCodigo());
		setorVO.setNome(obj.getNome());
		setorVO.setBairros(new DAOBairro().ConvertList(obj.getBairros()));
		
		return setorVO;
	}
	/*********************************************************/
	
	public Setor() {
		 
	}
	
	public Setor(String nome)
	{
		setNome(nome);
	}

	public Setor(int codigo, String nome)
	{
		setCodigo(codigo);
		setNome(nome);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setEscalas(List<Escala> escalas) {
		this.escalas = escalas;
	}

	public List<Escala> getEscalas() {
		return escalas;
	}

}