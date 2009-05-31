package br.faculdadeidez.psa.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.faculdadeidez.psa.db.entity.Usuario;
import br.faculdadeidez.psa.vo.UsuarioVO;

/**
 * Classe que cont�m todos os m�todos de banco de dados espec�ficos de usu�rio
 * 
 */
public class DAOUsuario extends DAOFactory<Usuario> {
	/**
	 * Construtor default
	 */
	public DAOUsuario() {
		super();
	}

	/**
	 * Encapsulamento do m�todo find gen�rico Recebe a chave do objeto e procura
	 * a chave no banco de dados retornando uma entidade
	 * 
	 * @param chave
	 *            int
	 * @return UsuarioVO
	 */
	public UsuarioVO find(int chave) {
		Usuario user = super.find(Usuario.class, chave);
		if (user != null)
			return user.toVO();
		return null;
	}

	/**
	 * Encapsulamento do m�todo update gen�rico Atualiza a entidade no banco de
	 * dados
	 * 
	 * @param vo
	 *            UsuarioVO
	 */
	public void update(UsuarioVO vo) {
		super.update(new Usuario(vo));
	}

	/**
	 * Encapsulamento do m�todo persist gen�rico Insere a entidade no banco de
	 * dados
	 * 
	 * @param vo
	 *            UsuarioVO
	 */
	public void persist(UsuarioVO vo) {
		super.persist(new Usuario(vo));
	}

	/**
	 * Encapsulamento do m�todo remove gen�rico Remove a linha do banco de dados
	 * 
	 * @param vo
	 *            UsuarioVO
	 */
	public void remove(UsuarioVO vo) {
		super.remove(new Usuario(vo));
	}

	/**
	 * Encapsulamento do m�todo findByField gen�rico Recebe o nome do campo e o
	 * valor a ser pesquisado nele
	 * 
	 * @param campo
	 *            String
	 * @param valor
	 *            String
	 * @return List<UsuarioVO>
	 */
	public List<UsuarioVO> findByField(String campo, String valor) {
		List<Usuario> usuariosE = super
				.findByField(Usuario.class, campo, valor);
		List<UsuarioVO> usersVO = new ArrayList<UsuarioVO>();
		for (Usuario usuario : usuariosE) {
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}

	/**
	 * M�todo que verifica a exist�ncia de um RG no banco de dados
	 * 
	 * @param rg
	 *            String
	 * @param orgaoExpedidor
	 *            String
	 * @return List<UsuarioVO>
	 */
	@SuppressWarnings("unchecked")
	public List<UsuarioVO> existsRg(String rg, String orgaoExpedidor) {
		Query query = getManager().createQuery(
				"select a from Usuario a where a.rg=\"" + rg
						+ "\" and a.orgExpeditor=\"" + orgaoExpedidor + "\"");
		List<Usuario> result;
		result = query.getResultList();
		List<UsuarioVO> usersVO = new ArrayList<UsuarioVO>();
		for (Usuario usuario : result) {
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}

	/**
	 * Encapsulamento do m�todo findAll gen�rico Retorna todas as entidades como
	 * um select * from
	 * 
	 * @return List<UsuarioVO>
	 */
	public List<UsuarioVO> findAll() {
		List<Usuario> usuariosE = super.findAll(Usuario.class);
		List<UsuarioVO> usersVO = new ArrayList<UsuarioVO>();
		for (Usuario usuario : usuariosE) {
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}

	/**
	 * Retorna uma lista de usu�rios ativos
	 * 
	 * @return List<UsuarioVO>
	 */
	@SuppressWarnings("unchecked")
	public List<UsuarioVO> findAllActived() {
		String strQuery = "SELECT u FROM Usuario u where u.ativo=1";
		EntityManager em = getManager();
		Query query = em.createQuery(strQuery);
		List<Usuario> usuariosE = query.getResultList();
		List<UsuarioVO> usersVO = new ArrayList<UsuarioVO>();
		for (Usuario usuario : usuariosE) {
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}

}
