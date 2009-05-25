package br.faculdadeidez.psa.apresentacao.managedbean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.faculdadeidez.psa.vo.UsuarioVO;

/**
 * ManagedBean da sess�o
 *
 */

public class SessaoBean extends GenericoBean{
	/**
	 * Representa o usu�rio da sess�o
	 */
	private UsuarioBean usuario;
	/**
	 * Define a permiss�o do usu�rio como moderador
	 */
	private boolean moderador;
	/**
	 * Define a permiss�o do usu�rio como coordenador
	 */
	private boolean coordenador;
	/**
	 * Define a permiss�o do usu�rio como operador
	 */
	private boolean operador;

	/**
	 * Construtor default
	 */
	public SessaoBean() {
	}

	/**
	 * M�todo getter do atributo usuario
	 * @return UsuarioBean
	 */
	public UsuarioBean getUsuario() {
		if (usuario==null){
		usuario = new UsuarioBean();
		HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		UsuarioVO usuarioVo = (UsuarioVO)sessao.getAttribute("currentUser");
		usuario.setUsuario(usuarioVo);
		}
		return usuario;
	}

	/**
	 * M�todo setter do atributo usuario
	 * @param usuario
	 */
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	/**
	 * M�todo que definir se o usu�rio est� logado
	 * @return
	 */
	public boolean isLogado(){
		HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(sessao.getAttribute("logado")==null)
			return false;
		return true;
	}
	
	/**
	 * M�todo getter do atributo moderador
	 * @return boolean
	 */
	public boolean isModerador(){
		if (getUsuario().getUsuario().getTipoPermissao()==2)
			setModerador(true);
		return moderador;
	}
	/**
	 * M�todo getter do atributo operador
	 * @return boolean
	 */
	public boolean isOperador(){
		if (getUsuario().getUsuario().getTipoPermissao()==1)
			setOperador(true);
		return operador;
	}
	/**
	 * M�todo getter do atributo coordenador
	 * @return boolean
	 */
	public boolean isCoordenador(){
		if (getUsuario().getUsuario().getTipoPermissao()==3)
			setCoordenador(true);
		return coordenador;
	}
	/**
	 * M�todo setter do atributo coordenador
	 * @param coordenador boolean
	 */
	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}


	/**
	 * M�todo setter do atributo operador
	 * @param moderador boolean
	 */
	public void setModerador(boolean moderador) {
		this.moderador = moderador;
	}


	/**
	 * M�todo setter do atributo operador
	 * @param operador boolean
	 */
	public void setOperador(boolean operador) {
		this.operador = operador;
	}

	
}
