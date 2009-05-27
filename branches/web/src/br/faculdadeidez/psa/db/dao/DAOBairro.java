package br.faculdadeidez.psa.db.dao;

import java.util.List;
import java.util.Vector;

import br.faculdadeidez.psa.db.entity.Bairro;
import br.faculdadeidez.psa.vo.BairroVO;
/**
 * Classe onde cont�m as opera��es espec�ficas com banco de dados para entidade Bairro
 *
 */
public class DAOBairro extends DAOFactory<Bairro> {
	/**
	 * Construtor default
	 */
	public DAOBairro() {
		super();
	}
	
	/**
	 * Encapsulamento do m�todo find gen�rico
	 * Recebe a chave do objeto e procura a chave no banco de dados retornando uma entidade
	 * @param chave int
	 * @return BairroVO
	 */
	public BairroVO find(int chave){		
		return Bairro.VO(super.find(Bairro.class, chave));
	}
	/**
	 * Encapsulamento do m�todo findByField gen�rico
	 * Recebe o nome do campo e o valor a ser pesquisado nele
	 * @param campo String
	 * @param valor String
	 * @return BairroVO
	 */
	public List<BairroVO> findByField(String campo, String valor){
		return ConvertList(super.findByField(Bairro.class, campo, valor));
	}
	
	/**
	 * Encapsulamento do m�todo findAll gen�rico
	 * Retorna todas as entidades como um select * from
	 * @return List<BairroVO>
	 */
	public List<BairroVO> findAll(){
		return ConvertList(super.findAll(Bairro.class));
	}
	/**
	 * Encapsulamento do m�todo update gen�rico
	 * Atualiza a entidade no banco de dados
	 * @param vo BairroVO
	 */
	public void update(BairroVO vo){		
		super.update(new Bairro(vo));
	}
	/**
	 * Encapsulamento do m�todo persist gen�rico
	 * Insere a entidade no banco de dados
	 * @param vo BairroVO
	 */
	public void persist(BairroVO vo){		
		super.persist(new Bairro(vo));
	}
	/**
	 * Encapsulamento do m�todo remove gen�rico
	 * Remove a linha do banco de dados
	 * @param vo BairroVO
	 */
	public void remove(BairroVO vo){		
		super.remove(new Bairro(vo));
	}
	
	/**
	 * M�todo que converte uma lista de entidades Bairro em BairroVO
	 * @param lista List<Bairro>
	 * @return List<BairroVO>
	 */
	public List<BairroVO> ConvertList(List<Bairro> lista)
	{
		List<BairroVO> newLista = new Vector<BairroVO>();
		for(Bairro set : lista)
			newLista.add(Bairro.VO(set));		
		return newLista;
	}
	/**
	 * M�todo que converte uma lista de Value Object de bairro em entidades Bairro
	 * @param lista List<BairroVO>
	 * @return List<Bairro>
	 */
	public List<Bairro> ConverteEntidade(List<BairroVO> lista)
	{
		List<Bairro> newLista = new Vector<Bairro>();
		for(BairroVO bairro : lista)
			newLista.add(super.find(Bairro.class, bairro.getCodigo()));
		return newLista;
	}
}
