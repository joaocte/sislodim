package br.faculdadeidez.psa.db.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.faculdadeidez.psa.db.entity.Viatura;
import br.faculdadeidez.psa.vo.BairroVO;
import br.faculdadeidez.psa.vo.EscalaVO;
import br.faculdadeidez.psa.vo.SetorVO;
import br.faculdadeidez.psa.vo.ViaturaVO;

public class DAOViatura extends DAOFactory<Viatura> {
	public DAOViatura() {
		super();
	}

	public ViaturaVO find(String chave) {
		return Viatura.VO(super.find(Viatura.class, chave));
	}

	public List<ViaturaVO> findByField(String campo, String valor) {
		return ConvertList(super.findByField(Viatura.class, campo, valor));
	}

	public List<ViaturaVO> findAll() {
		return ConvertList(super.findAll(Viatura.class));

	}

	public List<ViaturaVO> findAllActivated() {
		String strQuery = "SELECT v FROM Viatura v WHERE v.ativo = 1";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);

		List<ViaturaVO> resultList = ConvertList(query.getResultList());

		return resultList;
	}

	public void update(ViaturaVO vo) {
		super.update(new Viatura(vo));
	}

	public void persist(ViaturaVO vo) {
		super.persist(new Viatura(vo));
	}

	public void remove(ViaturaVO vo) {
		Viatura viatura = super.find(Viatura.class, vo.getCodigo());
		super.remove(viatura);
	}

	/*
	 * Converte um List<Tipo1> para um List<Tipo2>
	 */
	private List<ViaturaVO> ConvertList(List<Viatura> lista) {
		List<ViaturaVO> newLista = new Vector<ViaturaVO>();
		for (Viatura set : lista)
			newLista.add(Viatura.VO(set));
		return newLista;
	}

	public List<Viatura> ConverteEntidade(List<ViaturaVO> lista) {
		List<Viatura> newLista = new Vector<Viatura>();
		for (ViaturaVO viatura : lista)
			newLista.add(super.find(Viatura.class, viatura.getCodigo()));
		return newLista;
	}
	
	public List<ViaturaVO> findViaturasEscala(EscalaVO escala) {

		Date data = new Date(System.currentTimeMillis());
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		try {
			data = formatter.parse(formatter.format(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data = null;
		}
		System.out.println(data);
		String strQuery = "SELECT v FROM Viatura v JOIN v.escalas sv"  
				+ "WHERE sv.codigo = :codigo ";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		query.setParameter("codigo", escala.getCodigo());

		List<ViaturaVO> resultList = ConvertList(query.getResultList());

		return resultList;
	}
	
	public List<ViaturaVO> findViaturasEscalaSetor(int setor) {

		Date data = new Date(System.currentTimeMillis());
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		try {
			data = formatter.parse(formatter.format(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data = null;
		}
		System.out.println(data);
		
		String strQuery = "SELECT v FROM Viatura v JOIN v.escalas sv JOIN sv.setor s "  
				+ "WHERE :dataInicio BETWEEN sv.dataInicial AND sv.dataFinal and s.codigo = " + setor;
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		query.setParameter("dataInicio", new Date());
		
		List<ViaturaVO> resultList = ConvertList(query.getResultList());

		return resultList;
	}
	
	public List<ViaturaVO> findViaturasEscalaAtivas() {

		Date data = new Date(System.currentTimeMillis());
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		try {
			data = formatter.parse(formatter.format(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data = null;
		}
		System.out.println(data);
		String strQuery = "SELECT v FROM Viatura v " + "JOIN v.escalas sv "
				+ "WHERE sv.dataInicial = :dataInicio AND v.ativo = 1";
		// +"sv.dataFim = :dataFim";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		query.setParameter("dataInicio", data);
		// query.setParameter("dataFinal", data);

		List<ViaturaVO> resultList = ConvertList(query.getResultList());

		return resultList;
	}
	
	public List<EscalaVO> findViaturasEscalaAtivas(String viatura) {

		Date data = new Date(System.currentTimeMillis());
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		try {
			data = formatter.parse(formatter.format(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data = null;
		}
		System.out.println(data);
		String strQuery = "SELECT sv FROM Viatura v " + "JOIN v.escalas sv "
				+ "WHERE sv.dataInicial = :dataInicio AND v.ativo = 1 AND v.codigo = '"+ viatura +"'";
		// +"sv.dataFim = :dataFim";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		query.setParameter("dataInicio", data);
		// query.setParameter("dataFinal", data);

		List<EscalaVO> resultList = new DAOEscala().ConvertList(query.getResultList());

		return resultList;
	}
	
	/**
	 * Retorna uma lista de todos os bairros das escalas atuais da viatura
	 * 
	 * @param viatura
	 * @param dataPesquisa
	 * @return
	 */
	public List<BairroVO> findViaturasEscalasBairros(String viatura, Calendar dataPesquisa) { 
		Date data = new Date(System.currentTimeMillis());
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		try {
			data = formatter.parse(formatter.format(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			data = null;
		}
		String strQuery = "SELECT v FROM Viatura v JOIN v.escalas sv "
				+ "WHERE :dataInicio BETWEEN sv.dataInicial AND sv.dataFinal AND v.codigo = '" + viatura + "'";
		// +"sv.dataFim = :dataFim";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		query.setParameter("dataInicio", dataPesquisa);
				
		List<String> resultList = new Vector<String>();
		List<ViaturaVO> viaturas = ConvertList(query.getResultList());
		
		for(ViaturaVO viat : viaturas) {
			for(EscalaVO escala : findViaturasEscalaAtivas(viat.getCodigo())) { 				
				SetorVO setor = new DAOSetor().find(escala.getSetor().getCodigo());
				return setor.getBairros();
			}
		}	

		return null;
	}
}
