package br.faculdadeidez.psa.businesslogic;

import java.util.List;

import br.faculdadeidez.psa.db.dao.DAOBairro;

import br.faculdadeidez.psa.vo.BairroVO;
/**
 * Classe que implementa regras de neg�cio referente a Entidade Bairro
 * Abstrai a camada de persistencia JPA e realiza valida��es de neg�cio 
 */
public class BairroBusinessLogic {
	
	/**
	 * M�todo para deletar um objeto Bairro
	 * @param BairroVO vo -> objeto a ser removido do banco
	 * @return String -> indica sucesso ou falha 
	 */
	public String delete(BairroVO vo){
		try {
			DAOBairro dBairro = new DAOBairro();
			BairroVO set = dBairro.find(vo.getCodigo());			
			dBairro.remove(set);
			return "removido";
		} catch (Exception e) {
			return "problemaRemover";
		}
	}
	
	/**
	 * M�todo para atualizar um objeto Bairro
	 * @param BairroVo vo
	 * @return String
	 */
	public String update(BairroVO vo){
		try {
			DAOBairro dBairro = new DAOBairro();							
			dBairro.update(vo);
			return "atualizado";
		} catch (Exception e) {
			 
			return "problemaAtualizar";
		}
	}
	
	/**
	 * M�todo para criar um objeto Bairro
	 * @param BairroVO vo
	 * @return String
	 */
	public String create(BairroVO vo){
		try {
			DAOBairro dBairro = new DAOBairro();
			dBairro.persist(vo);
			return "inserido";
		} catch (Exception e) {
			 
			return "problemaInserir";
		}
	}
	
	/**
	 * M�todo para listar todos os Bairros
	 * @return List<BairroVO>
	 */
	public List<BairroVO> listar(){
		DAOBairro dBairro = new DAOBairro();
		return dBairro.findAll();		
	}
	
	/**
	 * M�todo para buscar um objeto Bairro id
	 * @param int chave 
	 * @return BairroVO
	 */
	public BairroVO find(int chave){
		return new DAOBairro().find(chave);
	}
	
	/**
	 * M�todo para buscar um objeto Bairro por nome
	 * @param String nome
	 * @return BairroVO
	 */
	public BairroVO findNome(String nome){
		DAOBairro dBairro = new DAOBairro();
		return dBairro.findByField("nome", nome).get(0);
	}
}
