package br.faculdadeidez.psa.apresentacao.managedbean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.faculdadeidez.psa.vo.UsuarioVO;

public class UsuarioBean extends GenericoBean {
	private UsuarioVO usuario = new UsuarioVO();
	private String termoPesquisa = new String();
	private List<UsuarioVO> listaTudo;

	public UsuarioBean() {
		setLinkEditar("cadastroUsuario");
	}

	public String logon() {
		String mensagem = getFachada().logon(getUsuario().getLogin(),
				getUsuario().getSenha());
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	public void logout() {
		/**
		 * � feito o processo reverso do logon, no atributo logado coloca falso
		 * no objeto do usu�rio na sess�o coloco null e depois
		 * apago o mapeamento da sess�o
		 */
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.setAttribute("logado", false);
			session.setAttribute("currentUser", null);
			context.getExternalContext().getSessionMap().clear();
			System.out.println("Logout efetuado com sucesso");
		}
		
	}

	public String delete() {
		Object o = getElementoSelecionado();
		UsuarioVO usuarioDaVez = (UsuarioVO) o;
		String mensagem = getFachada().deleteUsuario(usuarioDaVez);
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	public String update() {
		UsuarioVO usuarioDaVez = (UsuarioVO) getElementoSelecionado();
		String mensagem = getFachada().updateUsuario(usuarioDaVez);
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	public String create() {
		String mensagem = getFachada().createUsuario(getUsuario());
		adicionaMensagemUsuario(mensagem);
		return mensagem;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioVO> getListaTudo() {

		if (listaTudo == null || listaTudo.isEmpty()
				|| getTermoPesquisa().isEmpty())
			setListaTudo(getFachada().listaUsuarios());
		else
			setTermoPesquisa(new String());
		return listaTudo;
	}

	public void setListaTudo(List<UsuarioVO> listaTudo) {
		this.listaTudo = listaTudo;
	}

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

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

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
		}
		else if (mensagem.equals("problemaRemover")) {
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
