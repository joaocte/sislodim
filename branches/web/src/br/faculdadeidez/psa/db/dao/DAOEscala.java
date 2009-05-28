package br.faculdadeidez.psa.db.dao;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.faculdadeidez.psa.db.entity.Escala;
import br.faculdadeidez.psa.db.entity.Viatura;
import br.faculdadeidez.psa.vo.EscalaVO;
import br.faculdadeidez.psa.vo.ViaturaVO;

/**
 * Classe que cont�m todos os m�todos espec�ficos de Escala
 *
 */
public class DAOEscala extends DAOFactory<Escala> {
	/**
	 * Construtor default
	 */
	public DAOEscala() {
		super();
	}
	/**
	 * Encapsulamento do m�todo find gen�rico
	 * Recebe a chave do objeto e procura a chave no banco de dados retornando uma entidade
	 * @param chave int
	 * @return EscalaVO
	 */
	public EscalaVO find(int chave){		
		return Escala.VO(super.find(Escala.class, chave));
	}
	/**
	 * Encapsulamento do m�todo findByField gen�rico
	 * Recebe o nome do campo e o valor a ser pesquisado nele
	 * @param campo String
	 * @param valor String
	 * @return List<EscalaVO>
	 */
	public List<EscalaVO> findByField(String campo, String valor){
		return ConvertList(super.findByField(Escala.class, campo, valor));
	}
	/**
	 * Encapsulamento do m�todo findAll gen�rico
	 * Retorna todas as entidades como um select * from
	 * @return List<EscalaVO>
	 */
	public List<EscalaVO> findAll(){
		return ConvertList(super.findAll(Escala.class));
	}
	/**
	 * M�todo que retorna todas as escalas ativas
	 * @return List<EscalaVO>
	 */
	@SuppressWarnings("unchecked")
	public List<EscalaVO> findAllActivated(){
		String strQuery = "SELECT e FROM Escala e WHERE e.ativo = 1";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		
		List<EscalaVO> resultList = ConvertList( query.getResultList());
		
		return resultList;
	}
		
	/**
	 * Encapsulamento do m�todo update gen�rico
	 * Atualiza a entidade no banco de dados
	 * @param vo EscalaVO
	 */
	public void update(EscalaVO vo){		
		super.update(new Escala(vo));
	}
	/**
	 * Encapsulamento do m�todo persist gen�rico
	 * Insere a entidade no banco de dados
	 * @param vo EscalaVO
	 */
	public void persist(EscalaVO vo){		
		super.persist(new Escala(vo));
	}
	
	/**
	 * Encapsulamento do m�todo remove gen�rico
	 * Remove a linha do banco de dados
	 * @param vo EscalaVO
	 */
	public void remove(EscalaVO vo){	
		super.remove(super.find(Escala.class, vo.getCodigo()));
	}
	
	/** 
	 * Verifica se as viaturas presentes na escala atual j� est�o cadastradas em outras escalas
	 * que est�o entre o per�odo inicial e final desta escala
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	/**
	 * Retorna se h� viaturas em outras escalas
	 */
	public String verificaViaturasNoutrasEscalasComMesmoDia(EscalaVO vo) {
		String strQuery = "SELECT v FROM Viatura v " + "JOIN v.escalas sv "
		+ "WHERE :dataInicioEscala between sv.dataInicial and sv.dataFinal AND sv.ativo = 1 AND v.ativo = 1 and sv.codigo <> " + vo.getCodigo();
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		query.setParameter("dataInicioEscala", vo.getDataInicial());
		
		List<Viatura> viaturas = query.getResultList();
		
		for(Viatura via : viaturas) { 
			// verifica se alguma das viaturas retornadas est�o dentre as viaturas que 
			// foram definidas nesta escala
			
			for(ViaturaVO viaEsc : vo.getViaturas()) { 
				if(viaEsc.getCodigo().equals(via.getCodigo()))
					return viaEsc.getCodigo();
			}
		}		
				
		return null;
	}
	
	/**
	 * M�todo que converte uma lista de entidades em Value Object
	 * @param lista List<Escala>
	 * @return List<EscalaVO>
	 */
	public List<EscalaVO> ConvertList(List<Escala> lista)
	{
		List<EscalaVO> newLista = new Vector<EscalaVO>();
		for(Escala set : lista)
			newLista.add(Escala.VO(set));		
		return newLista;
	}
	
}
