package br.faculdadeidez.psa.apresentacao.managedbean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.faculdadeidez.psa.vo.UsuarioVO;

/**
 * ManagedBean de usu�rio
 * 
 */
public class UsuarioBean extends GenericoBean {
	/**
	 * Representa a entidade usu�rio
	 */
	private UsuarioVO usuario = new UsuarioVO();
	/**
	 * Representa a lista de usu�rios
	 */
	private List<UsuarioVO> listaTudo;

	/**
	 * Construtor default
	 */
	public UsuarioBean() {
	}

	/**
	 * M�todo que efetua o logon do usu�rio
	 * 
	 * @return String
	 */
	public String logon() {
		String mensagem = getFachada().logon(getUsuario().getLogin(),
				getUsuario().getSenha());
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	/**
	 * M�todo que efetua o logout do usu�rio 
	 * � feito o processo reverso do
	 * logon, no atributo logado coloca falso no objeto do usu�rio na sess�o
	 * coloco null e depois apago o mapeamento da sess�o
	 * 
	 * @return String
	 */
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			HttpSession session = (HttpSession) context.getExternalContext()
					.getSession(false);
			session.setAttribute("logado", false);
			session.setAttribute("currentUser", null);
			context.getExternalContext().getSessionMap().clear();
			System.out.println("Logout efetuado com sucesso");
		}

		adicionaMensagemUsuario("Voc� saiu do sistema!");

		return "logout";
	}

	/**
	 * M�todo que envia os dados do usu�rio para ser deletado/desativado
	 * 
	 * @return String
	 */
	public String delete() {
		Object o = getElementoSelecionado();
		UsuarioVO usuarioDaVez = (UsuarioVO) o;
		String mensagem = getFachada().deleteUsuario(usuarioDaVez);
		adicionaMensagemUsuario(mensagem);

		// for�a atualiza��o
		setListaTudo(null);

		return mensagem;
	}

	/**
	 * M�todo que envia os dados do usu�rio a ser atualizado
	 * 
	 * @return String
	 */
	public String update() {
		UsuarioVO usuarioDaVez = (UsuarioVO) getElementoSelecionado();
		String mensagem = getFachada().updateUsuario(usuarioDaVez);
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	/**
	 * M�todo que envia os dados para cadastrar o usu�rio
	 * 
	 * @return String
	 */
	public String create() {
		String mensagem = getFachada().createUsuario(getUsuario());
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	/**
	 * M�todo getter do atributo usuario
	 * 
	 * @return UsuarioVO
	 */
	public UsuarioVO getUsuario() {
		return usuario;
	}

	/**
	 * M�todo setter do atributo usuario
	 * 
	 * @param usuario
	 *            UsuarioVO
	 */
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	/**
	 * M�todo getter do atributo listaTudo
	 * 
	 * @return List<UsuarioVO>
	 */
	public List<UsuarioVO> getListaTudo() {
		if (listaTudo == null || canUpdate())
			setListaTudo(getFachada().listaUsuarios());
		return listaTudo;
	}

	/**
	 * M�todo setter do atributo listaTudo
	 * 
	 * @param listaTudo
	 *            List<UsuarioVO>
	 */
	public void setListaTudo(List<UsuarioVO> listaTudo) {
		this.listaTudo = listaTudo;
	}

	/**
	 * M�todo que envia os dados do usu�rio a ser pesquisado
	 */
	public void pesquisar() {
		if (getTermoPesquisa().isEmpty()) {
			setListaTudo(getFachada().listaUsuarios());
		} else {
			List<UsuarioVO> usuarios = getFachada().pesquisaUsuario(
					getTermoPesquisa());
			if (usuarios.isEmpty())
				adicionarMensagem("Usu�rio n�o encontrado");
			else {
				if (usuarios.size() > 1)
					adicionarMensagem("Foram encontrados " + usuarios.size()
							+ " resultados para a busca por "
							+ getTermoPesquisa());
				else
					adicionarMensagem("Foi encontrado " + usuarios.size()
							+ " resultado para a busca por "
							+ getTermoPesquisa());
				setListaTudo(usuarios);
			}
		}
	}

	/**
	 * M�todo que adiciona mensagens para serem mostradas ao usu�rio
	 * 
	 * @param mensagem
	 *            String
	 */
	private void adicionaMensagemUsuario(String mensagem) {
		if (mensagem.equals("atualizado"))
			adicionarMensagem("Atualizado com sucesso!");
		else if (mensagem.equals("usuarioInexistente")) {
			adicionarMensagem("Usu�rio n�o existe no banco de dados");
		} else if (mensagem.equals("dadoInvalido")) {
			adicionarMensagem("Estes dados n�o s�o v�lidos");
		} else if (mensagem.equals("cpfExistente")) {
			adicionarMensagem("Este CPF j� est� cadastrado!");
		} else if (mensagem.equals("rgExistente")) {
			adicionarMensagem("Este RG j� est� cadastrado!");
		} else if (mensagem.equals("usuarioExistente")) {
			adicionarMensagem("Este login j� existe");
		} else if (mensagem.equals("problemaAtualizar")) {
			adicionarMensagem("Houve um problema ao tentar atualizar,\n contacte o administrador");
		} else if (mensagem.equals("problemaInserir")) {
			adicionarMensagem("Houve um problema ao tentar criar o usu�rio,\n contacte o administrador");
		} else if (mensagem.equals("inserido")) {
			adicionarMensagem("Cadastrado com sucesso!");
			setUsuario(new UsuarioVO());
		} else if (mensagem.equals("removido")) {
			adicionarMensagem("Deletado com sucesso!");
		} else if (mensagem.equals("problemaRemover")) {
			adicionarMensagem("Houve um problema ao tentar remover,\n contacte o administrador");
		} else if (mensagem.equals("logado")) {
			adicionarMensagem("Logado com sucesso");
			setUsuario(new UsuarioVO());
		} else if (mensagem.equals("camposEmBranco")) {
			adicionarMensagem("N�o � permitido campos em branco");
		} else if (mensagem.equals("naoEncontrado")) {
			adicionarMensagem("Usu�rio ou senha inv�lido");
		} else {
			adicionarMensagem(mensagem);
		}
	}

}
