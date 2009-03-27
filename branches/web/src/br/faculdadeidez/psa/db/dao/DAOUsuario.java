package br.faculdadeidez.psa.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.faculdadeidez.psa.db.entity.Usuario;
import br.faculdadeidez.psa.vo.UsuarioVO;

public class DAOUsuario extends DAOFactory<Usuario> {
	public DAOUsuario() {
		super();
	}

	public UsuarioVO find(int chave) {
		return super.find(Usuario.class, chave).toVO();
	}

	public void update(UsuarioVO vo){		
		super.update(new Usuario(vo));
	}
	
	public void persist(UsuarioVO vo){		
		super.persist(new Usuario(vo));
	}
	
	public void remove(UsuarioVO vo){		
		super.remove(new Usuario(vo));
	}
	
	
	
	public List<UsuarioVO> findByField(String campo, String valor) {
		List<Usuario> usuariosE = super.findByField(Usuario.class, campo, valor);
		List<UsuarioVO> usersVO= new ArrayList<UsuarioVO>();
		for (Usuario usuario : usuariosE){
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}

	
	public List<UsuarioVO> existsRg(String rg, String orgaoExpedidor){
		Query query = getManager().createQuery("select a from Usuario a where a.rg=\""+rg+"\" and a.orgExpeditor=\""+orgaoExpedidor+"\"");
		List<Usuario> result;
		result = query.getResultList();
		List<UsuarioVO> usersVO=new ArrayList<UsuarioVO>();
		for (Usuario usuario : result){
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}

	public List<UsuarioVO> findAll() {
		List<Usuario> usuariosE =super.findAll(Usuario.class);
		List<UsuarioVO> usersVO=new ArrayList<UsuarioVO>();
		for (Usuario usuario : usuariosE){
			usersVO.add(usuario.toVO());
		}
		return usersVO;
	}


}
