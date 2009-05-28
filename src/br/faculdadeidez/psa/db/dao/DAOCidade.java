package br.faculdadeidez.psa.db.dao;

import java.util.List;
import java.util.Vector;

import br.faculdadeidez.psa.db.entity.Cidade;
import br.faculdadeidez.psa.vo.CidadeVO;
/**
 * Classe que cont�m todos os m�todos espec�ficos de Cidade
 *
 */
public class DAOCidade extends DAOFactory<Cidade> {
	/**
	 * Construtor default
	 */
	public DAOCidade() {
		super();
	}
	/**
	 * Encapsulamento do m�todo find gen�rico
	 * Recebe a chave do objeto e procura a chave no banco de dados retornando uma entidade
	 * @param chave int
	 * @return CidadeVO
	 */
	public CidadeVO find(int chave){		
		return Cidade.VO(super.find(Cidade.class, chave));
	}
	
	/**
	 * Encapsulamento do m�todo findByField gen�rico
	 * Recebe o nome do campo e o valor a ser pesquisado nele
	 * @param campo String
	 * @param valor String
	 * @return List<CidadeVO>
	 */
	public List<CidadeVO> findByField(String campo, String valor){
		return ConvertList(super.findByField(Cidade.class, campo, valor));
	}
	
	/**
	 * Encapsulamento do m�todo findAll gen�rico
	 * Retorna todas as entidades como um select * from
	 * @return List<CidadeVO>
	 */
	public List<CidadeVO> findAll(){
		return ConvertList(super.findAll(Cidade.class));
	}
	/**
	 * Encapsulamento do m�todo update gen�rico
	 * Atualiza a entidade no banco de dados
	 * @param vo CidadeVO
	 */
	public void update(CidadeVO vo){		
		super.update(new Cidade(vo));
	}
	/**
	 * Encapsulamento do m�todo persist gen�rico
	 * Insere a entidade no banco de dados
	 * @param vo CidadeVO
	 */
	public void persist(CidadeVO vo){		
		super.persist(new Cidade(vo));
	}
	
	/**
	 * Encapsulamento do m�todo remove gen�rico
	 * Remove a linha do banco de dados
	 * @param vo CidadeVO
	 */
	public void remove(CidadeVO vo){		
		super.remove(new Cidade(vo));
	}
	
	/**
	 * M�todo que converte uma lista de entidades em Value Object
	 * @param lista List<Cidade>
	 * @return List<CidadeVO>
	 */
	public List<CidadeVO> ConvertList(List<Cidade> lista)
	{
		List<CidadeVO> newLista = new Vector<CidadeVO>();
		for(Cidade set : lista)
			newLista.add(Cidade.VO(set));		
		return newLista;
	}
	
	/**
	 * M�todo que converte uma lista de Value Object em entidades
	 * @param lista List<CidadeVO>
	 * @return List<Cidade>
	 */
	public List<Cidade> ConverteEntidade(List<CidadeVO> lista)
	{
		List<Cidade> newLista = new Vector<Cidade>();
		for(CidadeVO cidade : lista)
			newLista.add(super.find(Cidade.class, cidade.getCodigo()));
		return newLista;
	}
}
